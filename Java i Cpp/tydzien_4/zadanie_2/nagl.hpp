//nagl.hpp
class figura {
protected: 
    double dana;
    
    virtual double LiczObwod () = 0;
    virtual double LiczPole () = 0;

public:
    double pole, obwod;
};

class kolo: public figura {
private:
    double LiczObwod ();

    double LiczPole ();

public:
    kolo (double promien);
};

class pieciokat: public figura {
public:
    pieciokat (double bok);

private:
    double LiczObwod ();

    double LiczPole ();
};

class szesciokat: public figura {
private:
    double LiczObwod ();
    
    double LiczPole ();

public:    
    szesciokat (double bok);
};

class czworokat: public figura {
protected:
    double bok1, bok2, bok3, bok4;
    double kat;

    double LiczObwod ();
    
public:
    double obwod, pole;
    czworokat (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom);
};

class kwadrat: public czworokat {
public:    
    kwadrat (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom);

private:
    double LiczPole ();
};

class romb: public czworokat {
private:
    double LiczPole ();
    
public:
    romb (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom);
};

class prostokat: public czworokat {
private:
    double LiczPole ();
    
public:
    prostokat (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom);
};