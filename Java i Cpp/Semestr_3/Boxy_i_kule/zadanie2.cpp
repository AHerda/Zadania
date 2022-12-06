#include "nagl.hpp"
#include <iostream>
#include <random>

using namespace std;

int main(int argc, char* argv[])
{
    mt19937 mt;
    for(int i = 1000; i <= 100000; i += 1000)
    {
        for(int j = 0; j < 50; j++)
        {
            Warehouse warehouse(i);
            int n = 1;
            bool check = true;
            while(check)
            {
                int losowa = mt() % i;
                check = warehouse.add(losowa, n, i);
                n++;
            }
            warehouse.~Warehouse();
        }
    }
}