#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
	int data;
	struct Node* next;
}Node_t;

typedef struct LinkedList{
	Node_t* head;
	Node_t* tail;
}LinkedList_t;


Node_t* CreateAndInitNode(int value){
	Node_t* newNode = (Node_t*)malloc(sizeof(Node_t));
	newNode->data = value;
	newNode->next = NULL;
	return newNode;
}

void Append(LinkedList_t* currList, Node_t* newNode){
	if(currList->head == NULL){
		currList->head = newNode;
		currList->tail = newNode;
	}
	else{
		currList->tail->next = newNode;
		currList->tail = newNode;
	}
}

void Prepend(LinkedList_t* currList, Node_t* newNode){
	if(currList->head == NULL){
		currList->head = newNode;
		currList->tail = newNode;
	}
	else{
		newNode->next = currList->head;
		currList->head = newNode;
	}
}

Node_t* FindValue(LinkedList_t* list, int value){
	Node_t* searchVar = list->head;
	while(searchVar != NULL){
		if(searchVar->data != value){
			searchVar = searchVar->next;
		}
		else{
			break;
		}
	}
	if(searchVar == NULL){
		printf("Value not found.\n");
	}
	return searchVar;
}

Node_t* FindIndex(LinkedList_t* list, int index){
	Node_t* findVar = list->head; 
	if(index < 0){
		printf("Invalid index.\n");
		return NULL;
	}
	int i = 0;
	while(i != index && findVar->next != NULL){
		findVar = findVar->next;
		i++;
	}
	if(findVar->next == NULL && i != index){
		printf("Index not found.\n");
		return NULL;
	}
	return findVar;
}

void InsertAfter(LinkedList_t* currList, Node_t* newNode, Node_t* currNode){
	if(currList->head == NULL || currList->tail == currNode){
		Append(currList, newNode);
	}
	else{
		newNode->next = currNode->next;
		currNode->next = newNode;
	}
}

int InsertAfterValue(LinkedList_t* currList, Node_t* newNode, int value){
	Node_t* currNode = FindValue(currList, value);
	if(currNode == NULL){
		printf("Node not inserted,\n");
		return -1;
	}
	else{
		InsertAfter(currList, newNode, currNode);
	}
	Node_t* tester = FindValue(currList, newNode->data);
	if(tester == NULL){
		printf("Node not inserted.\n");
		return -1;
	}
	else{
		return 0;
	}
}

int InsertAfterIndex(LinkedList_t* currList, Node_t* newNode, int index){
	Node_t* currNode = FindIndex(currList, index);
	int retVal;
	if(currNode == NULL){
		printf("Node not inserted.\n");
		return -1;
	}
	else{
		retVal = InsertAfterValue(currList, newNode, currNode->data);
	}
	return retVal;
}

void Remove(LinkedList_t* list, Node_t* remNode){
	Node_t* prevNode = list->head;
	if(prevNode == remNode){
		list->head = prevNode->next;
		free(prevNode);
	}
	else{
		while(prevNode->next != remNode){
			prevNode = prevNode->next;
		}
		if(remNode != NULL){
			prevNode->next = remNode->next;
		}
	}
}

int RemoveByValue(LinkedList_t* list, int value){
	Node_t* remNode = FindValue(list, value);
	if(remNode == NULL){
		printf("Node not removed.\n");
		return -1;
	}
	else{
		Remove(list, remNode);
		return 0;
	}
}

int RemoveByIndex(LinkedList_t* list, int index){
	Node_t* remNode = FindIndex(list, index);
	if(remNode != NULL){
		Remove(list, remNode);
		return 0;
	}
	else{
		printf("Node not removed.\n");
		return -1;
	}
}

int findSize(LinkedList_t* list){
	int i = 0;
	Node_t* currNode = list->head;
	while(currNode != NULL){
		currNode = currNode->next;
		i++;
	}
	return i;
}

LinkedList_t* ReverseList(LinkedList_t* list){
	int indexSize = findSize(list);
	LinkedList_t* newList = (LinkedList_t*)malloc(sizeof(LinkedList_t));
	newList->head = NULL;
	newList->tail = NULL;
	for(int i = 0; i < indexSize; i++){
		Node_t* newNode = FindIndex(list, i);
		newNode = CreateAndInitNode(newNode->data);
		Prepend(newList, newNode);
	}
	return newList;
}

