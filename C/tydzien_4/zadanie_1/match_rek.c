//match.c
#include "nagl.h"
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool match_rek(char *wzorzec, char *lancuch)
{
	char *gwiazdka = "*";
	char *pytajnik = "?";
	if(*wzorzec == NULL && *lancuch == NULL)
	{
		return 1;
	}
	else if(*wzorzec == NULL || *lancuch == NULL)
	{
		return 0;
	}
	else if(*wzorzec == *lancuch || *wzorzec == *pytajnik)
	{
		return match_rek(wzorzec + 1, lancuch + 1);
	}
	if(*wzorzec == *gwiazdka)
	{
		while(match_rek(wzorzec + 1, lancuch) == 0 && *lancuch != NULL)
		{
			lancuch = lancuch + 1;
		}
		if(*lancuch == NULL)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	else
	{
		return 0;
	}
}
