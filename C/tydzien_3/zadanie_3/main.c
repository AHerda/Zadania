//main.c
#include <stdio.h>
#include "nagl.h"

int main(void)
{
	for(int i=1; i<50; i+=1)
		printf("n=%i: %i\n", i, phi(i));
	return 0;
}
