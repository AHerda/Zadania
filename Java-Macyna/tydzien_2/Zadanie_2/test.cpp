//test.cpp

#include <iostream>
#include "nagl.hpp"
#include <string>

using namespace std;

int main(int argc, char *argv[]) {
    int zakres;

    try {
        zakres = stoi(argv[1]);
        if(zakres >= 2) {
            LiczbyPierwsze dana(zakres);
            for(int i = 2; i < argc; i += 1) {
                try {
                    int n = stoi(argv[i]);
                    if(n >= 0 && n <= zakres && dana.liczba(n) > 0) {
                        cout << n << " - " << dana.liczba(n) << endl;
                    }
                    else {
                        cout << n << " - Liczba spoza zakresu" << endl;
                    }
                }
                catch(invalid_argument ia) {
                    cout << argv[i] << " - Nieprawidlowa dana" << endl;
                }
            }
        }
        else {
            cout << zakres << " - Nieprawidlowy zakres" << endl;
        } 
    }
    catch (invalid_argument ia) {
        cout << argv[1] << " - Nieprawidlowy zakres" << endl;
    }

    return 0;
}