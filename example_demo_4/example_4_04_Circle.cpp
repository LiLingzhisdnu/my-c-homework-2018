#include"example4_04_Circle.h"
double circle::area()//求圆的面积
{
	//radius *= 2;(第一问修改）
	//double a = GetRadius();(第三问修改）
	return PI*radius*radius;
}
double circle::circumference()//求圆的周长
{
	return 2 * PI*radius;
}
double circle::GetRadius()const
{
	//radius *= 2;(第一问修改）
	//double a = area();(第二问修改）
	return radius;
}