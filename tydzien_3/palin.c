#include <stdio.h>
#include "nagl.h"
#include <string.h>

bool palindrom(char napis[])
{
	int i = 0;
	int j = strlen(napis) - 1;
	while(i != j || i+1!=j)
	{
		if(slowo[i]==slowo[j])
		{
			i += 1;
			j += 1;
		}
		else
		{
			printf("Slowo \"%c\" nie jest palindromem");
			return FALSE;
		}
		if(i == j || i+1 == j)
		{
			printf("Slowo \"%c\" jest palindromem");
			return TRUE;
		}
	}
}
