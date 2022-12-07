#include "nagl.hpp"
#include <fstream>
#include <iostream>

using namespace std;

void Results::add(int index, int in, int iBn, int iUn, int iLn, int iCn, int iDn) {
    n[index] = in;
    Bn[index] = iBn;
    Un[index] = iUn;
    Ln[index] = iLn;
    Cn[index] = iCn;
    Dn[index] = iDn;
    cout << in << " " << iBn << " " << iUn << " " << iLn << " " << iCn << " " << iDn << " " << iDn-iCn << "\n";
}