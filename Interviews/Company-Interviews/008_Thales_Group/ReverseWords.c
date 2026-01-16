// Thales Group 2nd Technical Interview (Reverse words in a given String)
// https://www.geeksforgeeks.org/reverse-words-in-a-given-string/


#include <stdio.h>

int main()
{
    char s[] = "Hey how are you";
    printf("Old String = %s\n", s);
    int len = sizeof(s)/sizeof(s[0]);
    int i;
    int j = 0, k = 0;
    for(i = 0; i < len; i++)
    {
        if(s[i] == ' ' || i == len - 1)
        {
            int x, y;
            y = j-1;
            for(x = k; x < y; x++,y--)
            {
                char temp = s[x];
                s[x] = s[y];
                s[y] = temp;
            }
            j++;
            k = j;
        }
        else
        {
            j++;
        }
    }

    printf("New String = %s\n", s);

    for(i = 0, j = len - 2; i < j; i++, j--)
    {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    printf("New String = %s\n", s);
    
    return 0;
}