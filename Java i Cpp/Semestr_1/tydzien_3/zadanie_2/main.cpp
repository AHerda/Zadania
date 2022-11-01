//main.cpp

#include <iostream>
#include "nagl.hpp"
#include <string>

using namespace std;

int main(int argc, char *argv[]) {
    try {
        int wiersz = stoi(argv[1]);

        if(wiersz >= 0) {
            WierszTrojkataPascala dana(wiersz);

            for(int i = 2; i < argc; i += 1) {
                try {
                    int n = stoi(argv[i]);

                    if(n >= 0 && n <= wiersz) {
                        cout << n << " - " << dana.Liczba(n) << endl;
                    }
                    else {
                        cout << n << " - Liczba spoza wiersza" << endl;
                    }
                }
                catch(invalid_argument ia) {
                    cout << argv[i] << " - Nieprawidlowa dana" << endl;
                }
            }
        }
        else {
            cout << wiersz << " - Nieprawidlowy wiersz" << endl;
        } 
    }
    catch (invalid_argument ia) {
        cout << argv[1] << " - Nieprawidlowy wiersz" << endl;
    }

    return 0;
}