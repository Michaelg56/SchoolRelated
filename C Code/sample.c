#include<stdio.h>

int main(void) {
	const double PI = 3.14159;
	double radius, area, circumference;
	
	printf("Enter the radius of a circle: ");
	scanf("%lf", &radius);
	
	area = PI * radius * radius;
	circumference = 2 * PI * radius;
	
	printf("\n");
	printf("Area = %lf, and Circumference = %lf \n", area, circumference);
	
	return 0;
}