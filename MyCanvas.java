/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;
import paint.model.Shape;
import paint.controller.DrawingEngine;
import paint.controller.PaintControl;
import paint.model.Rectangle;
import static paint.view.MyCanvas.shapesList;
import paint.controller.PaintControl;

/**
 *
 * @author user
 */
public class MyCanvas extends JPanel implements DrawingEngine, MouseListener, MouseMotionListener {

    public static ArrayList<Shape> shapesList;
    public static ArrayList<Shape> undoneshapes;
    ArrayList<Class<? extends Shape>> supportedshapes;

    public MyCanvas() {
        addMouseMotionListener(this);
    addMouseListener(this);
        int x1, x2, y1, y2;
        Shape shapetodraw;
//        MyCanvas c = this;
//         @Override
//    public void mouseClicked(MouseEvent e) {
//        System.out.println("clicke");     
//        
//    }
        shapesList = new ArrayList<>();
        undoneshapes = new ArrayList<>();
        supportedshapes = new ArrayList<>();
        
//        this.addMouseListener(new MouseAdapter() {
//        public void mousePressed(MouseEvent e) {
//           Point startDrag = new Point(e.getX(), e.getY());
//          Point endDrag = startDrag;
//          shapesList.
//          repaint();
//        }
//
//        public void mouseReleased(MouseEvent e) {
//          Shape r = makeRectangle(startDrag.x, startDrag.y, e.getX(), e.getY());
          
//          startDrag = null;
//          endDrag = null;
//          repaint();
//        }
//      });
//
//      this.addMouseMotionListener(new MouseMotionAdapter() {
//        public void mouseDragged(MouseEvent e) {
//          endDrag = new Point(e.getX(), e.getY());
//          repaint();
//        }
//      });
//    }

    }

    public ArrayList<Shape> getShapesList() {
        return shapesList;
    }

    public void setShapesList(ArrayList<Shape> shapeList) {
        this.shapesList = shapeList;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapesList) {
            s.draw(g);
        }
    }

    @Override
    public void addShape(Shape shape) {
        undoneshapes = new ArrayList<>();
        shapesList.add(shape);
        this.repaint();

    }

    @Override
    public void removeShape(Shape shape) {
        shapesList.remove(shape);
        System.out.println("Here");
        this.repaint();

    }

    public void removeall() {
        System.out.println("xxx");
        for (Shape s : shapesList) {
            removeShape(s);
        }
    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Shape[] getShapes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        if (shapesList.size() == 0) {
            return;
        }
        undoneshapes.add((shapesList.remove(shapesList.size() - 1)));
        this.repaint();
    }

    @Override
    public void redo() {
        if (undoneshapes.size() == 0) {
            return;
        }
        shapesList.add((undoneshapes.remove(undoneshapes.size() - 1)));
        this.repaint();
    }

    @Override
    public void save(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Class<? extends Shape>> getSupportedShapes() {
        return supportedshapes;

    }

    public void installPluginShape(Class<? extends Shape> shapeClass) {
        supportedshapes.add(shapeClass);

    }

    @Override
    public void installPluginShape(String jarPath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refresh(Graphics canvas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private int x1,x2,y1,y2;
       
        boolean pressed;
        boolean dragged;
     MyCanvas c = this;
      
            
            
            @Override
            public void mousePressed(MouseEvent e) {
                 x1 = e.getX();
                y1=e.getY();
                
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
           for(Shape s : c.shapesList)
            {
                if (s.getPosition()== new Point(x1,y1))
                   
                if(supportedshapes==null) return;
           {    int x2 = e.getX();
               int y2 = e.getY();
               s.setPosition(new Point(x2,y2));
               int width=x2-x1;
               int height=y2-y1;
               HashMap<String,Double> properties=new HashMap<String,Double>();
               properties.put("width",new Double(width));
               properties.put("height",new Double(height));
               int min=Math.min(height,width);
               properties.put(" diameter ",new Double(min));
               properties.put("side length",new Double(min));
               //s.setProperties(properties);
               supportedshapes=null;
               //controllerRef.setmemento();
               c.repaint(); 
                }
                        
                        }
          }    
     

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicke");     
        
    }

   

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
        
}