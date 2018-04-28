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
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class Triangle implements Shape {
    Color color;
    int width;
    int length;
    int x,y;
  public  int result;
  

    public Triangle() {
         JTextField xField=new JTextField(5);   
     JTextField yField=new JTextField(5); 
     JTextField lengthField=new JTextField(5);  
          JTextField widthField=new JTextField(5);  

     JPanel p = new JPanel();
     p.add(new JLabel("x:"));
     p.add(xField);
     p.add(Box.createHorizontalStrut(15)); //spacer
     p.add(new JLabel("y:"));
     p.add(yField);
     p.add(Box.createHorizontalStrut(15)); //spacer
     p.add(new JLabel("Height:"));
     p.add(lengthField);
     p.add(new JLabel("Base:"));
     p.add(widthField);
     result= JOptionPane.showConfirmDialog(null, p , "Please Enter x and y values" , JOptionPane.OK_CANCEL_OPTION);
     if(result==JOptionPane.OK_OPTION){
         length=Integer.parseInt(lengthField.getText());
          width=Integer.parseInt(widthField.getText());
         x=Integer.parseInt(xField.getText());
           y=Integer.parseInt(yField.getText());
           

    }

   
   
}

    public Triangle(Shape shape) {
        Triangle r=(Triangle) shape;
        this.color = r.color;
        this.width = r.width;
        this.length = r.length;
        this.x = r.x;
        this.y = r.y;
        this.result = r.result;
    }

    public Triangle(int x)
    {this.color=color.red;
        this.width=70;
        this.x=130;
        this.y=140;
          this.length=60;}
        
    @Override
    public void setPosition(Point position) {
        x= position.x;
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
        p.put("width",(double)width);
        p.put("length",(double)length);
         return p;
    }

    @Override
    public void setColor(Color color) {
        this.color=color;
    }

    @Override
    public Color getColor() {
      return this.color=color;  
    }

    @Override
    public void setFillColor(Color color) {
        this.color=color;
    }

    @Override
    public Color getFillColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics canvas) {
        Point location = new Point(x,y);
        Point point2 = new Point(location.x+width,location.y);
         Point point3 = new Point(location.x+(width/2),location.y-length);
         canvas.setColor(this.color);
         int[]intx= {location.x,point2.x,point3.x};
         int[]inty= {location.y,point2.y,point3.y};
         canvas.drawPolygon(intx,inty,3);
         canvas.fillPolygon(intx,inty,3);
         
         
        
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
       Triangle  r=new Triangle(this);
        return r;  
}
}
