//LiczbyPierwsze.cpp

#include <iostream>
#include "nagl.hpp"

LiczbyPierwsze::LiczbyPierwsze(int n) {
    pierwsze = (int*) malloc(n * sizeof(int));
    int indeks = 0;

    for(int i = 2; i <= n; i += 1) {
        bool isPrime = true;
        for(int j = 2; j * j <= i; j += 1) {
            if(i % j == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime == true) {
            *(pierwsze + (indeks * 4)) = i;
            indeks += 1;
        }
    }
}

LiczbyPierwsze::~LiczbyPierwsze() {
    free(pierwsze);
}

int LiczbyPierwsze::liczba(int n) {
    return *(pierwsze + (n * 4));
}