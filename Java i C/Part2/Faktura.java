package org.example;

import org.jetbrains.annotations.NotNull;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Faktura {
    private LocalDate data;
    private String sprzedawca;
    private String nabywca;
    private String miejsce;

    private List<Integer> id = new ArrayList<Integer>();
    private List<String> nazwy = new ArrayList<String>();
    private List<Integer> ilosc = new ArrayList<Integer>();
    private List<Double> ceny = new ArrayList<Double>();
    private List<Double> netto = new ArrayList<Double>();
    private List<Double> vaty = new ArrayList<Double>();
    private List<Double> brutto = new ArrayList<Double>();

    private double suma(@NotNull List<Double> lista) {
        double suma = 0;
        for(int i = 0; i < lista.size(); i += 1) {
            suma = suma + lista.get(i);
        }
        return suma;
    }

    public static final double vat = .23;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Faktura(String sprzedawca, String nabywca, String miejsce) {
        this.sprzedawca = sprzedawca;
        this.nabywca = nabywca;
        this.miejsce = miejsce;
        this.data = LocalDate.now();
    }

    public Faktura(String sprzedawca, String nabywca) {
        this.sprzedawca = sprzedawca;
        this.nabywca = nabywca;
        this.data = LocalDate.now();
        setMiejsce("Wrocław");
    }

    public void setSprzedawca(String sprzedawca) {
        this.sprzedawca = sprzedawca;
    }

    public void setNabywca(String nabywca) {
        this.nabywca = nabywca;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public void addItem(String item, int ilosc, double cena) {
        id.add(id.size() + 1);
        nazwy.add(item);
        this.ilosc.add(ilosc);
        ceny.add(cena);
        netto.add(cena * ilosc);
        vaty.add(cena * vat * ilosc);
        brutto.add((cena * (1 + vat)) * ilosc);
    }

    public void wypisz() {
        String oddzielnik = "-------------------------------------------------------------------------------------------------";

        System.out.println(oddzielnik);
        System.out.println("Data: " + data);
        System.out.println("Miejsce: " + miejsce);

        System.out.println(oddzielnik);
        System.out.println("Sprzedawca:                    Nabywca:");
        System.out.println(sprzedawca + "                    " + nabywca);

        System.out.println(oddzielnik);
        System.out.println("|   Lp.  |   Nazwa   |   Ilość   |   Cena jedn.   |" +
                "   Netto   |   VAT%   |   VAT   |   Brutto   |");
        for(int i = 0; i < id.size(); i += 1) {
            System.out.println("| " + id.get(i) + " | " + nazwy.get(i) + " | " + ilosc.get(i)
                    + " | " + df.format(ceny.get(i)) + " | " + df.format(netto.get(i)) + " | " + vat * 100
                    + "% | " + df.format(vaty.get(i)) + " | " + df.format(brutto.get(i)) + " |");
        }

        System.out.println(oddzielnik);
        System.out.println("| Suma netto | Suma VAT | Suma Brutto |");
        System.out.println("| " + df.format(suma(netto)) + " | " + df.format(suma(vaty)) + " | " + df.format(suma(brutto)));

        System.out.println(oddzielnik);
    }
}