//match.c
#include "nagl.h"
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool match(char *wzorzec, char *lancuch)
{
	char *gwiazdka = "*";
	char *pytajnik = "?";
	char *zapas;
	
	while(*wzorzec != NULL && *lancuch != NULL)
	{
		if(*wzorzec == *lancuch || *wzorzec == *pytajnik)
		{
			wzorzec = wzorzec + 1;
			lancuch = lancuch + 1;
		}
		else if(*wzorzec == *gwiazdka)
		{
			wzorzec = wzorzec + 1;
			zapas = wzorzec;
			while(*zapas != *gwiazdka && *zapas != NULL)
			{
				zapas = zapas + 1;
			}
			if(*zapas == NULL)
			{
				while(*wzorzec != *lancuch && *lancuch != NULL)
				{
					lancuch = lancuch + 1;
				}
				if(*lancuch == NULL)
				{
					return 0;
				}
				else
				{
					wzorzec = wzorzec + 1;
					lancuch = lancuch + 1;
				}
			}
			else
			{
				///więcejj niż jedna gwiazdka
			}
		}
		else
		{
			return 0;
		}
	}
	if(*wzorzec == NULL && *lancuch == NULL)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}
