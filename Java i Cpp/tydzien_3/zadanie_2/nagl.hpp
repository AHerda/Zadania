//nagl.hpp

class WierszTrojkataPascala {
private:
    int *liczby;
    int Silnia(int n);

public:
    WierszTrojkataPascala(int n);
    ~WierszTrojkataPascala();
    int Liczba(int n);
};