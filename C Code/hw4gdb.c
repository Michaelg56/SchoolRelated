/* *********************************************************
 * Program Description: Calculate the area of a Rectangle. *
 * Author: Michael Gilbert                                 *
 * Course: ECE 240 (C Programming for Engineers)           *
 ***********************************************************/


#include <stdio.h> 

int main(void){
	int len, wid;
	int area = 0;

	printf("Enter the length and width of a rectangle: ");
	scanf("%d %d", &len, &wid);

	area = len*wid;
	printf("The area of the rectangle is %d. \n", area);

	return 0;
}