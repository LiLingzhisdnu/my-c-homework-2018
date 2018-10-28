#include<iostream>
#include<string>
using namespace std;
class Student
{
public:
	Student(char *pSpec=0);
	Student(const Student&people);
	~Student();
	void show();

private:
	char *specidlty;

};
Student::Student(const Student&people)
{
	if (people.specidlty)
	{
		specidlty = new char[strlen(people.specidlty) + 1];
		strcpy(specidlty, people.specidlty);
	}
	else
	{
		specidlty = 0;
	}
}
Student::Student(char *pSpec)
{
	if (pSpec)
	{
		specidlty = new char[strlen(pSpec) + 1];
		strcpy(specidlty, pSpec);
	}
	else specidlty = 0;
}

Student::~Student()
{
	if (specidlty)
		delete[]specidlty;
}
void Student::show()
{
	cout << "specoalty=" << specidlty << endl;
}
void main()
{
	Student zhang("computer");
	Student wang(zhang);
	zhang.show();
	wang.show();
	system("pause");
}