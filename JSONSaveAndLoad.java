/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import paint.model.Shape;
import paint.model.ShapeFactory;

/**
 *
 * @author user
 */
public class JSONSaveAndLoad extends SaveAndLoad {
    JSONParser parser;
    private static JSONSaveAndLoad JSONSaveAndLoadInstance=new JSONSaveAndLoad();
    public static JSONSaveAndLoad getInstance(){
        if(JSONSaveAndLoadInstance==null) JSONSaveAndLoadInstance=new JSONSaveAndLoad();
        return JSONSaveAndLoadInstance;
    }
    
    

public void save(File fileToSaveTo, ArrayList<Shape> listofShapes,String[] shapeIdentifiers ) throws IOException{
    JSONObject shapes=new JSONObject();
    int counter = 0;
    for( Shape s: listofShapes){
        JSONObject JSONshape = new  JSONObject();
        System.out.println(s.getColor().getRed());
        JSONshape.put("type", ""+s.getClass().getSimpleName());
        JSONshape.put("red", ""+s.getColor().getRed());
        JSONshape.put("green", ""+s.getColor().getGreen());
        JSONshape.put("blue", ""+s.getColor().getBlue());
        JSONshape.put("x",""+s.getPosition().getX());
        JSONshape.put("y",""+s.getPosition().getY());
        
        HashMap<String,Double> properties = (HashMap<String,Double>) s.getProperties();
        Set set = properties.entrySet();
        Iterator iterator = set.iterator();
        
        while(iterator.hasNext()){
        Map.Entry mapEntry = (Map.Entry) iterator.next();
        JSONshape.put(mapEntry.getKey(), ""+mapEntry.getValue());
        
        }
        shapes.put(shapeIdentifiers[counter++] , JSONshape);
    }
try{
FileWriter f = new FileWriter (fileToSaveTo);
f.write(shapes.toString());
f.flush();


}
catch(IOException E){
    System.out.println(E);
}           
        
        
    
}  
public void load(File fileToLoadFrom) throws FileNotFoundException, IOException, ParseException{
JSONParser parser= new JSONParser();
        ArrayList<Shape> listofShapes = new ArrayList<>();
        ArrayList<Shape> shapesNames = new ArrayList<>();
        try{
        Object obj = parser.parse(new FileReader(fileToLoadFrom));
        JSONObject shapes = (JSONObject) obj;
        for(Object shapeKey : shapes.keySet()){
        String shapeKeyStr = (String) shapeKey;
        JSONObject shapeJSONObject = (JSONObject) shapes.get(shapeKeyStr);
        int red=0,green=0,blue=0,x=0,y=0;
        HashMap<String,Double> properties = new HashMap<>();
        Shape s = null;
        for(Object attribute : shapeJSONObject.keySet()){
            String attributeString =(String) attribute;
            switch(attributeString){
            case"type":
                s= ShapeFactory.createShape((String) shapeJSONObject.get("type"));
                break;
                case"red":
               String redString = (String) shapeJSONObject.get("red");
                red = Integer.parseInt(redString);
                break;
                 case"blue":
               String blueString = (String) shapeJSONObject.get("blue");
                blue = Integer.parseInt(blueString);
                break;
                 case"green":
               String greenString = (String) shapeJSONObject.get("green");
                green = Integer.parseInt(greenString);
                break;
                 case "x":
                     x= Double.valueOf((String)shapeJSONObject.get("x")).intValue();
                     break;
                     case "y":
                     y= Double.valueOf((String)shapeJSONObject.get("y")).intValue();
                     break;
                     default:
                         String value = (String)shapeJSONObject.get(attributeString);
                         double valueDouble = Double.parseDouble(value);
                        properties.put(attributeString, valueDouble);
                
               
            }
        }
        Color color = new Color (red , green , blue);
        s.setColor(color);
        }
        
        }

}

}

        