package so;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Multiprogramacion extends javax.swing.JFrame 
{
    private final String directorio = "C:\\Users\\JuanR\\Downloads";
    
    public Multiprogramacion() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setText("Uso de Espacio");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("Contador de Archivos por tipo");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel4.setText("Monitoreo de cambios");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jButton1.setText("Ejecutar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("Multiprogramación");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(106, 106, 106)
                .addComponent(jLabel4)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(326, 326, 326))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    class UsoEspacio extends Thread
    {
        @Override
        public void run()
        {
            jTextArea1.setText("Calculando uso de espacio...\n");
            File carpeta=new File(directorio);
            
            if (carpeta.exists() && carpeta.isDirectory())
            {
                File[] archivos=carpeta.listFiles();
                long total = 0;
                
                for(File archivo : archivos)
                {
                    total=total+archivo.length();
                }
                jTextArea1.append("Espacio total ocupado: "+total/1024+"KB\n");
            }
        }
    }
    
    class ContadorArchivos extends Thread
    {
        @Override
        public void run()
        {
            jTextArea2.setText("Contando archivos...\n");
            File carpeta=new File(directorio);
            
            if(carpeta.exists()&& carpeta.isDirectory())
            {
                File[] archivos=carpeta.listFiles();
                HashMap<String, Integer>conteo=new HashMap<>();
                
                for(File archivo:archivos)
                {
                    String extension=archivo.getName().contains(".")? archivo.getName().substring(archivo.getName().lastIndexOf(".")+1):("Desconocido");
                    conteo.put(extension,conteo.getOrDefault(extension,0)+1);
                }
                conteo.forEach((ext,count)->jTextArea2.append(ext+": "+count+" archivos.\n"));
            }
        }
    }
    
    class MonitoreoCambios extends Thread
    {
        @Override
        public void run()
        {
            jTextArea3.setText("Monitoreando cambios...\n");
            try(WatchService watchService=FileSystems.getDefault().newWatchService())
            {
                Path path=Paths.get(directorio);
                path.register(watchService,StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);
                
                while(!Thread.currentThread().isInterrupted())
                {
                    WatchKey key=watchService.take();
                    
                    for(WatchEvent<?>event:key.pollEvents())
                    {
                        jTextArea3.append("Evento: "+event.kind()+" - "+event.context()+"\n");
                    }
                    key.reset();
                }
            } 
            catch (IOException | InterruptedException ex)
            {
                Logger.getLogger(Multiprogramacion.class.getName()).log(Level.SEVERE, null, ex);
                jTextArea3.append("Error en monitoreo: "+ex.getMessage()+"\n");
            }
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UsoEspacio hilo1=new UsoEspacio();
        hilo1.start();
        ContadorArchivos hilo2=new ContadorArchivos();
        hilo2.start();
        MonitoreoCambios hilo3=new MonitoreoCambios();
        hilo3.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(() -> new Multiprogramacion().setVisible(true));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}