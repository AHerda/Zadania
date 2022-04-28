#Makefile

all: main

main: main.o gra.o
	clang -o main main.o gra.o
	
main.o: main.c
	clang -c main.c

gra.o: gra.c
	clang -c gra.c

clean:
	rm -f main *.o *~
