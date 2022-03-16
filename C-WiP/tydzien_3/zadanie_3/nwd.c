//nwd.c
#include <stdio.h>
#include "nagl.h"

int nwd(int a, int b)
{
	if(b>0)
		return nwd(b, a%b);
	return a;
}
