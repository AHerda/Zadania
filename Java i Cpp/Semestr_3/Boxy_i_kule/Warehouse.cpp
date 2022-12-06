#include "nagl.hpp"

Warehouse::Warehouse(int size) {
    boxy = new Box[size];
    this->size = size;
}

Warehouse::~Warehouse() {
    for(int i=0; i < (sizeof(boxy)/sizeof(Box)); i++) {
        boxy[i].~Box();
    }

    delete[] boxy;
}

bool Warehouse::czyKoniec() {
    for(int i=0; i < size; i++) {
        if(boxy[i].getCount() < 2) {
            return false;
        }
        return false;
    }
}