#include <stdio.h>

int main()
{
	float n=0;
	float suma=0;
	while(suma<=10)
	{
		n+=1;
		suma+=(1/n);
/*niezmiennik:
suma=1+1/2+1/3+...+1/n
dowód:
1. n=0 => suma_0=0
2. zał. ind.:
	dla dowolnego n
	suma=1+1/2+...+1/n
działania wykonywane w pętli:
	n' = n+1
	suma' = suma + 1/n'
d-d:
	suma' = suma + 1/n'
	      = 1 + 1/2 +...+ 1/n + 1/(n+1) (zał.ind.)
	      = 1 + 1/2 +...+ 1/(n'-1) + 1/n'
Na mocy zasady indukcji teza jest prawdziwa*/
	}
	printf("najmniejsza liczba spełniająca nierówność to: %f\n", n);
	return 0;
}
