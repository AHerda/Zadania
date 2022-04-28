#include <stdio.h>

int NWD(int a, int b)
{
	if(b!=0)
		return NWD(b, a%b);
	return a;
}

int main()
{
	float ilosc=0;
	for(int a=1; a<=1000; a++)
	{
		for(int b=1; b<=a; b++)
		{
			if(NWD(a, b)==1)
			{
				if(a!=b)
					ilosc+=2;
				else
					ilosc+=1;
			}
		}
		printf("%d;%f\n", a, ilosc/(a*a));
	}
	return 0;
}
