#include <iostream>
#include <fstream>
#include <random>
#include <string>

using namespace std;

int main(int argc, char* argv[])
{
    mt19937 mt{ random_device{}() };
    uniform_int_distribution los{0, 1};

    ofstream myfile;
    myfile.open("dobry_gen.txt");

    for(int i = 0; i < 2000000; i++)
    {
        myfile << los(mt);
    }

    myfile.close();

    return 0;
}