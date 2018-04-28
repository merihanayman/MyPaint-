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
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DELL-
 */
public class Circle implements Shape{
    Color color= Color.blue;
    int x ;
    int y;
    int diameter;
    public int result;
    
    public Circle(){
        this.color=getColor();
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100);
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField diameterField = new JTextField(5);       
        
        //diameterField.setText("70");
      //  xField.setText(""+x);
       // yField.setText(""+y);
        JPanel p = new JPanel();
        p.add(new JLabel("x:"));
        p.add(xField);
        p.add(Box.createHorizontalStrut(15)); // a spacer 
        p.add(new JLabel("y:"));
        p.add(yField);
        p.add(Box.createHorizontalStrut(15));
        p.add(new JLabel("Diameter: "));
        p.add(diameterField);
       
        result = JOptionPane.showConfirmDialog(null, p, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){
            diameter=Integer.parseInt(diameterField.getText());            
            x=Integer.parseInt(xField.getText());
            y=Integer.parseInt(yField.getText());
        }
    }

    
    public Circle(Shape shape) {
        Circle r=(Circle)shape;
        this.color=r.color;
        this.diameter=r.diameter;
        this.x=r.x;
        this.y=r.y;
        this.result=r.result;
    }
    public Circle(int x)
    {
       // Circle r=(Circle)shape;
        this.color=color.red;
        this.diameter=50;
        this.x=50;
        this.y=50;
        
    }
    
    
    @Override
    public void setPosition(Point position) {
        x=position.x;
        y=position.y;
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
        p.put("diameter",(double)diameter);
         return p;
    }

    @Override
    public void setColor(Color color) {
        this.color=color; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getFillColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color);
        canvas.drawOval(x, y, diameter,diameter);        
        canvas.fillOval(x,y,diameter,diameter);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Circle r=new Circle(this);
        return r;
    }

    
    
}
