#include<iostream>
#include<string>
using namespace std;
class Student
{
public:
	Student(int m, char *n)
	{
		age = m;
		name = new char[strlen(n) + 1];
		strcpy(name, n);
	}
	~Student()
	{
		cout << "delete it." << name << endl;
		delete[]name;
	}
	void disp()
	{
		cout << "Student is name is " << name << ",age is" << age << endl;
	}
private:
	int age;
	char *name;
};

int main()
{
	Student A(18, "wujiang");
	Student B(19, "xiayv");
	A.disp();
	B.disp();
	system("pause");
	return 0;
}
