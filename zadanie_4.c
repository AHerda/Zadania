#include <stdio.h>
#include <math.h>


int main()
{
	double wynik=1;
	double n=1;
	double chwilowe, chwilowe_2;
	while(n<=1000)
	{
		chwilowe=1;
		for(int i=0; i<10; i++)
		{
			chwilowe*=n;
			n++;
		}
		wynik*=pow(chwilowe, 0.001);
	}

	printf("Wynik działania to: %f\n", wynik);
	return 0;
}
