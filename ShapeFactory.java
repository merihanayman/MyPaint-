/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

public class ShapeFactory {
    public static Shape createShape(String type){
    switch(type){
    case"Ellipse":
        return new Oval();
        case"Rectangle":
        return new Rectangle();
        case"Circle":
        return new Circle();
        case"Line":
        return new Line();
        case"Square":
        return new Square();
        case"Triangle":
        return new Triangle();
        
    
    }    
        return null;
        
    }
    
}