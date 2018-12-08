#ifndef _PERSON
#define _PERSON
#include<iostream>
#include<string>
using namespace std;
class Data
{
public:
	void Set(int y, int m, int d);
	int GetYear();
	int GetMonth();
	int GetDay();
	Data();
	~Data();
protected:
	int year;
	int month;
	int day;
};//时间
class Person
{
public:
	Person();
	~Person();
	void Input();
	void Output();
	char *Getname();
protected:
	char name[20];
	char number[10];
	char sex;
	Data birthday;
};//人类

class Student:public virtual Person
{
public:
	Student();
	~Student();
	void Input();//同名冲突
	void Output(); //同名冲突
protected:
	char speciality[20];
};//学生

class Graduate:virtual public Student
{
public:
	Graduate();
	~Graduate();
	void Input();//同名冲突
	void Output(); //同名冲突
protected:
	char researchTopic[50];//研究课题
};//研究生

class Teacher :public virtual Person
{
public:
	Teacher();
	~Teacher();
	void Input();//同名冲突
	void Output(); //同名冲突
protected:
	char academicTitle[20];//教师职称
};//老师

class PostgraduateOnJob :public Teacher,public Graduate
{
public:
	void Input();//同名冲突
	void Output(); //同名冲突
};//在职研究生
#endif