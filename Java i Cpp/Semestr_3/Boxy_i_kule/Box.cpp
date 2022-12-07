#include "nagl.hpp"

Box::Box() {
    count = 0;
}

void Box::moreBall() {
    count+=1;
}

int Box::getCount() {
    return count;
}

bool Box::collision() {
    if(count == 2) {
        return true;
    }
    return false;
}