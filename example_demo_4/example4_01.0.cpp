//#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
using namespace std;
class student
{
private:
	int num;
	char name[20];
	//static int total;(第三问修改）
public:
	static int total;//公有静态数据成员
	student(){ total++; };//构造函数，每定义一个新对象，total加一
	~student(){ total--; };//析构函数，每一个对象的生命期结束时，total减1
	student(int n, char *p = "wang");
	void Getname();
	int Getnum();

};
int student::total = 0;
//int student::total;(第一问修改)
//删除int student::total=0;(第二问修改)
student::student(int n, char *p)//带参构造函数，每定义一个新对象，total+1
{
	num = n;
	strcpy(name, p);
	total++;
}
void student::Getname()
{
	cout << name << endl;
}
int student::Getnum()
{
	return num;
}

int main()
{
	
	cout << "The number of all students:" << student::total << endl;
	student *p = new student(13);
	cout << "The number of all students:" << student::total << endl;
	cout << "The number of all students:" << p->total << endl;
	delete p;
	cout << "The number of all students:" << student::total << endl;
	student s[2];
	cout << "The number of all students:" << s[0].total << endl;
	cout << "The number of all students:" << s[1].total << endl;
	system("pause");
	return 0;
}
