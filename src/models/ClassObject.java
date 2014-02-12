/*
 *This object represents the Class Object or box for the UML editor to hold all
 *of the data of each instance of a Class Object.
 */
package models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marcos
 */
public class ClassObject {

    private String name;
    private ArrayList<String> attributes;
    private ArrayList<String> operations;
    private Map<ClassObject, Relationship> relationMap;

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private boolean isClicked = false;
    private int widthScale = 7;
    private Color color = Color.orange;

    public ClassObject(String newName, int xPos, int yPos) {
        attributes = new ArrayList<String>();
        operations = new ArrayList<String>();
        relationMap = new HashMap<ClassObject, Relationship>();

        this.name = newName;
        this.xPos = xPos;
        this.yPos = yPos;

        this.width = setWidth() * widthScale + 10;
        this.height = 20;
    }

    /*
     * Adds an attribute to the class object, must provide wether it is a private
     * attribute with the parameter boolean isPrivate.
     */
    public void addAttribute(String attributeName, boolean isPrivate) {
        if(!attributeName.equals("")){
            if (isPrivate) {
                attributes.add("- " + attributeName);
            } else {
                attributes.add("+ " + attributeName);
            }
            this.width = setWidth() * widthScale + 10;
            this.height += 20;
        }
    }

    public void removeAttribute(int index) {
        attributes.remove(index);
        this.width = setWidth() * widthScale + 10;
    }

    public void removeAllAtributes() {
        attributes.clear();
        this.width = setWidth() * widthScale + 10;
    }

    public void addOperation(String operationName) {
        if(!operationName.equals("")){
            operations.add(operationName);
            this.width = setWidth() * widthScale + 10;
        }
    }

    public void removeOperation(int index) {
        operations.remove(index);
        this.width = setWidth() * widthScale + 10;
    }

    public void removeAllOperations() {
        operations.clear();
        this.width = setWidth() * widthScale + 10;
    }

    public void addRelationship(ClassObject classObject, Relationship relationship) {
        relationMap.put(classObject, relationship);
    }

    public void removeRelationship(ClassObject classObject) {
        relationMap.remove(classObject);
    }

    public void removeAllRelationships() {
        relationMap.clear();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public ArrayList<String> getOperations() {
        return operations;
    }

    public Map<ClassObject, Relationship> getRelationMap() {
        return relationMap;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void display(Graphics g) {
        //Draws the box for the entire classObject
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);

        //Draws border for name
        g.setColor(Color.black);
        g.drawRect(xPos, yPos, width, 20);

        //Draws border for attributes
        g.drawRect(xPos, yPos + 20, width, attributes.size() * 20);

        //Draws the name
        g.setColor(Color.black);
        g.drawString(name, xPos + 5, yPos + 15);

        //Draws Attributes
        for (int i = 0; i < attributes.size(); i++) {
            g.drawString(attributes.get(i), xPos + 5, (yPos + 35) + (i * 20));
        }
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setIsClicked(boolean bool) {
        isClicked = bool;
    }
    
    public int getLongestAttribute() {
        int max = 0;
        int setMax = 0;
        for(int i = 0; i < attributes.size(); i++)
            if(attributes.get(i).length() >= attributes.get(max).length()){
                max = i;
                setMax = attributes.get(max).length();
            }
        return setMax;    
    }
    
        public int getLongestOperation() {
        int max = 0;
        int setMax = 0;
        for(int i = 0; i < operations.size(); i++)
            if(operations.get(i).length() >= operations.get(max).length()){
                max = i;
                setMax = operations.get(max).length();
            }
        return setMax;    
    }
    
    public int setWidth(){
        int max = Math.max(name.length(), getLongestAttribute());
        return Math.max(max, getLongestOperation());
    }
}
