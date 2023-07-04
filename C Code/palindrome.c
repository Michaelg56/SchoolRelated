#include <stdio.h>

int main(void){
	int size;
	int i = 0;
	int isPally = 0;

	printf("Enter the number of integers in the list: ");
	scanf("%d", &size);
	int pally[size];
	int invPally[size];
	printf("Enter the list of integers: ");
	while(i < size){
		scanf("%d", &pally[i]);
		i++;
	}
	int k = 0;
	for(int j = size-1; j > -1; j--){
		invPally[k] = pally[j];
		k++;
	}
	for(int l = 0; l < size; l++){
		if(pally[l] == invPally[l]){
			continue;
		}
		else{
			isPally = -1;
			break;
		}
	}
	printf("\n");
	if(isPally == -1){
		printf("No. The list is not a palindrome.\n");
	}
	else{printf("Yes. The list is a palindrome. \n");}
	return 0;
}