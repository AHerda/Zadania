#Makefile

all: main

main: main.o phi.o nwd.o
	clang -o main main.o phi.o nwd.o

phi.o: phi.c
	clang -c phi.c

nwd.o: nwd.c
	clang -c nwd.c

clean:
	rm -f main *.o *~
