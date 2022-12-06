class Box {
    public:
    Box();
    ~Box();

    int getCount();
    void moreBall();

    bool collision();

    private:
    int count;
    int* cptr;
};

class Warehouse {
    public:
    //wyniki
    int Bn=0, Un=0, Ln=0, Dn=0, Cn=0;
    //pomocnicze
    int size, puste, podwojne, max;

    Warehouse(int size);
    ~Warehouse();

    bool Seria(bool collision, int kula, int i, int max);

    bool add(int urna, int kula, int i);

    private:
    Box* boxy;
};

class Results {

};