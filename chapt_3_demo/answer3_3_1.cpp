#include<iostream>
using namespace std;
class B
{
public:
	B()
	{
		x = y = 0;
		cout << "conl\t";
	}
	B(int i)
	{
		x = i; y = 0;
		cout << "com2\t";
	}
	B(int i, int j)
	{
		x = i; y = j;
		cout << "con'3\t";
	}
	~B()
	{
		cout << "Des\t";
	}
private:
	int x, y;
};
int main()
{
	B *ptr;
	ptr = new B[3];
	ptr[0] = B();
	ptr[1] = B(1);
	ptr[2] = B(2, 3);
	delete[]ptr;
	system("pause");
	return 0;
	
}

