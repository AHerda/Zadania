//main.c
#include <stdio.h>
#include "nagl.h"

int main(void)
{
	int dobre = 0, pol_dobre = 0;
	int proba = 1;
	
	printf("Wymysl 4 cyfrowy kod z liczb 1-6 i zapamietaj go\n");
	
	for(;;)
	{
		zapytaj(proba);
		
		printf("Ilosc dobrych cyfr na dobrych miejscach: ");
		scanf("%i", &dobre);
		
		printf("Ilosc dobrych cyfr na złych miejscach: ");
		scanf("%i", &pol_dobre);
		
		proba += 1;
		if(cheat_check(dobre, pol_dobre))
			return 0;
		
		else if(dobre == 4)
		{
			printf("Wygralem!!!!");
			return 0;
		}
	}
	return 0;
}
