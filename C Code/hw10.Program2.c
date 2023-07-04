#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node_t;

int main() {
    Node_t* node_ptr;
    node_ptr = (Node_t*) malloc(sizeof(Node_t));
    return 0;
}
