//metody.cpp
#include "nagl.hpp"
#include <math.h>

double kolo::LiczObwod () {
    return 2 * M_PI * dana;
}
double kolo::LiczPole () {
    return dana * dana * M_PI;
}
    
kolo::kolo (double promien) {
    dana = promien;

    pole = LiczPole();
    obwod = LiczObwod();
}

double pieciokat::LiczObwod () {
    return 5 * dana;
}

double pieciokat::LiczPole () {
    return 0.25 * dana * dana * sqrt(25 + 10 * sqrt(5));
}
    
pieciokat::pieciokat (double bok) {
    dana = bok;
    pole = LiczPole();
    obwod = LiczObwod();
}

double szesciokat::LiczObwod () {
        return 6 * dana;
    }

double szesciokat::LiczPole () {
    return 0.25 * 6 * dana * dana * sqrt(3);
}
    
szesciokat::szesciokat (double bok) {
    dana = bok;
    pole = LiczPole();
    obwod = LiczObwod();
}

czworokat::czworokat (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom) {
    bok1 = bok1_pom;
    bok2 = bok2_pom;
    bok3 = bok3_pom;
    bok4 = bok4_pom;
    kat = (kat_pom / 360) * M_PI;
}
    
double czworokat::LiczObwod () {
    return bok1 + bok2 + bok3 + bok4;
}

double kwadrat::LiczPole () {
    return bok1 * bok2;
}
    
kwadrat::kwadrat (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom) : czworokat(bok1_pom, bok2_pom, bok3_pom, bok4_pom, kat_pom) {
    pole = LiczPole();
    obwod = LiczObwod();
}

double romb::LiczPole () {
    return bok1 * bok2 * sin(kat);
}
    
romb::romb (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom) : czworokat(bok1_pom, bok2_pom, bok3_pom, bok4_pom, kat_pom) {
    pole = LiczPole();
    obwod = LiczObwod();
}

double prostokat::LiczPole () {
    if(bok1 != bok2) {
        return bok1 * bok2;
    }
    else {
        return bok1 * bok3;
    }
}
    
prostokat::prostokat (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom) : czworokat(bok1_pom, bok2_pom, bok3_pom, bok4_pom, kat_pom) {
    pole = LiczPole();
    obwod = LiczObwod();
}