/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpa_servidor;

import java.util.EventListener;

/**
 *
 *
 * @author rogelionoris
 */
interface AvisaServidor extends EventListener{
   
   public void onClientReceive();
    
}
