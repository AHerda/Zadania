#include <stdio.h>

int main()
{
	int wiersze;
	printf("Wpisz liczbę wierszy: ");
	scanf("%d", &wiersze);
	for(int i=0; i<wiersze; i++)
	{
		printf("\n");
		for(int spacje=0; spacje<(wiersze-1-i); spacje++)
			printf(" ");
		printf("*");
		for(int j=0; j<i; j++)
			printf("**");
	}
	printf("\n");
	return 0;
}
