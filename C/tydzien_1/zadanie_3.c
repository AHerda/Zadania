#include <stdio.h>

int main()
{
	int wiersze;
	printf("Wpisz liczbę wierszy: ");
	scanf("%d", &wiersze);
	for(int i=0; i<wiersze; i++)
	{
		for(int j=0; j<(2*wiersze); j++)
			printf("*");
		printf("\n");
	}
	return 0;
}
