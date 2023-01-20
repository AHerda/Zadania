#include "nagl.hpp"
#include <iostream>
#include <random>

using namespace std;

int main(int argc, char* argv[])
{
    mt19937 mt{ random_device{}() };
    for(int i = 1000; i <= 100000; i += 1000)
    {
        uniform_int_distribution los{ 0, i };
        Warehouse warehouse(i);
        for(int j = 0; j < 50; j+=1)
        {
            int n = 1;
            bool check = true;
            while(check)
            {
                check = warehouse.add(los(mt), n);
                n+=1;
            }
            warehouse.zeruj(i);
        }
    }
    return 0;
}