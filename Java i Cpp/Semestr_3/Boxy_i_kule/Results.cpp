#include "nagl.hpp"
#include <fstream>
#include <iostream>

using namespace std;

void Results::add(int index, int in, int iBn, int iUn, int iLn, int iCn, int iDn) {
    cout << index << endl;
    n[index] = in;
    Bn[index] = iBn;
    Un[index] = iUn;
    Ln[index] = iLn;
    Cn[index] = iCn;
    Dn[index] = iDn;
}

void Results::write() {
    ofstream file;
    file.open("wyniki.txt");


    for(int i = 0; i < 5000; i+=1) {
        //cout << n[i] << " " << Bn[i] << " " << Un[i] << " " << Ln[i] << " " << Cn[i] << " " << Dn[i] << " " << (Dn[i]-Cn[i]) << "\n";
        file << n[i] << " " << Bn[i] << " " << Un[i] << " " << Ln[i] << " " << Cn[i] << " " << Dn[i] << " " << (Dn[i]-Cn[i]) << "\n"; 
    }

    file.close();
}