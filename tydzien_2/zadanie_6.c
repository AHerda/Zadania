#include <stdio.h>
#include <math.h>

int Dzielniki(int a)
{
	int suma=0;
	for(int i=1; i<=sqrt(a); i++)
	{
		if(a%i == 0 && a!=i)
		{
			suma+=i;
			if(i!=1)
				suma+=a/i;
		}
	}
	return suma;
}

int main()
{
	printf("Liczby doskonałe:\n");
	int sumy[999];
	for(int i=1; i<1000; i++)
	{
		sumy[i-1]=Dzielniki(i);
		if(i==sumy[i-1])
			printf("%d\n", i);
	}
	
	printf("Liczby zaprzyjaźnone:\n");
	for(int i=1; i<1000; i++)
		if(sumy[i-1]<1000 && i==sumy[sumy[i-1]-1] && i<sumy[i-1])
			printf("%d, %d\n", i, sumy[i-1]);
	
	return 0;
}
