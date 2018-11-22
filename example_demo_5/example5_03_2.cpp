#include<iostream>
#include<ctime>
#include<cstdlib>
using namespace std;
class Dice
{
public:
	int run()
	{
		return (rand() % 6 + 1);
	}
	Dice();
	~Dice();
};
Dice::Dice(){}
Dice::~Dice(){}

class Gambler
{
public:
	void play()
	{
		int num1, num2, num3;
		num1 = a.run();
		num2 = b.run();
		num3 = c.run();
		if (num1 == num2&&num1 == num3)
			cout << num1 << " " << num2 << " " << num3 << " 豹子" << endl;
		if (num1 + num2 + num3>10)
			cout << num1 << " " << num2 << " " << num3 << " 小" << endl;
		if (num1 + num2 + num3 <= 10)
			cout << num1 << " " << num2 << " " << num3 << " 大" << endl;
	}
	Gambler();
	~Gambler();
private:
	Dice a, b, c;
};
Gambler::Gambler(){}
Gambler::~Gambler(){}
void main()
{
Gambler Jack;
srand(time(NULL));
for (int i = 0; i <= 100; i++)   //功能优化，扔一百次筛子
Jack.play();
system("pause");
}