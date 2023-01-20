#include <iostream>
#include <fstream>
#include <random>

using namespace std;

int main(int argc, char* argv[])
{
    mt19937 mt{ random_device{}() };
    uniform_int_distribution los{0, 1};

    ofstream myfile;
    myfile.open("wyniki.txt");
    for(int i = 100; i <= 10000; i *= 10)
    {
        int suma = 0;
        int poprzednia = 0;
        for(int j = 0; j < 5000; j++)
        {
            myfile << i;
            int suma = 0;
            int poprzednia = 0;
            int czas = 0;
            int liczba;
            for(int k = 0; k < i; k++)
            {
                poprzednia = suma;
                if(los(mt) == 0)
                {
                    suma -= 1;
                }
                else
                {
                    suma += 1;
                }
                if(suma > 0 || (suma == 0 && poprzednia > 0))
                {
                    czas += 1;
                }
            }
            myfile << " " << czas << endl; 
        }
    }


    return 0;
}