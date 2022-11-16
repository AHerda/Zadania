package org.example;

import java.util.Scanner;

public class Interface {

    Scanner skaner = new Scanner(System.in);
    Faktura faktura;

    Interface() {
        while(Start()) {
            Dane();
            Items();
            End();
        }
    }

    private void End() {
        String checker;
        do {
                System.out.println("\nCo chciałbyś zrobić?\n1. Wypisz fakture\n2. Wyslij do bazy danych\n" +
                        "3. Wypisz i wyslij do bazy danych\nTwój wybór: ");

            checker = skaner.nextLine();

            if(checker.equals("1")) {
                faktura.wypisz();
            }
            else if(checker.equals("2")) {
                // Do zaimplementowania wyslanie do bd
            }
            else if(checker.equals("3")) {
                faktura.wypisz();
                // Do zaimplementowania  wyslanie do bd
            }
            else {
                System.out.println("Niepoprawna odpowiedz\nSprobuj ponownie");
            }
        } while(!checker.equals("1") && !checker.equals("2") && !checker.equals("3"));
    }

    private void addItem() {
        System.out.println("Nazwa: ");
        String nazwa = skaner.nextLine();

        boolean checker = false;
        int ilosc = 0;
        do {
            System.out.println("Ilość: ");
            String ilosc_str = skaner.nextLine();

            try {
                ilosc = Integer.parseInt(ilosc_str);
                checker = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Ilość musi być liczba całkowitą\nSpróbuj ponownie");
            }

        } while(checker == false);

        checker = false;
        double cena = 0;
        do {
            System.out.println("Cena jednostkowa: ");
            String cena_str = skaner.nextLine();

            try {
                cena = Double.parseDouble(cena_str);
                checker = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Cena musi być liczba\nSpróbuj ponownie");
            }

        } while(checker == false);

        faktura.addItem(nazwa, ilosc, cena);
    }

    private void Items() {
        String checker;
        int ilosc_rzeczy = 0;;
        do {
            System.out.println("\nCo chciałbyś zrobić?\n1. Dodaj rzecz\n2. Zakoncz tworzenie faktury\nTwój wybór: ");
            checker = skaner.nextLine();

            if (checker.equals("1")) {
                addItem();
                ilosc_rzeczy += 1;
            }
            else if (checker.equals("2")) {
                if (ilosc_rzeczy == 0) {
                    System.out.println("Nie dodałeś niczego\nFaktura nie może być pusta\nSpróbuj ponownie");
                }
            }
            else {
                System.out.println("Niepoprawna odpowiedz\nSpróbuj ponownie");
            }
        } while(!checker.equals("2") || ilosc_rzeczy == 0);
    }

    private void Dane() {
        System.out.println("Dane sprzedawcy: ");
        String sprzedawca = skaner.nextLine();

        System.out.println("Dane nabywcy: ");
        String nabywca = skaner.nextLine();

        System.out.println("Miejsce wystwienie faktury (default - Wrocław): ");
        String miejsce = skaner.nextLine();

        if(miejsce.isEmpty()) {
            faktura = new Faktura(sprzedawca, nabywca);
        }
        else {
            faktura = new Faktura(sprzedawca, nabywca, miejsce);
        }
    }

    private boolean Start() {
        while(true) {
            System.out.println("\nCo chciałbyś zrobić?\n1. Stwórz fakture\n2. Wyjdz\nTwój wybór: ");
            String checker = skaner.nextLine();
            if(checker.equals("1")) {
                return true;
            }
            else if(checker.equals("2")) {
                return false;
            }
            else {
                System.out.println("Niepoprawna odpowiedz\nSpróbuj ponownie");
            }
        }
    }
}
