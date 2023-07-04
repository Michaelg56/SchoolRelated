#include <stdio.h>

int main (void){
	char L1;
	char L2;
	char L3;
	char F1 ;

	printf("Enter three lower-case letters: ");
	scanf("%c %c %c", &L1,&L2,&L3);

	F1 = L1;
	if(L2 < F1){
		F1 = L2;
	}
	if(L3 < F1){
		F1 = L3;
	}
	printf("The letter that comes first in alphabetical order is %c\n", F1);
}