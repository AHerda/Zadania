#include "nagl.hpp"
#include <iostream>

Warehouse::Warehouse(int size) {
    boxy = new int[size];
    for(int i = 0; i < size; i+=1) {
        boxy[i] = 0;
    }
    this->size = size;
    puste = size;

    podwojne = 0;

    Bn=0;
    Un=0;
    Ln=0;
    Cn=0;
    Dn=0;
}

bool Warehouse::add(int urna, int kula) {
    int liczba = boxy[urna];
    bool collision = false;
    if(liczba == 0) {
        puste--;
    }
    else if(liczba == 1) {
        podwojne++;
        collision = true;
    }
    if(liczba == max) {
        max = liczba + 1;
    }
    boxy[urna] = liczba + 1;

    return Seria(collision, kula);
}


bool Warehouse::Seria(bool collision, int kula) {
    if(Bn == 0 && collision)  {
        Bn = kula;
    }
    if(kula == size) {
        Un = puste;
        Ln = max;
    }
    if(Cn == 0 && puste == 0) {
        Cn = kula;
    }
    if(podwojne == size) {
        Dn = kula;
        return false;
    }
    return true;
}

void Warehouse::zeruj(int n) {
    std::cout << n << " " << Bn << " " << Un << " " << Ln << " " << Cn << " " << Dn << " " << Dn-Cn << "\n";

    for(int i = 0; i < size; i+=1) {
        boxy[i] = 0;
    }

    puste = size;
    podwojne = 0;
    max = 0;

    Bn=0;
    Un=0;
    Ln=0;
    Cn=0;
    Dn=0;
}