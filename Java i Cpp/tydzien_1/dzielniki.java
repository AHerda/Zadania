import java.lang.Math;

public class dzielniki {
    public static void main(String[] args){
        for(int i = 0; i < args.length; i += 1){
            try {
                int n=Integer.parseInt(args[i]);
                System.out.println("Najwiekszy dzielnik " + n + " to: " + div(n));
            }
            catch (NumberFormatException ex){
                System.out.println(args[i] + " nie jest liczba calkowita");
            }
        }
    }

    public static int div(int n){
        if(n < 0){
            n = -1 * n;
        }
        for(int i = 2; i <= Math.sqrt(n); i += 1){
            if(n % i == 0){
                return (n/i);
            }
        }
        return 1;
    }
}
