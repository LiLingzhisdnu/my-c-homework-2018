#include<iostream>
using namespace std;
class circle
{
private:
	double radius;//定义圆的半径
	const double PI;//定义一个常数据成员
public:
	circle(double r = 0) :PI(3.1415926)//只能通过初始化列表初始化常数据成员
	{
		//PI = 3.1415926;(第一问修改)
		radius = r;
	}
	double area();//求圆的面积
	double circumference();//求圆的周长
};
