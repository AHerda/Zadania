#include <iostream>
#include <fstream>
#include <random>

using namespace std;

int Sn(int N)
{
    mt19937 mt{ random_device{}() };
    uniform_int_distribution los{0, 1};

    int liczba;
    int suma = 0;
    for(int i = 0; i < N; i++)
    {
        liczba = los(mt);
        if(liczba == 0)
        {
            suma -= 1;
        }
        else
        {
            suma += 1;
        }
    }
    return suma;
}

int main(int argc, char* argv[]) 
{
    ofstream myfile;
    myfile.open("wyniki.txt");

    for(int i = 5; i <= 30; i += 5)
    {
        int czestosc[i * 2 + 1];
        for(int j = 0; j < i * 2 + 1; j += 1) {
            *(czestosc + j) = 0;
        }
        for(int j = 0; j < 100000; j += 1)
        {
            *(czestosc + Sn(i) + i) += 1;
        }
        myfile << i;
        for(int j = 0; j < i * 2 + 1; j += 1) {
            myfile << " " << czestosc[j];
        }
        myfile << endl;
    }


    int czestosc[100 * 2 + 1];
    for(int j = 0; j < 100 * 2 + 1; j += 1) {
        *(czestosc + j) = 0;
    }

    for(int j = 0; j < 1000000; j += 1)
    {
        *(czestosc + Sn(100) + 100) += 1;
    }

    myfile << 100;
    for(int j = 0; j < 100 * 2 + 1; j += 1) {
        myfile << " " << czestosc[j];
    }

    myfile.close();
}