#include <iostream>
#include "nagl.hpp"

using namespace std;

Box::Box() {
    count = 0;
}

void Box::moreBall() {
    count += 1;
}

int Box::getCount() {
    return count;
}