
#include<iostream>
#include<string>
#include<stdlib.h>
using namespace std;
class person
{
private:
	int age;
	char *name;
public:
	person(int i, char *na = "zhuli");//构造函数
	~person();
	void print();//重载函数，用于输出普通成员函数
	void print()const;//重载函数，用于输出常成员函数，const参与重载
	void ModifyAge();//用于修改年龄的普通成员函数
};
person::person(int n, char *na)
{
	age = n;
	name = new char[strlen(na) + 1];
	strcpy(name, na);
}
person::~person()
{
	delete[]name;
}
void person::print()
{
	cout << "age:" << age << "name:" << name << endl;
	cout << "This is const print()." << endl;
}//第一问修改
/*void person::print()const
{
	cout << "age:" << age << "name:" << name << endl;
	cout << "This is const print()." << endl;
}第二问修改*/
void person::ModifyAge()
{
	age++;
}
int main()
{
	const person p1(17, "wu");//定义常对象必须初始化
	cout << "Output const object p1" << endl;
	p1.print();//定义对象常成员函数
	person p2(18, "zhang");
	cout << "Output general object p2" << endl;
	p2.ModifyAge();//可以修改数据成员
	p2.print();//普通对象调用普通函数
	system("pause");
	return 0;
}
