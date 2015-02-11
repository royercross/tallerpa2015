/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tpa_cliente;

/**
 *
 * @author rogelio_noris
 */
public class TPA_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setVisible(true);
        cliente.conexion(5555,"192.10.11.14");
    }
    
}
