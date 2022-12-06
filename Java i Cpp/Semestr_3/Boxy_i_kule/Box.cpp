#include "nagl.hpp"

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
    return *cptr;
}

bool Box::collision() {
    if(*cptr == 2) {
        return true;
    }
    return false;
}