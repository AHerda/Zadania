//newagent.c
#include <stdio.h>
#include "agents.h"

struct agent newagent(int x, int y)
{
	struct agent a = {x, y};
	return a;
}
