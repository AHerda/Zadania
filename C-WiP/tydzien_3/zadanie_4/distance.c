//distance.c
#include <stdio.h>
#include <math.h>
#include "agents.h"

double distance(struct agent a1, struct agent a2)
{
	int x = a1.x-a2.x;
	int y = a1.y-a2.y;
	return pow(x*x + y*y, 0.5);
}
