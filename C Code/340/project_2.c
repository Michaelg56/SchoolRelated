/* ********************************************** *
 * Project #2 									  *
 * Author: Michael Gilbert 						  *
 * Course: ECE 340 (Data Structures and Systems)  *
 * Program tasked with creation of stack		  *
 * implemented with a dynamic array				  *
 * manipulated with Test Code supplied 		      *
 * ********************************************** */

#include <stdio.h>
#include <stdlib.h>

typedef struct ArrayList{
	int* array;
	int length;
	int allocationSize;
}ArrayList_t;

ArrayList_t* CreateAndInitStack(){
	ArrayList_t* myList = (ArrayList_t*)malloc(sizeof(ArrayList_t));
	myList->length = 0;
	myList->allocationSize = 4;
	myList->array = (int*)malloc(4 * sizeof(int));
	return myList;
}
void Resize(ArrayList_t* stk){
	stk->allocationSize *= 2;
	int* newRay = (int*)malloc(stk->allocationSize*sizeof(int));
	int i = 0;
	while(i != stk->length){
		newRay[i] = stk->array[i];
		i++;
	}
	free(stk->array);
	stk->array = newRay;
}

void Push(ArrayList_t* stk, int value){
	if(stk->length == stk->allocationSize){
		Resize(stk);
	}
	stk->array[stk->length] = value;
	stk->length++;
}

int Pop(ArrayList_t* stk){
	stk->length--;
	int dat = stk->array[stk->length];
	return dat;
}

int Peek(ArrayList_t* stk){
	return stk->array[stk->length - 1];
}

int IsEmpty(ArrayList_t* stk){
	if(stk->length == 0){
		return 1;
	}
	else{return 0;}
}

int GetLength(ArrayList_t* stk){
	return stk->length;
}

void PrintStack(ArrayList_t* stk){
	for(int i = stk->length - 1; i > 0; i--){
		printf("%d ", stk->array[i]);
	}
	printf("%d\n", stk->array[0]);
}

int main(void){
	ArrayList_t *stack = CreateAndInitStack();
	if (IsEmpty(stack)) {
	printf("Stack is empty.\n");
	} else {
	 printf("Stack is not empty.\n");
	} 								// Output: Stack is empty.
	Push(stack, 101);
	Push(stack, 202);
	Push(stack, 303);
	int value = Peek(stack);
	printf("Value = %d.\n", value); // Output: Value = 303
	value = Pop(stack);
	value = Pop(stack);
	Push(stack, 404);
	Push(stack, 505);
	Push(stack, 606);
	PrintStack(stack); 				// Output: 606 505 404 101 prints additional 0
	Push(stack, 707);
	if(IsEmpty(stack)) {
	 printf("Stack is empty.\n");
	} else {
	 printf("Stack is not empty.\n");
	} 								// Output: Stack is not empty.
	Push(stack, 909);
	Push(stack, 1010);
	value = Peek(stack);
	printf("Value = %d.\n", value); // Output: Value = 1010
	Push(stack, 2020);
	Push(stack, 3030);
	Push(stack, 4040);
	PrintStack(stack); 				// Output: 4040 3030 2020 1010 909 707 606 505 404 101
	value = Pop(stack);
	value = Pop(stack);
	value = Pop(stack);
	value = GetLength(stack);
	printf("Size = %d.\n", value); // Output: Size = 7
	value = Pop(stack);
	value = Pop(stack);
	printf("Value = %d.\n", value); // Output: Value = 909
	value = GetLength(stack);
	printf("Size = %d.\n", value);  // Output: Size = 5
	PrintStack(stack); 				// Output: 707 606 505 404 101
	value = Pop(stack);
	value = Pop(stack);
	value = Pop(stack);
	Push(stack, 1111);
	Push(stack, 2222);
	value = GetLength(stack);
	printf("Size = %d.\n", value);  // Output: Size = 4
	while(!(IsEmpty(stack))) {
	 PrintStack(stack);
	 value = Pop(stack);
	} 								// Output: 2222 1111 404 101
									// Output: 1111 404 101
									// Output: 404 101
									// Output: 101
	value = GetLength(stack);
	printf("Value = %d.\n", value); // Output: Value = 0
	printf("Done.\n");	// Output: Done.
}