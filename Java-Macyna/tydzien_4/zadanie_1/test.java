public class test {
    public static void main(String args[]) {
        int licznik = 1;
        int chwilowa_dane = 0;

        for(int i = 0; i < args[0].length(); i += 1) {
            if(args[0].charAt(i) == 'c') {
                chwilowa_dane += 5;
            }
            else if(args[0].charAt(i) == 'o' || args[0].charAt(i) == 'p' || args[0].charAt(i) == 's') {
                chwilowa_dane += 1;
            }
        }

        if(chwilowa_dane == (args.length - 1)) {
            for(int i = 0; i < args[0].length(); i += 1) {
                switch (args[0].charAt(i)) {
                    case 'o': {
                        try {
                            System.out.println("Figura " + (i + 1) + " - Kolo:");

                            licznik += 1;
                            double n = Double.parseDouble(args[licznik - 1]);
                            if(n > 0) {
                                kolo chwila = new kolo(n);
                                System.out.println("    Obwod = " + chwila.obwod);
                                System.out.println("    Pole = " + chwila.pole + "\n");
                            }
                            else {
                                System.out.println("    " + n + " - Nieprawdilowy promien\n");
                            }
                        }
                        catch (NumberFormatException ex) {
                            System.out.println("    " + args[licznik - 1] + " - Nieprawdilowa dana\n");
                        }
                        break;
                    }
                    case 'p': {
                        try {
                            System.out.println("Figura " + (i + 1) + " - Pieciokat foremny:");

                            licznik += 1;
                            double n = Double.parseDouble(args[licznik - 1]);
                            if(n > 0) {
                                pieciokat chwila = new pieciokat(n);
                                System.out.println("    Obwod = " + chwila.obwod);
                                System.out.println("    Pole = " + chwila.pole + "\n");
                            }
                            else {
                                System.out.println("    " + n + " - Nieprawdilowy bok\n");
                            }
                        }
                        catch (NumberFormatException ex) {
                            System.out.println("    " + args[licznik - 1] + " - Nieprawdilowa dana\n");
                        }
                        break;
                    }
                    case 's': {
                        try {
                            System.out.println("Figura " + (i + 1) + " - Szesciokat foremny:");

                            licznik += 1;
                            double n = Double.parseDouble(args[licznik - 1]);
                            if(n > 0) {
                                szesciokat chwila = new szesciokat(n);
                                System.out.println("    Obwod = " + chwila.obwod);
                                System.out.println("    Pole = " + chwila.pole + "\n");
                            }
                            else {
                                System.out.println("    " + n + " - Nieprawdilowy bok\n");
                            }
                        }
                        catch (NumberFormatException ex) {
                            System.out.println("    " + args[licznik - 1] + " - Nieprawdilowa dana\n");
                        }
                        break;
                    }
                    case 'c': {
                        int licznik_pom = licznik;

                        try {
                            System.out.println("Figura " + (i + 1) + " - Czworokat:");
                            boolean czy_dobry_c = true;
                            licznik += 5;

                            double n[] = new double[5];
                            for(int j = 0; j < 5; j += 1) {
                                licznik_pom += 1;
                                n[j] = Double.parseDouble(args[licznik_pom - 1]);
                                if(n[j] <= 0) {
                                    czy_dobry_c = false;
                                    break;
                                }
                            }
                            if(czy_dobry_c && n[4] < 180) {
                                if(n[0] == n[1] && n[0] == n[2] && n[0] == n[3]) {
                                    if(n[4] == 90) {
                                        kwadrat chwila = new kwadrat(n[0], n[1], n[2], n[3], n[4]);
                                        System.out.println("    Obwod = " + chwila.obwod);
                                        System.out.println("    Pole = " + chwila.pole + "\n");
                                    }
                                    else {
                                        romb chwila = new romb(n[0], n[1], n[2], n[3], n[4]);
                                        System.out.println("    Obwod = " + chwila.obwod);
                                        System.out.println("    Pole = " + chwila.pole + "\n");
                                    }
                                }
                                else if(n[4] == 90 && ((n[0] == n[1] && n[2] == n[3]) || (n[0] == n[2] && n[1] == n[3]) || (n[0] == n[3] && n[2] == n[1]))) {
                                    prostokat chwila = new prostokat(n[0], n[1], n[2], n[3], n[4]);
                                    System.out.println("    Obwod = " + chwila.obwod);
                                    System.out.println("    Pole = " + chwila.pole + "\n");
                                }
                                else {
                                    System.out.println("    Nieprawidlowe boki lub kat czworokata\n");
                                }
                            }
                            else {
                                System.out.println("    Nieprawidlowe dane czworokata\n");
                            }
                        }
                        catch (NumberFormatException ex) {
                            System.out.println("    " + args[licznik_pom - 1] + " - Nieprawdilowa dana\n");
                        }
                        break;
                    }
                    default: {
                        System.out.println(args[0].charAt(i) + " - Nieprawidlowy skrot figury\n");
                    }
                }
            }
        }
        else {
            System.out.println("Nieprawidlowa ilosc danych");
        }
    }
}