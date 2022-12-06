class Box {
    public:
    Box();
    ~Box();

    int getCount();
    void moreBall();

    private:
    int count;
    int* cptr;
};

class Warehouse {
    public:
    Warehouse(int size);
    ~Warehouse();

    bool czyKoniec();

    private:
    Box* boxy;
    int size; 
};