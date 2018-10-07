#include<iostream>
#include<math.h>
using namespace std;
void main()
{
	int *p,*sign,*sign2,a=0,b=0,c=0;
	p = new int[20];
	sign = p;
	sign2 = p;
	for (int i = 0; i < 4; i++)
	{
		cout << "please input 4 integer:" << endl;
		cin >> *p;
		p++;
		cout << (int)p<<endl;
	}
	for (int i = 0; i < 4; i++)
	{
		if (*sign>0)a++;
		if(*sign == 0)b++;
		if(*sign<0) c++;
		sign++;
	}
	delete[]sign2;
	cout << "正数个数：" << a << " 0的个数：" << b << " 负数的个数：" << c << endl;
	system("pause");

}