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
    int Bn=0, Un=0, Ln=0, Cn=0, Dn=0;
    //pomocnicze
    int size, puste, podwojne, max;
    //wyniki
    Results results;

    Warehouse(int size, Results results);
    ~Warehouse();

    void Wyniki(int n);

    bool Seria(bool collision, int kula, int i, int max);

    bool add(int urna, int kula, int i);

    private:
    Box* boxy;
};

class Results {
    public:
    int n[5000];
    int Bn[5000];
    int Un[5000];
    int Ln[5000];
    int Cn[5000];
    int Dn[5000];

    int index = 0;

    void add(int n, int Bn, int Un, int Ln, int Cn, int Dn);
    void write();
};