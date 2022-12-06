#include "nagl.hpp"

Warehouse::Warehouse(int size) {
    boxy = new Box[size];
}

Warehouse::~Warehouse() {
    for(int i=0; i < (sizeof(boxy)/sizeof(Box)); i++) {
        boxy[i].~Box();
    }

    delete[] boxy;
}