/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package buscaminas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author rogelio_noris
 */
public class Ventana extends javax.swing.JFrame implements ActionListener, Runnable{

    /**
     * Creates new form Ventana
     */
    
    JButton botones[][];
    int columnas;
    int filas;
    int tablero[][];
    int numeroBombas;
    boolean juegoTerminado;
    
    Thread timer;
    float tiempo;
    
    
    /**
     * Constructor
     */
    public Ventana() {
        
        // Inicializa la interfaz grafica
        initComponents();       
        
        //Inicia el juego
        iniciaJuego();       
        
        tiempo=0;
        timer = new Thread(this);
        timer.start();
    }
    
    private void iniciaJuego(){
        //Configuracion Inicial
        juegoTerminado = false;
        columnas = 5;
        filas = 5;                      
        numeroBombas = 5;        
        //Crea y coloca los botones en el panel
        creaTablero();
        
        //Crea la matriz de numeros y coloca bombas aleatorias
        colocaBombas();
    }
    
    private void reiniciaJuego(){
        for(int i=0; i < filas; i++){
            for(int j=0; j < columnas; j++){
                panelCuadros.remove(botones[i][j]);
            }
        }
        panelCuadros.revalidate();
        panelCuadros.repaint();
        
        iniciaJuego();
        
    }
        
    /**
     * Crea y coloca los botones en el panel
     */
    private void creaTablero(){
        botones = new JButton[filas][columnas];        
        
        for(int i=0; i < filas; i++){
            for(int j=0; j < columnas; j++){
                botones[i][j] = new JButton("");
                botones[i][j].setBounds(j*60, i*60, 60, 60);
                panelCuadros.add(botones[i][j]);
                botones[i][j].addActionListener(this);
            }            
        }  
    }

    /**
     * Crea la matriz de numeros y coloca bombas aleatorias
     */
    private void colocaBombas(){
        
        tablero = new int[filas][columnas];
            
        int fila, columna;
        for(int i=0; i < numeroBombas; i++){
            fila = (int) (Math.random() * filas);
            columna = (int) (Math.random() * columnas);
            
            if(tablero[fila][columna]==1){
                i--;
            }else{
                tablero[fila][columna]=1;
            }
        }
        
    }
    
    private void muestraBombas(){
        
        juegoTerminado = true;
        for(int i=0; i < filas; i++){
            for(int j=0; j < columnas; j++){
                if(tablero[i][j] == 1){
                    botones[i][j].setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/bomba.jpg"))
                        .getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)
                    ));
                }
                
                
            }            
        } 
                
    }
    
    private void cuentaBombas(int fila, int columna){
        int bombasEncontradas=0;
        
        bombasEncontradas+=revisaBombas(fila-1, columna-1);
        bombasEncontradas+=revisaBombas(fila-1, columna);
        bombasEncontradas+=revisaBombas(fila-1, columna+1);
        bombasEncontradas+=revisaBombas(fila, columna-1);
        bombasEncontradas+=revisaBombas(fila, columna+1);
        bombasEncontradas+=revisaBombas(fila+1, columna-1);
        bombasEncontradas+=revisaBombas(fila+1, columna);
        bombasEncontradas+=revisaBombas(fila+1, columna+1);
        
        botones[fila][columna].setText(""+bombasEncontradas);
        
        if(bombasEncontradas == 0){
            clicks(fila-1, columna-1);
            clicks(fila-1, columna);
            clicks(fila-1, columna+1);
            clicks(fila, columna-1);
            clicks(fila, columna+1);
            clicks(fila+1, columna-1);
            clicks(fila+1, columna);
            clicks(fila+1, columna+1);
        }
        
    }
    
    private int revisaBombas(int fila, int columna){
        if( fila >= 0 && columna >=0 && fila < filas && columna < columnas){
            if(tablero[fila][columna] == 1){
                return 1;
            }else{
                return 0;
            }
        }
        return 0;
    }
    
    private void clicks(int fila, int columna){
        if( fila >= 0 && columna >=0 && fila < filas && columna < columnas){
            if(tablero[fila][columna] == 0){
                botones[fila][columna].doClick();
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBombas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        panelCuadros = new javax.swing.JPanel();
        txtTiempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBombas.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        txtBombas.setForeground(new java.awt.Color(255, 0, 0));
        txtBombas.setText("000");

        jButton1.setIcon(
            new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/happyface.png"))
                .getImage().getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)
            ));
            jButton1.setName(""); // NOI18N
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout panelCuadrosLayout = new javax.swing.GroupLayout(panelCuadros);
            panelCuadros.setLayout(panelCuadrosLayout);
            panelCuadrosLayout.setHorizontalGroup(
                panelCuadrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 644, Short.MAX_VALUE)
            );
            panelCuadrosLayout.setVerticalGroup(
                panelCuadrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 453, Short.MAX_VALUE)
            );

            txtTiempo.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
            txtTiempo.setForeground(new java.awt.Color(255, 0, 0));
            txtTiempo.setText("000");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelCuadros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtBombas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(17, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBombas)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addComponent(panelCuadros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reiniciaJuego();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel panelCuadros;
    private javax.swing.JTextField txtBombas;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(juegoTerminado){
            return;
        }
        
        JButton btn = (JButton) e.getSource();
        btn.setBackground(Color.white);
        btn.setOpaque(true);
        btn.setBorderPainted(false);        
        
        int fila=0;
        int columna=0;
        
        for(int i=0; i < filas; i++){
            for(int j=0; j < columnas; j++){
                if(btn == botones[i][j]){
                    fila=i;
                    columna=j;
                }                
            }            
        }  
        
        //JOptionPane.showMessageDialog(null, ""+fila+" "+columna);
        if(tablero[fila][columna] == 1){
            muestraBombas();
        }else{
            tablero[fila][columna] = 2;
            cuentaBombas(fila,columna);
        }        
    }

    @Override
    public void run() {
        while(true){
            tiempo++;
            
            int minutos = (int)(tiempo / 60f);
            int segundos = (int)(tiempo % 60f);
            
            txtTiempo.setText(""+minutos+":"+segundos);  
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }        
    }
    
}
