#include<iostream>
using namespace std;
class A
{
public:
	A()
	{
		cout << "创建A" << endl;
	}
	~A()
	{
		cout << "析构A" << endl;
		getchar();
	}
};

class B
{
public:
	B()
	{
		cout << "创建B" << endl;
		
	}
	~B()
	{
		cout << "析构B" << endl;
		getchar();
	}
private:
	A a;
};
void main()
{
	B obj;
	system("pause");
}