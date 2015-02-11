/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tpa_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rogelio_noris
 */
public class Servidor {
    
    private Socket socket;
    private ServerSocket serverSocket;
        
    private OutputStream outputStream;
    private InputStream inputStream;
    
    private DataOutputStream salidaDatos;
    private DataInputStream entradaDatos;
    
    private boolean conexionActiva;
    
    public Servidor(){
        
    }
    
    void conexion(int puerto){
        try {
            serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor escuchando en el puerto: "+puerto);
            socket = serverSocket.accept();
            System.out.println("Un usuario se ha conectado");
            conexionActiva=true;
            Thread hiloServer = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(conexionActiva){
                        recibirDatos();
                    }
                }
            });
            hiloServer.start();    
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
    public void recibirDatos(){
        try{
            inputStream = socket.getInputStream();
            entradaDatos = new DataInputStream(inputStream);
            System.out.println(entradaDatos.readUTF());
        }catch(Exception ex){
            ex.printStackTrace();
            conexionActiva=false;
        }
    }
    
    public void enviarDatos(String datos){
        try{
            outputStream = socket.getOutputStream();
            salidaDatos = new DataOutputStream(outputStream);
            salidaDatos.writeUTF(datos);
            salidaDatos.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void cerrarConexion(){
        try{
            salidaDatos.close();
            entradaDatos.close();
            socket.close();
            serverSocket.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
