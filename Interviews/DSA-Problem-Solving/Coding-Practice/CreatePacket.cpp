#include <stdio.h>
#include <stdlib.h>
#include <string.h>

class Packet
{
    private:
        int sqn_num = 0;
    public:
    bool createPacket(const char *data, int dataLen, char * packet, int * packetLen)
    {
        memset(packet, 0, (*packetLen)*sizeof(*packet)); 

        int header = 2 + 4 + 2;
        int checksum = 4;
        int packet_length = header + dataLen + checksum;
        *packetLen = packet_length;     // updating packet size

        if(packet_length > 100)
        {
            return false;
        }

        packet[0] = 0x02;
        packet[1] = 0x02;

        sqn_num++;
        packet[2] = (sqn_num & 0xF000) >> 12;
        packet[3] = (sqn_num & 0xF00) >> 8;
        packet[4] = (sqn_num & 0xF0) >> 4;
        packet[5] = (sqn_num & 0x0F);

        packet[6] = (dataLen & 0xF0) >> 4;
        packet[7] = (dataLen & 0x0F);

        int i, j;
        for(i = 8, j = 0; i < 8 + dataLen; i++, j++)
        {
            packet[i] = data[j];
        }
        
        // uint32_t const checksum_data = crc32.calc((uint8_t const *)new_packet, 5 + dataLen);
        int checksum_data = 1234;

        packet[i] = (checksum_data & 0xF000) >> 12;
        packet[i + 1] = (checksum_data & 0xF00) >> 8;
        packet[i + 2] = (checksum_data & 0xF0) >> 4;
        packet[i + 3] = (checksum_data & 0x0F);
        
        return true;
    }
};



int main()
{
    int dataLen = 5;
    char data[dataLen];

    data[0] = 'a';
    data[1] = 'b';
    data[2] = 'c';
    data[3] = 'd';
    data[4] = 'e';

    int packetLen = 100;    // assuming maximum packet size
    char packet[packetLen];

    bool success;

    Packet p1;

    for (int j = 0; j < 5; j++)
    {
        success = p1.createPacket(data, dataLen, packet, &packetLen);

        if(success == true)
        {
            for(int i = 0; i < packetLen; i++)
            {
                printf("%x ", packet[i]);
            }
            printf("\n");
        }
        else
        {
            printf("Create Packet is Unsuccessful\n");
        } 
    }
}