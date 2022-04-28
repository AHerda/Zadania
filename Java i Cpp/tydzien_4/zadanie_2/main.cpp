//main.cpp
#include <stdio.h>
#include "nagl.hpp"
#include <string.h>
#include <string>
#include <iostream>

using namespace std;

int main(int ilosc, char *args[]) {
    int licznik = 2;
    int chwilowa_dane = 0;

    for(int i = 0; i < strlen(args[1]); i += 1) {
        if(args[1][i] == 'c') {
            chwilowa_dane += 5;
        }
        else if(args[1][i] == 'o' || args[1][i] == 'p' || args[1][i] == 's') {
            chwilowa_dane += 1;
        }
    }

    if(chwilowa_dane == (ilosc - 2)) {
        for(int i = 0; i < strlen(args[1]); i += 1) {
            switch (args[1][i]) {
                case 'o': {
                    try {
                        cout << "Figura " << (i + 1) << " - Kolo:" << endl;

                        licznik += 1;
                        double n = stoi(args[licznik - 1]);
                        if(n > 0) {
                            kolo chwila(n);
                            cout << "    Obwod = " << chwila.obwod << endl;
                            cout << "    Pole = " << chwila.pole << endl << endl;
                        }
                        else {
                            cout << "    " << n << " - Nieprawdilowy promien" << endl << endl;
                        }
                    }
                    catch (invalid_argument ia) {
                        cout << "    " << args[licznik - 1] << " - Nieprawdilowa typ danej" << endl << endl;
                    }
                    break;
                }
                case 'p': {
                    try {
                        cout << "Figura " << (i + 1) << " - Pieciokat foremny:" << endl;

                        licznik += 1;
                        double n = stoi(args[licznik - 1]);
                        if(n > 0) {
                            pieciokat chwila(n);
                            cout << "    Obwod = " << chwila.obwod << endl;
                            cout << "    Pole = " << chwila.pole << endl << endl;
                        }
                        else {
                            cout << "    " << n << " - Nieprawdilowy bok" << endl << endl;
                        }
                    }
                    catch (invalid_argument ia) {
                        cout << "    " << args[licznik - 1] << " - Nieprawdilowa typ danej" << endl << endl;
                    }
                    break;
                }
                case 's': {
                    try {
                        cout << "Figura " << (i + 1) << " - Szesciokat foremny:" << endl;

                        licznik += 1;
                        double n = stoi(args[licznik - 1]);
                        if(n > 0) {
                            szesciokat chwila(n);
                            cout << "    Obwod = " << chwila.obwod << endl;
                            cout << "    Pole = " << chwila.pole << endl << endl;
                        }
                        else {
                            cout << "    " << n << " - Nieprawdilowy bok" << endl << endl;
                        }
                    }
                    catch (invalid_argument ia) {
                        cout << "    " << args[licznik - 1] << " - Nieprawdilowa typ danej" << endl << endl;
                    }
                    break;
                }
                case 'c': {
                    int licznik_pom = licznik;
                    
                    try {
                        cout << "Figura " << (i + 1) << " - Czworokat:" << endl;
                        bool czy_dobry_c = true;
                        licznik += 5;

                        double n[5];
                        for(int j = 0; j < 5; j += 1) {
                            licznik_pom += 1;
                            n[j] = stoi(args[licznik_pom - 1]);
                            if(n[j] <= 0) {
                                czy_dobry_c = false;
                            }
                        }
                        if(czy_dobry_c && n[4] < 180) {
                            if(n[0] == n[1] && n[0] == n[2] && n[0] == n[3]) {
                                if(n[4] == 90) {
                                    kwadrat chwila(n[0], n[1], n[2], n[3], n[4]);
                                    cout << "    Obwod = " << chwila.obwod << endl;
                                    cout << "    Pole = " << chwila.pole << endl << endl;
                                }
                                else {
                                    romb chwila(n[0], n[1], n[2], n[3], n[4]);
                                    cout << "    Obwod = " << chwila.obwod << endl;
                                    cout << "    Pole = " << chwila.pole << endl << endl;
                                }
                            }
                            else if(n[4] == 90 && ((n[0] == n[1] && n[2] == n[3]) || (n[0] == n[2] && n[1] == n[3]) || (n[0] == n[3] && n[2] == n[1]))) {
                                prostokat chwila(n[0], n[1], n[2], n[3], n[4]);
                                cout << "    Obwod = " << chwila.obwod << endl;
                                cout << "    Pole = " << chwila.pole << endl << endl;
                            }
                            else {
                                cout << "    Nieprawidlowe boki lub kat czworokata" << endl << endl;
                            }
                        }
                        else {
                            cout << "    Nieprawidlowe dane czworokata" << endl << endl;
                        }
                    }
                    catch (invalid_argument ia) {
                        cout << "    " << args[licznik_pom - 1] << " - Nieprawdilowy typ danej" << endl << endl;

                    }
                    break;
                }
                default: {
                    cout << args[1][i] << " - Nieprawidlowy skrot figury" << endl << endl;
                }
            }
        }
    }
    else {
        cout << "Nieprawidlowa ilosc danych" << endl;
    }

    return 0;
}