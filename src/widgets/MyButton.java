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
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

/**
 *
 * @author ZAFL
 */
public class MyButton extends JButton {
    private Paint paint;
    private Shape shape;
    private Paint glass;
    private boolean over;
    
    
    public MyButton(){
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                super.mouseEntered(me);
                setOver(true);
            }
            @Override
            public void mouseExited(MouseEvent me){
                super.mouseExited(me);
                setOver(false);  
            }
        });
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Graphics2D gd = (Graphics2D)g.create();
        
        paint = new GradientPaint(0, 0, Color.BLUE, 0, getHeight(), Color.BLACK);
        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
        if(isOver()){
            glass = new GradientPaint(0, 0,new Color(1F, 1F, 1F, 0F), 0, getHeight(), new Color(1F, 1F, 1F, 0.5F));
        }else{
            glass = new GradientPaint(0, 0,new Color(1F, 1F, 1F, 0.5F), 0, getHeight(), new Color(1F, 1F, 1F, 0F));
        }
        
        
                
        gd.setPaint(paint);
        gd.fill(shape);
//        gd.fillRect(0, 0, getWidth(), getHeight());
        
        
        
        super.paintComponent(g);
        gd.setPaint(glass);
        gd.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        
        gd.dispose();
    }
    
    
}
