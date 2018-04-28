 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import paint.model.Shape;
import paint.view.MyCanvas;

/**
 *
 * @author user
 */ 
public class PaintControl implements DrawingEngine {
    
MyCanvas myCanvas;
ArrayList<ShapeMemento> mementotoList;
int counter;
private String[] shapesNames;
    public PaintControl(MyCanvas myCanvas) {
        this.myCanvas=myCanvas;
        mementotoList = new ArrayList<>();
        mementotoList.add(new ShapeMemento(new ArrayList<>()));
        counter = 0;
        
    }

    @Override
    public void refresh(Graphics canvas) {
        myCanvas.repaint();
    }

    @Override
    public void addShape(Shape shape) {
        changeCheck();
        myCanvas.getShapesList().add(shape);
        ShapeMemento newMemento = new ShapeMemento(myCanvas.getShapesList());
        mementotoList.add(newMemento);
        System.out.println("Counter : "+ counter);
        counter = mementotoList.size()-1;
        System.out.println("Counter : "+ counter);
        myCanvas.repaint();
    }

    @Override
    public void removeShape(Shape shape) {
    changeCheck();
        myCanvas.getShapesList().remove(shape);
        ShapeMemento newMemento = new ShapeMemento(myCanvas.getShapesList());
        mementotoList.add(newMemento);
        System.out.println("Counter : "+ counter);
        counter = mementotoList.size()-1;
        System.out.println("Counter : "+ counter);
    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
   changeCheck();
   int index = myCanvas.getShapesList().indexOf(oldShape);
   myCanvas.getShapesList().remove(oldShape);
   myCanvas.getShapesList().add(index,newShape);
   ShapeMemento newMemento = new ShapeMemento(myCanvas.getShapesList());
   mementotoList.add(newMemento);
    }

    @Override
    public Shape[] getShapes() {
    Shape[] ShapesArray = myCanvas.getShapesList().toArray(new Shape[myCanvas.getShapesList().size()]);
     return ShapesArray;   
       
    }

    @Override
    public void undo() {
     if(counter< 0) return;
     int c= counter;
        System.out.println(" hhh");
     ArrayList<Shape> previousState =mementotoList.get(--counter).getState();
             myCanvas.setShapesList(previousState);
             System.out.println("Counter : "+ counter);
             System.out.println(" lll");
             myCanvas.repaint();
    }

    @Override
    public void redo() {
        System.out.println("mm");
    if(counter>mementotoList.size()-1) return;
        ArrayList<Shape> previousState = mementotoList.get(++counter).getState();
        myCanvas.setShapesList(previousState);
        System.out.println("Counter : "+ counter);
        myCanvas.repaint();
        System.out.println("bb");
    }

   @Override
    public void save(String path) {
       File filetosaveTo =new File (path);
       JSONSaveAndLoad saver = JSONSaveAndLoad.getInstance();
    try {
        saver.save(filetosaveTo, myCanvas.getShapesList(), shapesNames);
    } catch (IOException ex) {
        Logger.getLogger(PaintControl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void load(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Class<? extends Shape>> getSupportedShapes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void installPluginShape(String jarPath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void changeCheck() {
        System.out.println("Counter : "+ counter);
    if (counter< mementotoList.size()-1){
    mementotoList = new ArrayList<>();
   // counter =0;
    }    
    }

    public void setShapesNames(String[] shapesNames) {
        this.shapesNames= shapesNames;
    }

  
    
}
