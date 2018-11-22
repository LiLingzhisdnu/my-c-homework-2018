#include<iostream>
using namespace std;
class A
{
public:
	A(int a);
	~A();

private:
	int x;
};

A::A(int a)
{
	x = a;
	cout << "A：x=" << a<<endl;
}

A::~A()
{
}

class B
{
public:
	B(int a, int b, int c);
	~B();

private:
	A a1, a2;
	int y;
};

B::B(int a, int b, int c) :a2(b), a1(a)
{
	y = c;
	cout << "B：y=" << c << endl;
}

B::~B()
{
}

void main()
{
	B obj(10,20,30);
	system("pause");
}