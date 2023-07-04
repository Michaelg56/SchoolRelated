#include <stdio.h>

int main(void){
	int val = 0;
	int binary[20];
	int binaryVal = 0;
	while(val <= 0){
		printf("Enter a positve non-zero Integer: ");
		scanf("%d", &val);
		if(val <= 0){
			printf("WARNING VALUE WAS NOT A POSITIVE NON-ZERO INTEGER!!\n");
		}
	}
	int i =0;
	while(val > 0){
		if(val % 2 != 0){
			binary[i] = 1;
		}
		else{
			binary[i] = 0;
		}
		val /= 2;
		i++;
	}
	int multi = 1;
	for(int j = i-1; j > -1; j--){
		binaryVal += binary[j] * multi;
		multi *= 10;
	}
	printf("The binary equivalent value is: %d\n", binaryVal);
}