// WierszTrojkataPascala.cpp
#include <iostream>
#include "nagl.hpp"

WierszTrojkataPascala::WierszTrojkataPascala(int n) {
    liczby = new int[n + 1];
    int licznik = Silnia(n);

    for(int i = 0; i <= n; i += 1) {
        liczby[i] = licznik/(Silnia(i) * Silnia(n - i));
    }
}

WierszTrojkataPascala::~WierszTrojkataPascala() {
    delete[]liczby;
}

int WierszTrojkataPascala::Silnia(int n) {
    int wynik = 1;

    for(int i = 1; i <= n; i += 1) {
        wynik *= i;
    }

    return wynik;
}

int WierszTrojkataPascala::Liczba(int n) {
    return liczby[n];
}