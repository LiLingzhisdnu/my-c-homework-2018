#include"circle.h"
double circle::area()//求圆的面积
{
	//PI = 3.1415926;(第二问迟到)
	return PI*radius*radius;
}
double circle::circumference()//求圆的周长
{
	return 2 * PI*radius;
}