int IsPalindrome(LinkedList_t* list){ //Doesn't work properly says 0 to Everything
	LinkedList_t* InList = ReverseList(list);
	Node_t* RegList = list->head;
	Node_t* RevList = InList->head;
	while(RegList != NULL){
		if(RegList->data == RevList->data){
			RegList = RegList->next;
			RevList = RevList->next;
		}
		else{
			return 0;
		}
	}
	return 1;
}

void PrintList(LinkedList_t* list){
	int Size = findSize(list);
	if(Size == 0){
		printf("\n");
	}
	else if(Size == 1){
		printf("%d\n", list->head->data);
	}
	else{
		Node_t* prinNode = list->head;
		while(prinNode != list->tail){
			printf("%d, ", prinNode->data);
			prinNode = prinNode->next;
		}
		printf("%d\n", prinNode->data);
	}
}

int main(void){
	Node_t *myNode = CreateAndInitNode(11);
	if ((myNode->data == 11) && (myNode->next == NULL)) {
	 printf("CreateNode: Success. \n");
	} else {
	 printf("CreateNode: Failure. \n");
	} 									  // Should print: CreateNode: Success
	LinkedList_t *myList = (LinkedList_t*)malloc(sizeof(LinkedList_t));
	myList->head = NULL;
	myList->tail = NULL;
	InsertAfter(myList, myNode, NULL);
	PrintList(myList); 				      // Should print: 11
	myNode = CreateAndInitNode(22);
	int val1 = InsertAfterValue(myList, myNode, 11);
	myNode = CreateAndInitNode(33);
	val1 = InsertAfterValue(myList, myNode, 22);
	myNode = CreateAndInitNode(44);
	val1 = InsertAfterIndex(myList, myNode, 2);
	myNode = CreateAndInitNode(55);
	val1 = InsertAfterIndex(myList, myNode, 3);
	PrintList(myList); 					  // Should print: 11, 22, 33, 44, 55
	myNode = CreateAndInitNode(77);
	val1 = InsertAfterValue(myList, myNode, 66); // Should print: Value not found.
												 // Should print: Node not inserted.
	val1 = InsertAfterIndex(myList, myNode, 5);  // Should print: Index not found.
										  // Should print: Node not inserted.
	val1 = InsertAfterIndex(myList, myNode, -1); // Should print: Invalid index.
										  // Should print: Node not inserted.
	PrintList(myList); 					  // Should print: 11, 22, 33, 44, 55
	int rval = RemoveByValue(myList, 44);
	rval = RemoveByIndex(myList, 0);
	PrintList(myList); 					  // Should print: 22, 33, 55
	rval = RemoveByValue(myList, 11); 	  // Should print: Value not found.
										  // Should print: Node not removed.
	rval = RemoveByIndex(myList, 999); 	  // Should print: Index not found.
										  // Should print: Node not removed.
	rval = RemoveByIndex(myList, -5); 	  // Should print: Invalid index.
										  // Should print: Node not removed.
	LinkedList_t *revList = ReverseList(myList);
	PrintList(revList); 				  // Should print: 55, 33, 22
	myNode = CreateAndInitNode(22);
	val1 = InsertAfterValue(myList, myNode, 55);
	myNode = CreateAndInitNode(33);
	val1 = InsertAfterValue(myList, myNode, 55);
	int pal = IsPalindrome(myList);
	if (pal == 1) {
	 printf("Palindrome: Yes! \n");
	} else {
	 printf("Palindrome: No. \n");
	} 									  // Should print: Palindrome: Yes!
	PrintList(myList); 					  // Should print: 22, 33, 55, 33, 22
	myNode = CreateAndInitNode(88);
	val1 = InsertAfterValue(myList, myNode, 33);
	val1 = RemoveByValue(myList, 22);
	PrintList(myList);  				  // Should print: 33, 88, 55, 33, 22
	pal = IsPalindrome(myList);
	if (pal == 1) {
	 printf("Palindrome: Yes! \n");
	} else {
	 printf("Palindrome: No. \n");
	} 									  // Should print: Palindrome: No.
	rval = RemoveByIndex(myList, 1);
	rval = RemoveByIndex(myList, 1);
	rval = RemoveByIndex(myList, 1);
	rval = RemoveByIndex(myList, 1);
	rval = RemoveByIndex(myList, 1); 	  // Should print: Index not found.
										  // Should print: Node not removed.
	PrintList(myList); 					  // Should print: 33
	rval = RemoveByIndex(myList, 0);
	PrintList(myList); 					  // Should print:

	
}