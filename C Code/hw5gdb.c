/****************************************************
 * Program Description: Using nested loops. (HW #5) *
 * Author: Michael Gilbert							*
 * Course: ECE_240 (C Programming for Engineers)	*
 * **************************************************/

#include <stdio.h>
int main(){
    int x = 0, y = 0, z = 0;

    while(x < 10){
        while(y < 10){
            printf("z = %d \n", z);
            y = y + 1;
            z = z + 1;
        }
        x = x + 1;
        int y = 0;
    }
    return 0;
}