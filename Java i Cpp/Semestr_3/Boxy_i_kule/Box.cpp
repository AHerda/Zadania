#include <iostream>
#include "nagl.hpp"

using namespace std;

Box::Box() {
    count = 0;
    cptr = &count;
}

Box::~Box() {
    delete cptr;
}

void Box::moreBall() {
    *cptr += 1;
}

int Box::getCount() {
    return count;
}