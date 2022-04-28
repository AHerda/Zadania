#include <stdio.h>
#include <math.h>
#include "nagl.h"

int main(void)
{
	for(int i=1; i<9; i++)
	{
		printf("epsilon=10^-%d: %.10f\n", i, rozwiazanie(2, 4, pow(10, -i)));
	}
	return 0;
}
