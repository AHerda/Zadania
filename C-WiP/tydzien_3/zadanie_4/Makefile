#Makefile

all: main

main: main.o distance.o north.o east.o south.o west.o newagent.o
	clang -o main main.o distance.o north.o east.o south.o west.o newagent.o -lm

main.o: main.c
	clang -c main.c

distance.o: distance.c
	clang -c distance.c

north.o: north.c
	clang -c north.c

east.o: east.c
	clang -c east.c

south.o: south.c
	clang -c south.c

west.o: west.c
	clang -c west.c

newagent.o: newagent.c
	clang -c newagent.c

clean:
	rm main *.o *~
