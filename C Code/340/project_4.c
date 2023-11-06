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

//to find load #items in table / table size

typedef struct Node {
	int data;
	struct Node *next;
} Node_t;

typedef struct LinkedList {
	 Node_t* head;
	 Node_t* tail;
} LinkedList_t;

typedef struct HashTable {
	LinkedList_t* arrayofLL;
	int tableSize;
	int numOfItems;
} HashTable_t;

Node_t* CreateNode(int value){
	Node_t* newNode = (Node_t*)malloc(sizeof(Node_t));
	newNode->data = value;
	newNode->next = NULL;
	return newNode;
}

LinkedList_t* CreateArrayOfLists(int size){
	LinkedList_t* myArr = (LinkedList_t*)malloc(sizeof(LinkedList_t) * size);;
	int i = 0;
	while(i < size){
		LinkedList_t myLL = myArr[i];
		myLL.head = NULL;
		myLL.tail = NULL;
		i++;
	}
	return myArr;
}

HashTable_t* CreateTable(int size){
	HashTable_t* newHT = (HashTable_t*)malloc(sizeof(HashTable_t));
	newHT->arrayofLL = CreateArrayOfLists(size);
	newHT->tableSize = size;
	newHT->numOfItems = 0;
	return newHT;
}

int CalculateTableIndex(HashTable_t* table, int value){
	int i = value % table->tableSize;
	return i;
}
int Exists(LinkedList_t LL, int value){
	int booltru = 0;
	Node_t* tmp = LL.head;
	while(tmp != NULL && booltru == 0){
		if(tmp->data == value){
			booltru = 1;
		}
		else{
			tmp = tmp->next;
		}
	}
	return booltru;
}

void InsertTable(HashTable_t* table, int value){
	int i = CalculateTableIndex(table, value);
	Node_t* newNode = CreateNode(value);
	LinkedList_t* tmp = &(table->arrayofLL[i]);
	if(tmp->head == NULL){
		tmp->head = newNode;
		tmp->tail = newNode;
		table->numOfItems++;
	}
	else if(Exists(*tmp, value) == 0){
		tmp->tail->next = newNode;
		tmp->tail = newNode;
		table->numOfItems++;
	}	
}

void RemoveTable(HashTable_t* table, int value){
	int i = CalculateTableIndex(table, value);
	LinkedList_t* tmp = &(table->arrayofLL[i]);
	if(Exists(*tmp, value) == 1){
		Node_t* pred = tmp->head;
		Node_t* succ = pred->next;
		while(pred != NULL){
			if(pred->data == value){
				free(pred);
				pred = succ;
				table->numOfItems--;
			}
			else if(succ->data == value){
				pred->next = succ->next;
				free(succ);
				table->numOfItems--;
			}
			else{
				pred = succ;
				succ = succ->next;
			}
		}
	}
}

void PrintTable(HashTable_t* table){
	int i = 0;
	while(i < table->tableSize){
		LinkedList_t tmp = table->arrayofLL[i];
		printf("%d: ", i);
		Node_t* currNode = tmp.head;
		if(currNode != NULL){
			while(currNode->next != NULL){
				int val = currNode->data;
				printf("%d,", val);
				currNode = currNode->next;
			}
			printf("%d\n", currNode->data);
		}
		else{printf("\n");}
		i++;
	}
	double j = (double)table->numOfItems / table->tableSize;
	printf("load = %.3lf\n", j);
}

int main(void){
	int size;
	printf("Specify the size of the hash table: ");
	scanf("%d", &size);
	HashTable_t* myHT = CreateTable(size);
	PrintTable(myHT);
	int i = 0;
	while(i != 3){
		printf("Select the operation to perform:\n\n");
		printf("1. Insert a value\n");
		printf("2. Remove a value\n");
		printf("3. Exit\n\n");
		printf("Select an option: ");
		scanf("%d", &i);
		int value;
		if(i == 1){
			printf("Enter a value: ");
			scanf("%d", &value);
			InsertTable(myHT, value);
			PrintTable(myHT);
		}
		else if(i == 2){
			printf("Enter a value: ");
			scanf("%d", &value);
			RemoveTable(myHT, value);
			PrintTable(myHT);
		}
		else if(i == 3){
			printf("Good-bye\n");
		}
		else{
			printf("Not a Valid Option. Try again!\n");
		}
	}
	return 0;
}