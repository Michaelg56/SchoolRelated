typedef struct node{
	int data;
	struct node* next;
}node_t;

typedef struct LinkedList{
	node_t* head;
	node_t* tail;
}linkedList_t;

void Append(linkedList_t* currList, node_t* newNode){
	if(currList->head == NULL){
		currList->head = newNode;
		currList->tail = newNode;
	}
	else{
		currList->tail->next = newNode
		currList->tail = newNode;
	}
}

void Prepend(linkedList_t* currList, node_t* newNode){
	if(currList->head == NULL){
		currList->head = newNode;
		currList->tail = newNode;
	}
	else{
		newNode->next = currList->head;
		currList->head = newNode;
	}
}

void InsertAfter(linkedList_t* currList, node_t* currNode, node_t* newNode){
		if(currList->head == NULL || currList->tail == currNode){
			Append(currList, newNode);
		}
		else{
			newNode->next = currNode->next;
			currNode->next = newNode;
		}
}

int main(void){
	node_t* NODE1 = (node_t*)malloc(sizeof(node_t));
	NODE1->data = 1;
	NODE1->next = NULL;
	
	node_t* NODE2 = (node_t*)malloc(sizeof(node_t)); //Develop a function for this
	NODE2->data = 2;
	NODE2->next = NULL;
	
	node_t* NODE3 = (node_t*)malloc(sizeof(node_t));
	NODE3->data = 3;
	NODE3->next = NULL;
	
	node_t* NODE4 = (node_t*)malloc(sizeof(node_t));
	NODE3->data = 4;
	NODE3->next = NULL;
	
	linkedList_t* myList = (linkedList_t*)malloc(sizeof(linkedList_t));
	myList->head = NULL;
	myList->tail = NULL;
	

	Append(myList, NODE1);
	Append(myList, NODE2);
	Append(myList, NODE3);
	
	Prepend(myList, NODE4);