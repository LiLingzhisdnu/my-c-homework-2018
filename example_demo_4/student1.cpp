#define _CRT_SECURE_NO_WARNINGS
#include"student.h"
int student::counts = 0;
student::student()//调用了无参的构造函数
{
	name = NULL;
	age = 0;
}
student::student(char *n, char *id, char *num, char *spe, int ag)//调用参数的构造函数
{
	if (n)
	{
		name = new char[strlen(n) + 1];//避免浅拷贝
		strcpy(name, n);
	}
	strcpy(ID, id);
	strcpy(number, num);
	strcpy(speciality, spe);
	age = ag;
	counts++;
}
student::student(const student &per)
{
	if (per.name)
	{
		name = new char[strlen(per.name) + 1];
		strcpy(name, per.name);
	}
	strcpy(ID, per.ID);
	strcpy(number, per.number);
	strcpy(speciality, per.speciality);
	age = per.age;
	counts++;
}
student::~student()//调用析构函数
{
	if (name)
		delete[]name;
	counts--;
}
char *student::Getname()const//提取姓名
{
	return name;
}
char *student::GetID()//提取身份证
{
	return ID;
}
char *student::Getnumber()//提取学号
{
	return number;
}
char *student::Getspec()//提取专业
{
	return speciality;
}
int student::Getage()const//提取年龄
{
	return age;
}
void student::display()const//输出学生的信息
{
	cout << "姓名:" << name << endl;
	cout << "身份证:" << ID << endl;
	cout << "学号:" << number << endl;
	cout << "专业:" << speciality << endl;
	cout << "年龄:" << age << endl;
}
void student::input()//输入学生的信息
{
	char n[10];
	cout << "输入姓名:";
	cin >> n;
	if (name)
		delete[]name;
	name = new char[strlen(n) + 1];
	strcpy(name, n);
	cout << "输入身份证:" << endl;
	cin >> ID;
	cout << "输入年龄:" << endl;
	cin >> age;
	cout << "输入专业:" << endl;
	cin >> speciality;
	cout << "输入学号:" << endl;
	cin >> number;
	counts++;
}
void student::insert()//新增
{
	if (!age)//当对象的age成员值为0时，在此调用input函数重载
		input();
}
void student::Delete()//新增
{
	age = 0;
	counts--;//只简单的将age置0而不移动数组元素
}
int student::Getcounts()//新增的静态成员函数，专门用来访问静态数据成员
{
	return counts;

}