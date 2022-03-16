#include <stdio.h>

int main(void)
{
	char abra[] = "ABRAKADABRA";
	for(int i=0; i<11; i++)
	{
		for(int x=0; x<i; x++)
			printf(" ");
		for(int j=0; j<(11-i); j++)
		{
			printf("%c", abra[j]);
			printf(" ");
		}
	printf("\n");
	}
	return 0;
}
