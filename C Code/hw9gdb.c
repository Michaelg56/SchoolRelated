
/* ***************************************************** *
 * Program Description: Passing Pointers. (HW #9)        *
 * Author: Michael Gilbert                               *
 * Course: ECE 240 (C Programming for Engineers)         *
 * ***************************************************** */

#include <stdio.h>

int* getInt(void);

int main()
{
    int *myInt = NULL;
	printf("Before function call \n\n");
    myInt = getInt();
	printf("After function call \n");
    printf("main: %d \n", *myInt);

    return 0;
}

int* getInt(void) {
    int x;
    x = 1234;
	printf("In function \n");
    printf("getInt: %d \n\n", x);
    return(&x);
}