#include <stdio.h>
#include "nagl.h"
#include <string.h>
#include <stdbool.h>

bool Palindrom(char napis[])
{
	int i = 0;
	int j = strlen(napis) - 1;
	while(i != j || i+1!=j)
	{
		if(napis[i]==napis[j])
		{
			i += 1;
			j -= 1;
		}
		else
		{
			printf("Slowo \"%s\" nie jest palindromem\n", napis);
			return 0;
		}
		if(i == j || i+1 == j)
		{
			printf("Slowo \"%s\" jest palindromem\n", napis);
			return 1;
		}
	}
	return 0;
}
