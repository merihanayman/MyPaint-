/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author user
 */
public class Square implements Shape{
    Color color;
    int sideLength;
    int x,y;
   public int result;
    

    public Square() {
        Random rand = new Random();
        x=rand.nextInt(100);
        y= rand.nextInt(100);
        this.color=Color.YELLOW;
        
     JTextField xField=new JTextField(5);   
     JTextField yField=new JTextField(5); 
     JTextField sideLengthField=new JTextField(5);  
     JPanel p = new JPanel();
     p.add(new JLabel("x:"));
     p.add(xField);
     p.add(Box.createHorizontalStrut(15)); //spacer
     p.add(new JLabel("y:"));
     p.add(yField);
     p.add(Box.createHorizontalStrut(15)); //spacer
     p.add(new JLabel("Length:"));
     p.add(sideLengthField);
     result= JOptionPane.showConfirmDialog(null, p , "Please Enter x and y values" , JOptionPane.OK_CANCEL_OPTION);
     if(result==JOptionPane.OK_OPTION){
         sideLength=Integer.parseInt(sideLengthField.getText());
         x=Integer.parseInt(xField.getText());
           y=Integer.parseInt(yField.getText());
           
     }

    }

    public Square(Shape shape) {
        Square r = (Square) shape;
        this.color = color;
        this.sideLength = sideLength;
        this.x = x;
        this.y = y;
        this.result = result;
    }
    public Square(int x)
    {this.color=color.red;
        this.sideLength=90;
        this.x=280;
        this.y=280;
  
    }
    

    @Override
    public void setPosition(Point position) {
         x = position.x;
         y = position.y;
         
    }

    @Override
    public Point getPosition() {
       return new Point(x,y);
       
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Double> getProperties() {
        HashMap<String, Double> p= new HashMap<>();
        p.put("sideLength",(double)sideLength);
         return p;
    }

    @Override
    public void setColor(Color color) {
        this.color =color;
        
    }

    @Override
    public Color getColor() {
       return this.color;
       
    }

    @Override
    public void setFillColor(Color color) {
        this.color =color;
       
    }

    @Override
    public Color getFillColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
@Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color);
        canvas.drawRect(x,y,sideLength,sideLength);
        canvas.fillRect(x,y,sideLength,sideLength);
        
       
    }
    @Override
    public Object clone() {
        Square r=new Square(this);
        return r;
    }
   
    

  
    
}
