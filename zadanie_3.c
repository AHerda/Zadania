#include <stdio.h>

int main()
{
	float n=1;
	float suma=0;
	while(suma<=10)
	{
		suma+=(1/n);
		n+=1;
	}
	printf("najmniejsza liczba spełniająca nierówność to: %f\n", n);
	return 0;
}
