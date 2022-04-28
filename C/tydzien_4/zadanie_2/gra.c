//gra.c

#include <stdio.h>
#include "nagl.h"
#include <stdbool.h>
#include <stdlib.h>
#include <time.h>

void losuj_kod(int *kod)
{
	srand(time(NULL));
	for(int i = 0; i < 6; i += 1)
	{
		*(kod + i) = (rand() % 6) + 1;
	}
}



bool sprawdz(int *do_sprawdzenia, int *kod)
{	
	int dobre = 0;
	int pol_dobre = 0;
	bool temp[4] = {0, 0 ,0 ,0};
	for(int i = 0; i < 4; i += 1)
	{
		if(do_sprawdzenia[i] == kod[i])
		{
			dobre += 1;
		}
		else
		{
			for(int j = 0; j < 4; j += 1)
			{
				if(do_sprawdzenia[i] == kod[j] && temp[j] == 0 && do_sprawdzenia[j] != kod[j])
				{
					temp[j] = 1;
					pol_dobre += 1;
					break;
				}
			}
		}
	}
	if(dobre == 4)
	{
		printf("\nBrawo wygrales!!!");
		return 1;
	}
	else
	{
		printf("\nDobre kolory: %i\n", dobre);
		printf("Dobre ale nie na swoim miejscu: %i\n", pol_dobre);
		return 0;
	}
}
