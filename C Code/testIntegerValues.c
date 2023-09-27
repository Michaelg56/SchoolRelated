/* ********************************************** *
 * Project #0			  						  *
 * Author: Michael Gilbert						  *
 * Course: ECE 340 (Data Structures and Systems)  *
 * Sample program to get and store Integers in    *
 * an array from the keyboard and determine       *
 * if they are divisible by 3 and 4				  *
 * ********************************************** */
#include <stdio.h>
#define MAX_SIZE 50

int main(void){
	int userSize;
	int userArray[MAX_SIZE];
	printf("Enter a Value less than or equal to 50: ");
	scanf("%d", &userSize);
	while(userSize > MAX_SIZE){
		printf("The number exceeds the maximum allowable value.\n");
		printf("Enter a Value less than or equal to 50: ");
		scanf("%d", &userSize);
	}
	for(int i = 0; i < userSize; i++){
		printf("Enter a single integer value: ");
		scanf("%d", &userArray[i]);
	}
	for(int j = 0; j < userSize; j++){
		printf("%d\t", userArray[j]);
		if((userArray[j] % 3 == 0) && (userArray[j] % 4 == 0)){
			printf("divisible by 3 and 4.\n");
		}
		else if(userArray[j] % 3 == 0){
			printf("Divisible by 3.\n");
		}
		else if(userArray[j] % 4 == 0){
			printf("Divisble by 4.\n");
		}
		else{printf("none.\n");}
	}
	printf("Done!\n");
	return 0;
}
	