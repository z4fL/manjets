/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widgets;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.TextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ZAFL
 */
public class MyTextField extends JTextField {

    private Paint paint;
    private boolean fokus;
    
    
    
    public MyTextField(){
        setForeground(Color.black);
        setOpaque(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
    
        addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent fe){
                super.focusGained(fe);
                setFokus(true);
            }
            @Override
            public void focusLost(FocusEvent fe){
                super.focusLost(fe);
                setFokus(false);
            }
        });
    }

    public boolean isFokus() {
        return fokus;
    }

    public void setFokus(boolean fokus) {
        this.fokus = fokus;
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D gd = (Graphics2D)g.create();
        if (isFokus()){
            paint = new GradientPaint(0, 0, Color.red, getWidth(), 0, Color.black);
        }else{
            paint = new GradientPaint(0, 0, Color.black, getWidth(), 0, Color.red);
        }
        
        gd.setPaint(paint);
        gd.fillRect(0, 0, getWidth(), getHeight());
        gd.dispose();
        
        super.paintComponent(g);
    }
    
    
}
