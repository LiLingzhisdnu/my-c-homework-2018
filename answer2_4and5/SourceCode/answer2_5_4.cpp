#include<iostream>
#include<math.h>
using namespace std;
struct student
{
	char name[10];
	int year;
	float score;
};
float checkAgeScore(int age, float score)
{
	if (age<16 || age>25) throw age;
	if (score<0 || score>5) throw score;
	if (age >= 16 && age <= 25 && score >= 0 && score <= 5)
	{
		float score2 = 20 * score;
		return score2;
	}
}
void main()
{
	student A;
	float score2;
	cout << "please input name" << endl;
	cin >> A.name;
	cout << "please input age(16！！25)" << endl;
	cin >> A.year;
	cout << "please input C++ grade(0！！5)" << endl;
	cin >> A.score;
	try
	{
		score2=checkAgeScore(A.year, A.score);
		cout << "name:" << A.name << " age:" << A.year << " score:" << score2 << endl;
	}
	catch (int)
	{
		cout << "Warning:Age is out of the question!";
	}
	catch (float)
	{
		cout << "Warning:Score is out of the question!";
	}
	system("pause");
}