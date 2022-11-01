public class test {
    public static void main(String args[]) {
        try {
            int wiersz = Integer.parseInt(args[0]);
            if(wiersz >= 0) {
                WierszTrojkataPascala dana = new WierszTrojkataPascala(wiersz);
                for(int i = 1; i < args.length; i += 1) {
                    try {
                        int n = Integer.parseInt(args[i]);
                        if(n >= 0 && n <= wiersz) {
                            System.out.println(n + " - " + dana.Liczba(n));
                        }
                        else {
                            System.out.println(args[i] + " - Nieprawidlowa liczba");
                        }
                    }
                    catch(NumberFormatException ex) {
                        System.out.println(args[i] + " - Nieprawidlowy format liczby");
                    }
                }
            }
            else {
                System.out.println(args[0] + " - Nieprawidlowy wiersz");
            }
        }
        catch(NumberFormatException ex) {
            System.out.println(args[0] + " - Nieprawidlowy format wiersza");
        }
    }
}
