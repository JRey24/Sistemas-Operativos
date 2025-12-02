package sistemas.operativos;

import java.util.Scanner;

 class ccMd5{
     String p1="ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuwxyz0123456789";
     String p2="Zz0Yy1Xx2Ww3Vv4Uu5Tt6Ss7Rr8Qq9Pp0Oo1Nn2Mm3Ll4Kk5Jj6Ii7Hh8Gg9Ff0Ee1Dd2Cc3Bb4Aa5";
 }
class CifrarCaracteresMD5 extends ccMd5{
    public String cifraDatos(String clave){
        String cadenacifrada="";
        char c,cc;
        for (int i = 0; i < clave.length(); i++) {
            c=clave.charAt(i);
            cc=caracterCifrado(c,clave.length(),i);
            cadenacifrada += cc;
        }
        return cadenacifrada;
    }
    
    private char caracterCifrado(char c,int longitud,int i){
        char cc;
        int indice;
        if (p1.indexOf(c)!=-1){
            indice=p1.indexOf(c)+longitud+i;
            cc=p2.charAt(indice);
            return cc;
        }
        
        return c;
    }
}
public class CifradoDatosMD5 {
    
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String clave;
        System.out.println("Digita el password");
        clave=teclado.next();
        CifrarCaracteresMD5 ccm=new CifrarCaracteresMD5();
        System.out.println("El password es: "+ccm.cifraDatos(clave));
    }
}    
