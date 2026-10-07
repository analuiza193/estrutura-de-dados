package recursão;

public class Potencia {
     public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int potencia(int base, int expoente) {
        if (expoente == 0) {
            return 1;
        }

        return base * potencia(base, expoente - 1);
    }

    public static void main(String[] args) {

        int n = 10;
        int base = 2;
        int expoente = 5;

        System.out.println("Fibonacci de " + n + ": " + fibonacci(n));
        System.out.println(base + " elevado a " + expoente + ": " 
                           + potencia(base, expoente));
    }
}
