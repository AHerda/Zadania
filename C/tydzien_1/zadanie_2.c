#include <stdio.h>
#include <math.h>

int main()
{
	double a, b, c;
	printf("ax^2 + bx + c = 0\n");
	printf("Podaj liczby a, b oraz c:");
	scanf("%lf %lf %lf", &a, &b, &c);
	double delta = (b*b)-(4*a*c);
	if(delta<0)
		printf("Nie ma rozwiązań dla podancych liczb\n");
	if(delta==0)
		printf("Wynik to: %f\n", (-b)/(2*a));
	if(delta>0)
	{
		double delta2 = sqrt(delta);
		double wynik1 = (-b-delta2)/(2*a);
		double wynik2 = (-b+delta2)/(2*a);
		printf("Wyniki to: %f, %f\n", wynik1, wynik2);
	}
	return 0;
}
