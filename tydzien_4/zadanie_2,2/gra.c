//main.c
#include <stdio.h>
#include "nagl.h"

int pewne[4] = {0, 0, 0, 0};
int moze[4] = {0, 0, 0, 0};
int liczby[4] = {0, 0, 0, 0};
int n_liczby = 0;

void zapytaj(int proba)
{
	for(int i = 0; i < 4; i += 1)
	{
		if(pewne[i] != 0)
			printf("%i", pewne[i]);
		else if(moze[i] != 0)
			printf("%i", moze[i]);
		else
			printf("%i", proba);
	}
}

void licz(int dobre, int pol_dobre, int proba)
{
	
	while(dobre + pol_dobre > n_liczby)
	{
		liczby[n_liczby] = proba;
		n_liczby += 1;
	}
	
	if(pol_dobre == 0 && dobre > 0)
		for(int i = 0; i < 4; i += 1)
			pewne[i] = moze[i];
	
	
}

int cheat_check(int dobre, int pol_dobre)
{
	if(dobre + pol_dobre > 4)
	{
		printf("Oszukujesz!");
		return 1;
	}
	
	int licznik = 0;
	for(int i = 0; i < 4; i += 1)
		if(pewne[i] != 0)
			licznik += 1;
	if(dobre < licznik)
	{
		printf("Oszukujesz!");
		return 1;
	}
	return 0;
}
