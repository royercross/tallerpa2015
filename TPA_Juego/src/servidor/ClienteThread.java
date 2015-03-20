/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import tpa_juego.Player;

/**
 *
 * @author rogelio_noris
 */
public class ClienteThread{
    
    private Socket socket;
    
    public int ID;
    public String nombre;   
    public Player player;
    
    private OutputStream outputStream;
    private InputStream inputStream;
    
    private DataOutputStream salidaDatos;
    private DataInputStream entradaDatos;
    
    private boolean conexionActiva;
    
    public MessageListener messageListener;
    
    public ClienteThread(Socket socket){
        this.socket=socket;        
                        
        conexionActiva=true;
        Thread hiloServer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(conexionActiva){
                    recibirDatos();
                }
                cerrarConexion();
            }
        });
        hiloServer.start();   
    }
    
    public void addListener(MessageListener messageListener){
        this.messageListener = messageListener;      
    }
    
    public void recibirDatos(){
        try{
            inputStream = socket.getInputStream();
            entradaDatos = new DataInputStream(inputStream);
            
            String msg = entradaDatos.readUTF();
            /*
            String arreglo[] = new String[10];
            arreglo = msg.split("|");
            
            msg$hola
            pvt|rogelio|hola
            nickname|rogelio
            casilla|1
            ganador|2
            */ 
            
            if(this.messageListener != null){
                this.messageListener.onClientReceiveMessage(ClienteThread.this, msg);    
            }            
                        
        }catch(Exception ex){
            //ex.printStackTrace();
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
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
   
    
}
