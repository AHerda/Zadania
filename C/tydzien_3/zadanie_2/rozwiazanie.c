// rozwiazanie.c

#include <stdio.h>
#include "nagl.h"

double rozwiazanie(double a, double b, double eps)
{
	if((b-a)/2<eps)
		return (a+b)/2;
	else if(f(a)*f((a+b)/2)<0)
		return rozwiazanie(a, (a+b)/2, eps);
	else
		return rozwiazanie((a+b)/2, b, eps);
}
