#include <stdio.h>

int main(){
    int x = 256;
    int* px = NULL;
    px = &x;
    printf("------------------\n");
    printf("%p\n", &px);
    printf("%d\n", px);
    printf("%p\n",&x);
    printf("%d\n",x);
    printf("%d\n", *px);
    printf("------------------\n");

    char c = 'Z';
    char* pc = NULL;
    pc = &c;
    printf("%p\n", &pc);
    printf("%c\n", pc);
    printf("%p\n",&c);
    printf("%c\n",c);
    printf("%c\n", *pc);
    printf("------------------\n");

    return 0;
}