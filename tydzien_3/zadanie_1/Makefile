#Makefile

all: main

main: main.o palin.o
	clang -o main main.o palin.o

palin.o: palin.c
	clang -c palin.c

clean:
	rm -f main *.o *~  
