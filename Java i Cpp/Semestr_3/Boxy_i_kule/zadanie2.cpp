#include "nagl.hpp"
#include <iostream>
#include <random>

using namespace std;

int main(int argc, char* argv[])
{
    Results results;
    mt19937 mt{ random_device{}() };
    for(int i = 1000; i <= 100000; i += 1000)
    {
        uniform_int_distribution los{ 0, i };
        for(int j = 0; j < 50; j++)
        {
            Warehouse warehouse(i, results);
            int n = 1;
            bool check = true;
            while(check)
            {
                int losowa = los(mt);
                check = warehouse.add(losowa, n, i);
                n++;
            }
            warehouse.Wyniki(i);
            warehouse.~Warehouse();
        }
    }
}