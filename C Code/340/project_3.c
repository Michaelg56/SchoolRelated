/* ********************************************** *
 * Project #3 									  *
 * Author: Michael Gilbert 						  *
 * Course: ECE 340 (Data Structures and Systems)  *
 * Program tasked with creation of Priority		  *
 * Queue implemented with a dynamic array		  *
 * as a Max heap manipulated 					  *  
 * with Test Code supplied 		     			  *
 * ********************************************** */

#include <stdlib.h>
#include <stdio.h>

typedef struct ArrayList{
	int *array;
	int length;
	int allocationSize;
} ArrayList_t;

ArrayList_t* CreateAndInitPQueue(){
	ArrayList_t* Pque = (ArrayList_t*)malloc(sizeof(ArrayList_t));
	Pque->array = (int*)malloc(sizeof(int)*4);
	Pque->length = 0;
	Pque->allocationSize = 4;
	return Pque;
}

void Resize(ArrayList_t* pQue){
	pQue->allocationSize *= 2;
	int* newArray = (int*)malloc(sizeof(int) * pQue->allocationSize);
	for(int i = 0; i < pQue->length; i++){
		newArray[i] = pQue->array[i];
	}
	free(pQue->array);
	pQue->array = newArray;
}

int FindPos(ArrayList_t* pQue, int value, int i){
	while (i > 0 && pQue->array[(i-1)/2] < value){
		i = (i-1)/2;
	}
	return i;
}

int IsEmpty(ArrayList_t* pQue){
	if(pQue->length == 0){
		return 1;
	}
	else{return 0;}
}
	
void Enqueue(ArrayList_t* pQue, int value){
	if (pQue->length == pQue->allocationSize) {
        Resize(pQue);
    }

    pQue->array[pQue->length] = value;
    pQue->length++;

   
    int i = pQue->length - 1;
    while (i > 0 && pQue->array[(i - 1) / 2] < value) {
        pQue->array[i] = pQue->array[(i - 1) / 2];
        i = (i - 1) / 2;
    }
    pQue->array[i] = value;

}

int Dequeue(ArrayList_t* pQue){
	int rootValue = pQue->array[0];
    int lastValue = pQue->array[pQue->length - 1];
	pQue->array[0] = lastValue;
    pQue->length--;

    int i = 0;
	int tmp;
    while (i < pQue->length - 1) {
        int leftChild = i*2 + 1;
        int rightChild = i*2 + 2;
        int Parent = leftChild;

        if (rightChild < pQue->length && pQue->array[rightChild] > pQue->array[Parent]) {
            Parent = rightChild;
        }
		if (pQue->array[i] > pQue->array[Parent]){
			Parent = i;
		}
        if (Parent == i) {
            break;
        }

        tmp = pQue->array[i];
        pQue->array[i] = pQue->array[Parent];
        pQue->array[Parent] = tmp;
        i = Parent;
    }
    return rootValue;
}

int Peek(ArrayList_t* pQue){
	return pQue->array[0];
}

int GetLength(ArrayList_t* pQue){
	return pQue->length;
}

int GetHeight(ArrayList_t* pQue){
	int dep = -1;
	int len = pQue->length;
	while (len > 0){
		len /= 2;
		dep++;
	}
	if(dep == -1){
		return 0;
	}
	return dep;
}

void PrintPQueue(ArrayList_t* pQue){
	int i = 0;
	if(pQue->length == 0){
		printf("\n");
	}
	else{
		while(i != pQue->length-1){
			printf("%d ", pQue->array[i]);
			i++;
		}
		printf("%d\n", pQue->array[i]);
	}
}

int main(void){
	int value;
	ArrayList_t *pQueue = CreateAndInitPQueue();
	if (IsEmpty(pQueue)) {
	 printf("Priority Queue is empty.\n");
	} else {
	 printf("Priority Queue is not empty.\n");
	} // Output: Priority Queue is empty.
	Enqueue(pQueue, 52);
	Enqueue(pQueue, 39);
	PrintPQueue(pQueue); // Output: 52 39
	Enqueue(pQueue, 81);
	PrintPQueue(pQueue); // Output: 81 39 52
	Enqueue(pQueue, 17);
	Enqueue(pQueue, 46);
	value = Peek(pQueue);
	printf("Value = %d \n", value); // Output: Value = 81
	value = GetLength(pQueue);
	printf("Length = %d \n", value); // Output: Length = 5
	value = GetHeight(pQueue);
	printf("Height = %d \n", value); // Output: Height = 2
	PrintPQueue(pQueue); // Output: 81 46 52 17 39
	Enqueue(pQueue, 105);
	Enqueue(pQueue, 94);
	Enqueue(pQueue, 23);
	PrintPQueue(pQueue); // Output: 105 46 94 23 39 52 81 17
	value = GetHeight(pQueue);
	printf("Height = %d \n", value); // Output: Height = 3
	if (IsEmpty(pQueue)) {
		printf("Priority Queue is empty.\n");
	} 
	else {
		printf("Priority Queue is not empty.\n");
	} 				// Output: Priority Queue is not empty.
	value = Dequeue( pQueue);
	printf("Value = %d \n", value); // Output: Value = 105
	PrintPQueue(pQueue); // Output: 94 46 81 23 39 52 17
	value = GetHeight(pQueue);
	printf("Height = %d \n", value); // Output: Height = 2
	value = Peek(pQueue);
	printf("Value = %d \n", value); // Output: Value = 94
	value = Dequeue(pQueue);
	printf("Value = %d \n", value); // Output: Value = 94
	PrintPQueue(pQueue); // Output: 81 46 52 23 39 17
	value = Dequeue(pQueue);
	value = Dequeue(pQueue);
	value = GetLength(pQueue);
	printf("Length = %d \n", value); // Output: Length = 4
	value = GetHeight(pQueue);
	printf("Height = %d \n", value); // Output: Height = 2
	PrintPQueue(pQueue); // Output: 46 39 17 23
	value = Dequeue(pQueue);
	printf("Value = %d \n", value); // Output: Value = 46
	value = GetHeight(pQueue);
	printf("Height = %d \n", value); // Output: Height = 1
	PrintPQueue(pQueue); // Output: 39 23 17
	value = Dequeue(pQueue);
	printf("Value = %d \n", value); // Output: Value = 39
	value = GetLength(pQueue);
	printf("Length = %d \n", value); // Output: Length = 2
	PrintPQueue(pQueue); // Output: 23 17
	value = Dequeue(pQueue);
	printf("Value = %d \n", value); // Output: Value = 23
	value = GetHeight(pQueue);
	printf("Height = %d \n", value); // Output: Height = 0
	PrintPQueue(pQueue); // Output: 17
	value = Dequeue(pQueue);
	printf("Value = %d \n", value); // Output: Value = 17
	value = GetLength(pQueue);
	printf("Length = %d \n", value); // Output: Length = 0
	PrintPQueue(pQueue); 	// Output:
	if (IsEmpty(pQueue)) {
		printf("Priority Queue is empty.\n");
	} 
	else {
		printf("Priority Queue is not empty.\n");
	} 						// Output: Priority Queue is empty.
	printf("Done.\n"); 		// Output: Done.
	return 0;
}
