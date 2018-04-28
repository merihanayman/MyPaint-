/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import paint.model.Shape;

/**
 *
 * @author user
 */
public class ShapeMemento {
    ArrayList <Shape> listOfShapes;

    public ShapeMemento(ArrayList<Shape> state) {
        this.listOfShapes =  new ArrayList<>();
        try{
            for(Shape s: state)
                listOfShapes.add((Shape)s.clone());
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
   public ArrayList<Shape> getState(){
       return listOfShapes;
       
   }
}
