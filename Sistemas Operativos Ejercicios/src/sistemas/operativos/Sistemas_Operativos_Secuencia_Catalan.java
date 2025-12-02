package sistemas.operativos;

import java.util.Scanner;

public class Sistemas_Operativos_Secuencia_Catalan {

    public static void main(String[] args) 
    {
        Scanner teclado=new Scanner(System.in);
        System.out.print("Digite el número: ");
        long n= teclado.nextInt();
        long sc;
        sc=(factorial(2*n))/(factorial(n+1)*factorial(n));
        System.out.println(sc);
    }
    public static long factorial(long n)
    {
    long fact=1;
    for(int i=1;i<=n;i++)
        {
        fact=fact*i;
        }
    return fact;
    }
}