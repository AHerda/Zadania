public class test {
    public static void main (String[] args) {
        try {
            int zakres = Integer.parseInt(args[0]);
            if(zakres > 1) {
                LiczbyPierwsze dana = new LiczbyPierwsze(zakres);
                for(int i = 1; i < args.length; i += 1){
                    try {
                        int n = Integer.parseInt(args[i]);
                        if(n >= 0 && n <= zakres && dana.liczba(n) > 0){
                            System.out.println(n + " - " + dana.liczba(n));
                        }
                        else {
                            System.out.println(n + " - Liczba spoza zakresu");
                        }
                    }
                    catch (NumberFormatException ex){
                        System.out.println(args[i] + " - Nieprawidlowa dana");
                    }
                }
            }
            else {
                System.out.println(args[0] + " - Nieprawidlowy zakres");
            }
        }
        catch (NumberFormatException ex){
            System.out.println(args[0] + " - Nieprawidlowy zakres");
        }
    }
}

/*public class LiczbyPierwsze {
    private int pierwsze[];

    public LiczbyPierwsze (int n) {
        pierwsze = new int[n];
        int miejsce = 0;

        for(int i = 2; i <= n; i += 1) {
            int licznik = 0;
            for(int j = 1; j * j <= i; j += 1) {
                if(i % j == 0){
                    licznik += 1;
                    if(licznik == 2) {
                        break;
                    }
                }
            }
            if(licznik < 2) {
                    pierwsze[miejsce] = i;
                    miejsce += 1;
            }
        }
    }

    public int liczba(int m) {
        return pierwsze[m];
    }
}*/

/*public class LiczbyPierwsze
{

    int l=1;

    public void liczbypierwsze(int n)
    {
        int[] tab = new int[n+1];
        if(n<3)
        {
            System.out.println("Podano nieprawidłowy zakres");
            return;
        }
        for(int i=0; (i+1)<n; i++)//wyp tablice
            tab[i]=i+2;
        
        while(tab[l]!=0)
        {  
            for(int i=0; i<l; i++)
            {
                if(tab[l]==0)//nie wiem czy bardzo potrzebne
                {
                    System.out.println("Koniec tablicy");
                    break;
                }
                if(tab[l]%tab[i]==0)
                {
                    int m=l;
                    while((l+1)<n)//przesuwacz
                    {
                        tab[l]=tab[l+1];
                        l++;
                    }
                    tab[l+1]=0;//ostatni el. tablicy
                    l=(m-1);
                    break;
                }
            }
            l++;
        }
    }
    
    public int liczba(int u) 
    {
        int[] tab = new int[u+1];
        if(u<l&&u>=0)
            return tab[u];
        else if(l<u)   
            return 1;
        else 
            return -1;
    }
}*/