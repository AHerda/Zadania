#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main(int argc, char* argv[]) {


    int wynik[256];
    int i = 0;
    string dana = "5e8369a500161eb43c8379e5d03f28469748d979";

    ofstream myfile;
    myfile.open("hash1_gen.txt");
    while(dana[i])
    {
        switch(dana[i])
        {
            case '0':
                myfile << "0000";
                break;
            case '1':
                myfile << "0001";
                break;
            case '2':
                myfile << "0010";
                break;
            case '3':
                myfile << "0011";
                break;
            case '4':
                myfile << "0100";
                break;
            case '5':
                myfile << "0101";
                break;
            case '6':
                myfile << "0110";
                break;
            case '7':
                myfile << "0111";
                break;
            case '8':
                myfile << "1000";
                break;
            case '9':
                myfile << "1001";
                break;
            case 'A':
            case 'a':
                myfile << "1010";
                break;
            case 'B':
            case 'b':
                myfile << "1011";
                break;
            case 'C':
            case 'c':
                myfile << "1100";
                break;
            case 'D':
            case 'd':
                myfile << "1101";
                break;
            case 'E':
            case 'e':
                myfile << "1110";
                break;
            case 'F':
            case 'f':
                myfile << "1111";
                break;
        }
        i += 1;
    }
    myfile.close();

    return 0;
}