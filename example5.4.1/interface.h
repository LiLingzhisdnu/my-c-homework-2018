#ifndef _INTERFACE
#define _INTEREACE
#include"people.h"
const int N = 3;
class Interface
{
protected:
	Student st[N];
	int munOfSt;
	Graduate gr[N];
	int munOfGr;
	Teacher te[N];
	int munOfTe;
	PostgraduateOnJob po[N];
	int munOfPo;
public:
	Interface();
	void diaplay();
	void run();
	void Input();
	void Output();
};
#endif