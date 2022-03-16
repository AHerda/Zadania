//phi.c
#include <stdio.h>
#include "nagl.h"

int phi(long int n)
{
	int suma=0;
	for(int i=1; i<=n; i+=1)
		if(nwd(i, n)==1)
			suma+=1;
	return suma;
}
