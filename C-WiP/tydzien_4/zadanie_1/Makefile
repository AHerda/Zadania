#Makefile

all: main

main: main.o match.o match_rek.o
	clang -o main main.o match.o match_rek.o
	
main.o: main.c
	clang -c main.c

match.o: match.c
	clang -c match.c

match_rek.o: match_rek.c
	clang -c match_rek.c

clean:
	rm -f main *.o *~
