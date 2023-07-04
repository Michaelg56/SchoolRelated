#include <stdio.h>

typedef struct Student_Struct{
	char Name[30];
	int studID;
	float exams[3];
	double gpa;
} Student;

Student getStud(){
	Student s;
	printf("Enter Student Name: ");
	scanf("%s", s.Name);
	printf("\nEnter Student ID: ");
	scanf("%d", &s.studID);
	printf("\nEnter the Students 3 exams: ");
	scanf("%f %f %f", &s.exams[0], &s.exams[1], &s.exams[2]);
	printf("\n");
	return s;
}

void calcGPA(Student* s){
	s -> gpa = 0.25*s->exams[0] + 0.25*s->exams[1] + 0.5*s->exams[2];
}
void printStud(Student s){
	printf("Student Name: %s\tStudent ID: %d\tStudent GPA: %0.2lf\n",s.Name,s.studID,s.gpa);
}

int main(void){
	Student CurrStudents[5];
	for(int i = 0; i < 5; i++){
		Student newStud = getStud();
		calcGPA(&newStud);
		CurrStudents[i] = newStud;
	}
	for(int i = 0; i < 5; i++){
		printStud(CurrStudents[i]);
	}
	return 0;
}