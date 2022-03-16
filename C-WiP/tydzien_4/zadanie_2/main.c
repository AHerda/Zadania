//main.c

#include <stdio.h>
#include "nagl.h"

int main(void)
{
	int kod[4];
	losuj_kod(kod);
	int moj[4];
	
	do
	{
		printf("\nWpisz 1 liczbę: ");
		scanf("%i", &moj[0]);
		
		printf("Wpisz 2 liczbę: ");
		scanf("%i", &moj[1]);
		
		printf("Wpisz 3 liczbę: ");
		scanf("%i", &moj[2]);
		
		printf("Wpisz 4 liczbę: ");
		scanf("%i", &moj[3]);
		
	}while((sprawdz(moj, kod) + 1) % 2);
	return 0;
}
