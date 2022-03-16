//north.c
#include <stdio.h>
#include "agents.h"

void north(struct agent *a)
{
	(*a).y += 1;
}
