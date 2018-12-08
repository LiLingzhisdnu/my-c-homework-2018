#include"interface.h"
#include<cstring>
#include<iostream>
using namespace std;
Interface::Interface()
{
	munOfGr = 0;
	munOfPo = 0;
	munOfSt = 0;
	munOfTe = 0;
}
void Interface::diaplay()
{
	cout << "***********0.退    出**********" << endl;
	cout << "***********1.录入信息**********" << endl;
	cout << "***********2.浏览信息**********" << endl;
}
void Interface::run()
{
	int choice;
	do
	{
		diaplay();
		cout << "please input your choice : ";
		cin >> choice;
		while (choice<0||choice>3)
		{
			cout << "please input your choice again: ";
			cin >> choice;
		}//优化
		switch (choice)
		{
		case 0:
			break;
		case 1:
			Input();
			break;
		case 2:
			Output();
			break;
		default:
			break;
		}
	} while (choice);
}
void Interface::Input()
{
	int type;
	int i;
	char ch;
	do
	{
		cout << "你要输入的人员类型（1-学生 2-研究生 3-在职研究生 4-教师）：";
		cin >> type;
		while (type<0 || type>4)
		{
			cout << "please input your choice again: ";
			cin >> type;
		}//优化
		if (type == 1)
		{
			if (munOfSt == N)
				cout << "人数已满，无法继续录入！" << endl;
			else
			{
				for (i = 0; strcmp(st[i].Getname(), "00") != 0; i++)
				{
					st[i].Input();
					munOfSt++;
				}
			}
		}
		else if (type == 3)
		{
			if (munOfPo == N)
				cout << "人数已满，无法继续录入！" << endl;
			else
			{
				for (i = 0; strcmp(po[i].Getname(), "00") != 0; i++)
				{
					po[i].Input();
					munOfPo++;
				}
			}
		}
		else if (type == 2)
		{
			if (munOfGr == N)
				cout << "人数已满，无法继续录入！" << endl;
			else
			{
				for (i = 0; strcmp(gr[i].Getname(), "00") != 0; i++)
				{
					gr[i].Input();
					munOfGr++;
				}
			}
		}
		else if (type == 4)
		{
			if (munOfTe == N)
				cout << "人数已满，无法继续录入！" << endl;
			else
			{
				for (i = 0; strcmp(te[i].Getname(), "00") != 0; i++)
				{
					te[i].Input();
					munOfTe++;
				}
			}
		}
		cout << "继续输入(y/n)" << endl;
		cin >> ch;
		while (ch != 'y'&& ch!='n')
		{
			cout << "please input your choice again: ";
			cin >> ch;
		}//优化
	} while (ch == 'y');
}
void Interface::Output()
{
	int type;
	int i;
	cout << "你要查看的人员类型（1-学生 2-研究生 3-在职研究生 4-教师）：";
	cin >> type;
	while (type<0 || type>4)
	{
			cout << "please input your choice again: ";
			cin >> type;
	}//优化
	if (type == 1)
	{
			if (munOfSt == 0)
				cout << "没有学生数据！" << endl;
			else
			{
				for (i = 0; i<N; i++)
				{
					if (strcmp(st[i].Getname(), "00") != 0)
					st[i].Output();
				}
			}
	}
	 else if (type == 2)
	{
		if (munOfGr == 0)
			cout << "没有研究生数据！" << endl;
		else
		{
			for (i = 0; i<N; i++)
			{
				if (strcmp(gr[i].Getname(), "00") != 0)
				gr[i].Output();
			}
		}
	}
	if (type == 1)
	{
		if (munOfPo == 0)
			cout << "没有在职研究生数据！" << endl;
		else
		{
			for (i = 0; i<N; i++)
			{
				if (strcmp(po[i].Getname(), "00") != 0)
				po[i].Output();
			}
		}
	}
	if (type == 1)
	{
		if (munOfTe == 0)
			cout << "没有教师数据！" << endl;
		else
		{
			for (i = 0; i<N; i++)
			{
				if (strcmp(te[i].Getname(), "00") != 0)
				te[i].Output();
			}
		}
	}
}