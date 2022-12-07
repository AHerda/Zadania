#include "nagl.hpp"
#include <fstream>
#include <iostream>

using namespace std;

Results::Results() {
    index = 0;
}

void Results::add(int n, int Bn, int Un, int Ln, int Cn, int Dn) {
    cout << n << " " << Bn << " " << Un << " " << Ln << " " << Cn << " " << Dn << "\n";

    this->n[index] = n;
    this->Bn[index] = Bn;
    this->Un[index] = Un;
    this->Ln[index] = Ln;
    this->Cn[index] = Cn;
    this->Dn[index] = Dn;

    index+=1;
}

void Results::write() {
    ofstream file;
    file.open("wyniki.txt");

    for(int i = 0; i < 5000; i+=1) {
        file << n << " " << Bn << " " << Un << " " << Ln << " " << Cn << " " << Dn << "\n"; 
    }

    file.close();
}