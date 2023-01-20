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

    Warehouse(int size);

    void Wyniki(int index, int n);
    void zeruj(int n);

    bool Seria(bool collision, int kula);

    bool add(int urna, int kula);

    private:
    int* boxy;
};