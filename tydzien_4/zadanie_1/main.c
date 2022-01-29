//maun.c
#include "nagl.h"
#include <stdio.h>

int main(void)
{
	char wzor[20];
	char slowo[20];
	
	printf("Podaj wzorzec: ");
	scanf("%s", wzor);
	
	printf("Podaj slowo do porownania: ");
	scanf("%s", slowo);
	
	if(match_rek(wzor, slowo))
		printf("Takie same\n");
	else
		printf("Inne\n");
	
	return 0;
}
