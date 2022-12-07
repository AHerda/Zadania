class Results {
    public:
    int n[5000];
    int Bn[5000];
    int Un[5000];
    int Ln[5000];
    int Cn[5000];
    int Dn[5000];

    int index = 0;

    void add(int index, int n, int Bn, int Un, int Ln, int Cn, int Dn);
    void write();
};

class Box {
    public:
    Box();

    int getCount();
    void setCount(int i);
    void moreBall();

    bool collision();

    private:
    int count;
};

class Warehouse {
    public:
    //wyniki
    int Bn;
    int Un;
    int Ln;
    int Cn;
    int Dn;
    //pomocnicze
    int size, puste, podwojne, max;
    //wyniki
    Results results;

    Warehouse(int size, Results results);

    void Wyniki(int index, int n);
    void zeruj(int n);

    bool Seria(bool collision, int kula, int i, int max);

    bool add(int urna, int kula, int i);

    private:
    Box* boxy;
};