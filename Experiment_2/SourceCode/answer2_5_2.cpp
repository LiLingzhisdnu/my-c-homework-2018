#include <iostream>
#include<math.h>
const double pi = 3.1415926;
using namespace std;
//���ܳ�
void perimeter(double &a, double &P)
{
	P = 2 * pi*a;
}
//�����
void area(double &a, double &S)
{
	S = pi*a*a;
}

void main()
{
	double a;
	cout << "please input radius of a circle :" << endl;
	cin >> a;
	double P;//�ܳ�
	double S;//�����
	perimeter(a,P);
	area(a,S);
	cout << "perimeter is" <<P << "\t" << "area is" << S << endl;
	system("pause");
}