/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpa_juego;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rogelionoris
 */
public class Player extends JLabel{    
    
    JLabel player;
    int posx;
    int posy;
    int speed = 10;
    JPanel panel;
    
    public Player(JPanel panel,int x, int y, String nombre_imagen){  
        
        this.panel = panel;
        player = new JLabel();
        
        posx = x;
        posy = y;
        
        player.setBounds(posx, posy, 100, 100);
        player.setIcon(new ImageIcon(getClass().getResource("/res/"+nombre_imagen)));
        panel.add(player);
        panel.repaint();
        System.out.println("New Player on screen.");
    }
    
    public void move(int x, int y){
        posx += (x*speed);
        posy += (y*speed);
        
        player.setLocation(posx, posy);
        
        System.out.println("Player direction: "+x+" _ "+y);
    }
 
    public void delete(){
        this.panel.remove(player);
        this.panel.repaint();
    }
}
