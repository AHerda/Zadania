#include <stdio.h>

int main()
{
	float n;
	printf("Wczytaj n: ");
	scanf("%f", &n);
	if(n==0)
	{
		printf("Śreednia to: NAN\n");
		return 0;
	}
	
	float x;
	float suma = 0;
	
	for(int i=0; i<n; i++)
	{
		printf("Wczytaj x%d: ", i+1);
		scanf("%f", &x);
		suma+=x;
	}
	printf("Średnia arytmetyczna to: %f\n", suma/n);
	return 0;
}
