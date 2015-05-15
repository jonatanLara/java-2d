/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redessociales;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.JLabel;

/**
 *
 * @author jonatan
 */
public class RedesSociales extends JLabel{
private String link = "";
private boolean dentro;

    public RedesSociales(){
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
              abrirLink();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                dentro = true; 
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                dentro = false;
                repaint();
            }
            
            
        });
       
    }
     public void abrirLink(){
         try {
             Desktop.getDesktop().browse(new URI(link));
         } catch (Exception e) {
         }
        }
     public void paint(Graphics g){
     Graphics2D gd = (Graphics2D)g;
         if (dentro) {
             gd.rotate(Math.toRadians(30), getWidth()/2, getHeight()/2);
         }
         super.paint(gd);
     }
     public String getLink(){
        return link;
     }

    public void setLink(String link) {
        this.link = link;
    }
     
}
