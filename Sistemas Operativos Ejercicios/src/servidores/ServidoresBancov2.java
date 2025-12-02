package servidores;
  
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidoresBancov2 {

   	static final int Puerto=5000;
	static ServerSocket skServidor;
        public static String nombre_SO,version_SO,Arq_SO, ipServidor;
        
        static private final Logger LOGGER = Logger.getLogger("mx.com.hash.checkip.CheckIP");
        
            String obtenerIP() throws UnknownHostException {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostAddress();
        }
        
	static class Server
	{  
             Server(){	 
	   }
	 void crearComunicacion()
	{ 
              nombre_SO= System.getProperty("os.name");
              version_SO= System.getProperty("os.version");
              Arq_SO= System.getProperty("os.arch");
              
	   try{
	        Socket skCliente = skServidor.accept(); // Acepta peticiones
                 
                InputStream aux2 = skCliente.getInputStream();
                DataInputStream flujo2 = new DataInputStream(aux2);
                System.out.println(flujo2.readUTF());
                 
                OutputStream aux = skCliente.getOutputStream();
                DataOutputStream flujo= new DataOutputStream( aux );
                flujo.writeUTF("La ip del Servidor es: "+ipServidor+" El sistema Operativo es: "+nombre_SO+" La version del Sistema es: "+version_SO+" La arquitectura del sistema es: "+Arq_SO);
            	
                skCliente.close();
	       }catch( Exception e ) 
		    {
		       System.out.println("Fallo la Conexion con el Cliente");
                    }
        }
        }
	  
    public static void main(String[] args) {
        ServidoresBancov2 servidor = new ServidoresBancov2();
        try {
            ipServidor=servidor.obtenerIP();
            System.out.println("La IP de su computadora es " + ipServidor);
            } catch (UnknownHostException ex) {
            LOGGER.log(Level.SEVERE, "Error al consultar el Host");
            LOGGER.log(Level.SEVERE, null, ex);
            }
        
        try
		{
                       skServidor = new ServerSocket(Puerto);
		}catch(Exception e)
		{
                       System.out.println("Fallo en la Comunicación!!");
		}
		Server s=new Server();
		s. crearComunicacion ();
	
    }
    
}