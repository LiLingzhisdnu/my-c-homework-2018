#include"people.h"
//Data类的函数实现
void Data::Set(int y, int m,int d)
{
	year = y;
	month = m;
	day = d;
}
int Data::GetYear()
{
	return year;
}
int Data::GetMonth()
{
	return month;
}
int Data::GetDay()
{
	return day;
}
//Person类的函数实现
Person::Person()
{
	strcpy(name, "00");
}
char *Person::Getname()
{
	return name;
}
void Person::Input()
{
	cout << "请输入信息\n";
	cout << "姓 名：";
	cin >> name;
	cout << "编 号：";
	cin >> number;
	cout << "出生日期（年份 月份 日期）：";
	int y, m, d;
	cin >> y >> m >> d;
	birthday.Set(y, m, d);//组合的使用
	cout << "性别（m/f）：";
	cin >> sex;
	while (sex != 'm'&&sex != 'd')
	{
		cout << "请重新输入性别" << endl;
		cout << "性别（m/f）：";
		cin >> sex;
	}//优化
}
void Person::Output()
{
	cout << "姓名" << name << endl;
	cout << "编号" << number << endl;
	cout << "性别:" ;
	if (sex=='m')
		cout << "女" << endl;
	if (sex == 'f')
		cout << "男" << endl;
	cout << "出生日期" << birthday.GetYear() << '-' << birthday.GetMonth() << '-' << birthday.GetDay() << endl;
}
//Student类的函数实现
void Student::Input()
{
	cout << "请输入信息\n";
	Person::Input();
	cout << "专 业：";
	cin >> speciality;
}
void Student::Output()
{
	Person::Output();
	cout << "专 业" << speciality << endl;
}
//Graduate类的函数实现
void Graduate::Input()
{
	cout << "请输入信息\n";
	Student::Input();
	cout << "研究课题：";
	cin >> researchTopic;
}
void Graduate::Output()
{
	Student::Output();
	cout << "研究课题：" << researchTopic << endl;
}
//Student类的函数实现
void Teacher::Input()
{
	cout << "请输入信息\n";
	Person::Input();
	cout << "职 称：";
	cin >> academicTitle;
}
void Teacher::Output()
{
	Person::Output();
	cout << "职 称" << academicTitle << endl;
}
//Student类的函数实现
void PostgraduateOnJob::Input()
{
	cout << "请输入信息\n";
	Graduate::Input();
	cout << "职 称：";
	cin >> academicTitle;
}
void PostgraduateOnJob::Output()
{
	Graduate::Output();
	cout << "职 称" << academicTitle << endl;
}