#include <stdio.h>

int main()
{
	int zlote;
	int grosze;
	printf("Podaj liczbe zloty: ");
	scanf("%d", &zlote);
	printf("Podaj liczbe gtroszy: ");
	scanf("%d", &grosze);
	int pieniadze[] = {200, 100, 50, 20, 10, 5, 2, 1};
	
	//zlote
	printf("	Banknoty:\n");
	for(int i=0; i<8; i++)
	{
		if(i==5)
			printf("	Monety:\n");
		if(zlote/pieniadze[i] > 0)
			printf("		%d x %d zł\n", zlote/pieniadze[i], pieniadze[i]);
		zlote=(zlote%pieniadze[i]);
	}
	
	//grosze
	for(int i=2; i<8; i++)
	{
		if(grosze/pieniadze[i] > 0)
			printf("		%d x %d gr\n", grosze/pieniadze[i], pieniadze[i]);
		grosze=(grosze%pieniadze[i]);
	}
	
	return 0;
}
