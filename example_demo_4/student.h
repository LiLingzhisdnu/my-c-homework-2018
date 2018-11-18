#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<string>
//#include<windows.h>
using namespace std;
#define SIZE 80
class student
{
private:
	char *name;//姓名
	char ID[19];//身份证
	char number[10];//学号
	char speciality[20];//专业
	int age;//年龄
	static int counts;//实际有效的学生个数，小于等于对象的个数
public:
	student();//无参构造函数
	student(char *n, char *id, char *num, char *spe, int ag);//带默认参数的构造函数
	student(const student &per);//拷贝构造函数
	~student();//析构函数
	char *Getname()const;//提取姓名
	char *GetID();//提取身份证
	char *Getnumber();//提取学号
	char *Getspec();//提取专业
	int Getage()const;
	void display()const;
	//int Getage();//提取年龄
	//void display();//输出学生的信息
	void insert();
	void Delete();
	void input();//输入学生的信息
	static int Getcounts();//新增的静态成员函数
};