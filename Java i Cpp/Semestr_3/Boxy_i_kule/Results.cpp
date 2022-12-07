#include "nagl.hpp"
#include <fstream>

using namespace std;

void Results::add(int n, int Bn, int Un, int Ln, int Cn, int Dn) {
    this->n[index] = n;
    this->Bn[index] = Bn;
    this->Un[index] = Un;
    this->Ln[index] = Ln;
    this->Cn[index] = Cn;
    this->Dn[index] = Dn;

    index++;
}

void Results::write() {
    ofstream file;
    file.open("wyniki.txt");

    for(int i = 0; i < 5000; i++) {
        file << n << " " << Bn << " " << Un << " " << Ln << " " << Cn << " " << Dn << "\n"; 
    }
}