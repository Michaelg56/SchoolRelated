#include <stdio.h>

void swap(int* n1, int* n2, int* n3, int* n4){
	int tmp = n1;
	*n1 = n2;
	printf("%d %d ", n1, tmp);
	*n2 = tmp;
	tmp = n3;
	*n3 = n4;
	*n4 = tmp;
	return 0;
}


int main(void){
	int num1, num2, num3, num4;
	printf("Enter four integer values: ");
	scanf("%d %d %d %d", &num1, &num2, &num3, &num4);
	printf("\nThe values that you entered: %d, %d, %d, %d\n", num1, num2, num3, num4);
	swap(&num1, &num2, &num3, &num4);
	printf("The values after the funcrtion call are: %d, %d, %d, %d", num1, num2, num3, num4);
}