/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.EventListener;

/**
 *
 *
 * @author rogelionoris
 */
public interface MessageListener extends EventListener{
   
   public void onClientReceiveMessage(ClienteThread evt, String msg);
   public void onClientReceivePvtMessage(String nickname, String msg);
   
   
}
