#include <stdio.h>
#include <stdint.h>

void callCLogInfoMessage(char const * const message)
{
    // printf("\nMessage : %s\n", message);
    printf("\n%s\n", message);
}

void callCLogInfoMessageRF(uint8_t const * const message, uint8_t receivedLength)
{
    printf("Received Length : %d\n", receivedLength);
    char *buff = (char*)message;
    printf("Print Data: ");
    int length = receivedLength;
    for(int i = 0; i < length; i++, buff++)
    {
        printf("%02x ", *(uint8_t*)buff);
    }
}

void sendData(void *BuffPtr, uint8_t length)
{
    int packetno = 1;
    int total_packets = length / 44;
    if(length % 44 > 0)
    {
        total_packets = total_packets + 1;
    }

    // printf("%d", total_packets);

    int k = 0;
    while (k < total_packets)
    {
        uint8_t newBuff[46];

        newBuff[0] = 0x09;

        newBuff[1] = ((total_packets << 4) & 0xF0) | (packetno & 0x0F);
        // printf("\n%x\n", newBuff[1]);
        packetno++;

        int templength = 44;
        if(length < 44)
        {
            templength = length % 44;
        }
        else
        {
            length = length - 44;
        }

        for(int i = 2; i < templength + 2; i++, BuffPtr++)
        {
            newBuff[i] = *(uint8_t*)BuffPtr;
        }
        k++;

        callCLogInfoMessageRF(newBuff, templength + 2);
    }
}

int main()
{
    printf("\n...............................................................\n");
    // uint8_t BuffPtr[24] = {0x32, 0x98, 0xf3, 0x45, 0x01, 0x44, 0x89, 0x98, 0xf3, 0x45, 0x12, 0x43, 0x45, 0x00, 0x12, 0x45, 0x00, 0x32, 0x89, 0x98, 0x43, 0x4f, 0x11, 0x00};
    // sendData(BuffPtr, 24);
    uint8_t BuffPtr[48] = {0x89, 0x98, 0xf3, 0x45, 0x00, 0x44, 0x89, 0x98, 0xf3, 0x45, 0x12, 0x43, 0x45, 0xff, 0x12, 0x45, 0x00, 0x32, 0x89, 0x98, 0x43, 0x4f, 0x11, 0x34, 0x98, 0xf3, 0x45, 0x00, 0x44, 0x89, 0x98, 0xf3, 0x45, 0x12, 0x43, 0x45, 0xff, 0x12, 0x45, 0x00, 0x32, 0x89, 0x98, 0x43, 0x34, 0x45, 0x47, 0x48};
    sendData(BuffPtr, 48);
    printf("\n...............................................................\n");
    return 0;
}