/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

;

/**
 *
 * @author DELL
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author DELL -
 */


public class Oval implements Shape {

    Color color;
    int x;
    int y;
    public int result;
    int hAxis;
    int vAxis;

    public Oval() {
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField vAxisField = new JTextField(5);
        JTextField hAxisField = new JTextField(5);
       // vAxisField.setText("0");
       // hAxisField.setText("0");
       // xField.setText("" + x);
       // yField.setText("" + y);
        JPanel p = new JPanel();
        p.add(new JLabel("x:"));
        p.add(xField);
        p.add(Box.createHorizontalStrut(15)); // a spacer 
        p.add(new JLabel("y:"));
        p.add(yField);
        p.add(Box.createHorizontalStrut(15));
        p.add(new JLabel("V-Axis: "));
        p.add(vAxisField);
        p.add(Box.createHorizontalStrut(15));
        p.add(new JLabel("H-Axis: "));
        p.add(hAxisField);
        result = JOptionPane.showConfirmDialog(null, p,
                "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            hAxis = Integer.parseInt(hAxisField.getText());
            vAxis = Integer.parseInt(vAxisField.getText());
            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
        }
    }


    public Oval(Shape shape) {
        Oval r = (Oval) shape;
        this.color = r.color;
        this.hAxis = r.hAxis;
        this.vAxis = r.vAxis;
        this.x = this.x;
        this.y = r.y;
        this.result = r.result;
    }
    public Oval(int x)
    {
    this.color=color.red;
        this.vAxis=50;
        this.x=150;
        this.y=100;
        this.hAxis= 70;
    }

    @Override
    public void setPosition(Point position) {
        x = position.x;
        y = position.y;
    }

    @Override
    public Point getPosition() {
        return new Point(x, y);
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Double> getProperties() {
         HashMap<String, Double> p= new HashMap<>();
        p.put("v-axis",(double)vAxis);
  p.put("H-axis",(double)hAxis);
         return p;
    }

    @Override
    public void setColor(Color color) {
        this.color = color; //To change body of generated methods, choose Tools | Templates.
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
        canvas.drawOval(x, y, hAxis, vAxis);
        canvas.fillOval(x, y, hAxis, vAxis);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Oval r = new Oval(this);
        return r;
    }

}
