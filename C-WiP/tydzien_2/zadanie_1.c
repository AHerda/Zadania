#include <stdio.h>
#include <assert.h>

int main()
{
	int zlotowki;
	int grosze;
	int pieniadze[]={200, 100, 50, 20, 10, 5, 2, 1};
	printf("Podaj liczbę złoty: ");
	scanf("%d", &zlotowki);
	assert(zlotowki>=0);
	printf("Podaj liczbę groszy: ");
	scanf("%d", &grosze);
	assert(grosze>=0);
	
	printf("	Banknoty:\n");
	for(int i=0; i<8; i++)
	{
		if(i==5)
			printf("	Monety:\n");
		if((zlotowki/pieniadze[i])>0)
			printf("%d x %d zł\n", zlotowki/pieniadze[i], pieniadze[i]);
		zlotowki=zlotowki%pieniadze[i];
	}
	
	for(int i=2; i<8; i++)
	{
		if((grosze/pieniadze[i])>0)
			printf("%d x %d gr\n", grosze/pieniadze[i], pieniadze[i]);
		grosze=grosze%pieniadze[i];
	}
	
	return 0;
}
