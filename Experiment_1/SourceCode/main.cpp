/*************************************************
** ���� : ѧ���ɼ�����ϵͳ
** ���� : LiLingzhi/saintlilz@163.com
** �汾 : 2018-9-13 / 17:13
/**************************************************/

#include<iostream>
#include<stdlib.h>
#include<Windows.h>
#include"score.h"
using namespace std;

void main()
{
	cout << "******************************\n";
	cout << "       ѧ���ɼ��������ϵͳ        \n";
	cout << "           Lingzhi Li         \n";
	cout << "******************************\n\n";

	int N = 0;//ѧ������
	char c[20];//��ѯѧ��
	SS  *pstu = NULL;
	cout << "��ʼ���ݶ�ȡ������������>>>)" << endl;
	
	cout << "��������Ҫ��ȡѧ��������" << endl;
	cin >> N;
	pstu = readDataFromFile( N);
	//����ѧ���ܳɼ�
	calcuScore(pstu, N);
	//����ѧ���ɼ�����
	sortScore(pstu, N);
	//�����������ѧ����Ϣ
	printOut(pstu, N);
	//д��Excel�ĵ�
	putintoExcel(pstu,N);
	//����ѧ�ż��ɲ�ѯ����
    inSpect(pstu,N);
	//�󷽲ƽ��ֵ
	calculate(pstu,N);
	system("pause");


}