#include <iostream>

int main(void)
{
    int a = 1;
    {
        int b = 2;
        {
            int b = 3;  //위의 b와 다름
            int c = a + b;
            printf("%d\n", c);  //4
        }
        {
            int d = a + b;  //괄호 밖 b = 2
            printf("%d\n", d);  //3
        }
    }
    return 0;
}