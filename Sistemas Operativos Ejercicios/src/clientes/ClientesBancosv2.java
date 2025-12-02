package clientes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author USUARIO
 */
public class ClientesBancosv2 {
    static final String HOST = "192.168.20.10"; //aca se coloca la IP, y si es de manera local usamos "localhost"
    static final int Puerto = 5000;
    static Socket skCliente;
    static class Clien {
        Clien() {
        }    
        void proceso() {
            try {
                OutputStream aux2 = skCliente.getOutputStream();
                DataOutputStream flujo2= new DataOutputStream( aux2 );
		flujo2.writeUTF( "Por favor enviame las caracteristicas de su máquina computador ' '(IP, Sistema Operativo, Version y Arquitectura) "); //aca coloco si es el tipo de PC
                System.out.println("La informacion de Pc ' ' es: "); //aca coloco si es el tipo de PC
                
                InputStream aux = skCliente.getInputStream();
                DataInputStream flujo = new DataInputStream(aux);
                System.out.println(flujo.readUTF());
                
                skCliente.close();
            } catch (Exception e) {
                System.out.println("No se activo el cliente");
            }
        }
    }
    public static void main(String[] args) {
        try {
            skCliente=new Socket(HOST,Puerto);
            System.out.println("Se Activo el cliente");
        } catch (Exception e) {
             System.out.println("No se activo el cliente");
        }
        Clien c = new Clien();
        c.proceso();
    }
}