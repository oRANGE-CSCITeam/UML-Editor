
package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This object represents the Class Object or box for the UML editor to hold all
 * of the data of each instance of a Class Object.
 * 
 * @author oRANGE
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
    private boolean isClicked;
    private final int widthScale = 7;
    private Color color;
    private boolean isSelected;

    /**
     * Constructor for the class object
     * @param newName - name of the newly created class
     * @param xPos - the class x-coordinate
     * @param yPos - the class y-coordinate
     */
    public ClassObject(String newName, int xPos, int yPos) {
        
        attributes = new ArrayList<String>();
        operations = new ArrayList<String>();
        relationMap = new HashMap<ClassObject, Relationship>();

        this.name = newName;
        this.xPos = xPos;
        this.yPos = yPos;

        this.width = setWidth() * widthScale + 10;
        this.height = 20;
        
        color = Color.orange;
        isClicked = false;
        isSelected = false;
    }

    

    /**
     * Adds an attribute to the class object
     * 
     * @param attributeName - name of the attribute
     * @param isPrivate - if attribute is private of public
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

    /**
     * Removes an attribute
     * @param index - location in the ArrayList to be removed
     */
    public void removeAttribute(int index) {
        attributes.remove(index);
        this.width = setWidth() * widthScale + 10;
    }

    /**
     * Removes all attributes. ArrayList of Attributes becomes empty
     */
    public void removeAllAtributes() {
        attributes.clear();
        this.width = setWidth() * widthScale + 10;
    }

    /**
     * Add an operation to the class
     * @param operationName 
     */
    public void addOperation(String operationName) {
        if(!operationName.equals("")){
            operations.add(operationName);
            this.width = setWidth() * widthScale + 10;
            this.height += 20;
        }
    }

    /**
     * Removes a specified operation
     * @param index
     */
    public void removeOperation(int index) {
        operations.remove(index);
        this.width = setWidth() * widthScale + 10;
    }

    /**
     * Removes all operations. ArrayList of operations becomes empty
     */
    public void removeAllOperations() {
        operations.clear();
        this.width = setWidth() * widthScale + 10;
    }

    /**
     *  
     * @param classObject
     * @param relationship
     */
    public void addRelationship(ClassObject classObject, Relationship relationship) {
        relationMap.put(classObject, relationship);
    }

    public void removeRelationship(ClassObject classObject) {
        relationMap.remove(classObject);
    }

    public void removeAllRelationships() {
        relationMap.clear();
    }

    /**
     * Return name of class
     * @return name -  the name of the class
     */
    public String getName() {
        return name;
    }

    /**
     * Returns ArrayList containing all attributes.
     * @return attributes - holds all the attributes
     */
    public ArrayList<String> getAttributes() {
        return attributes;
    }

    /**
     * Returns ArrayList containing all operations
     * @return operations - hold all the operations
     */
    public ArrayList<String> getOperations() {
        return operations;
    }

    public Map<ClassObject, Relationship> getRelationMap() {
        return relationMap;
    }

    /**
     * Returns x-coordinate of class object
     * @return - x-coordinate
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * Returns y-coordinate of class object
     * @return - y coordinate
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * Returns width of class object
     * @return width of the object
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns height of the class object
     * @return height of the object
     */
    public int getHeight() {
        if(operations.size() > 0 && attributes.size() == 0) {
            return height + 20;
        } else {
            return height;
        } 
    }

    /**
     * Sets a predetermined x-coordinate for the object
     * @param xPos
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Sets a predetermined y-coordinate for the object
     * @param yPos
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * Returns color with which the object is filled
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets a color chosen by the user to fill the object
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Graphically displays the class object to look like a box
     * @param g
     */
    public void display(Graphics g) {
        //Draws the box for the entire classObject
        g.setColor(new Color(0, 0, 0, 100));
        g.fillRect(xPos + 3, yPos + 3, width, getHeight());
        g.setColor(color);
        g.fillRect(xPos, yPos, width, getHeight());

        //Draws border for name
        g.setColor(Color.black);
        g.drawRect(xPos, yPos, width, 20);

        //Draws border for attributes
        if(operations.size() > 0 && attributes.size() == 0){
            g.drawRect(xPos, yPos + 20, width, 20);
        } else {
            g.drawRect(xPos, yPos + 20, width, attributes.size() * 20);
        }
        
        //Draws border for operations
        if(operations.size() > 0 && attributes.size() == 0) {
            g.drawRect(xPos, yPos + 40, width, operations.size() * 20);
        } else {
            g.drawRect(xPos, yPos + (attributes.size() * 20) + 20, width, operations.size() * 20);
        }

        //Draws the name
        g.setColor(Color.black);
        g.drawString(name, xPos + 5, yPos + 15);

        //Draws Attributes
        for(int i = 0; i < attributes.size(); i++) {
            g.drawString(attributes.get(i), xPos + 5, (yPos + 35) + (i * 20));
        }
        
        //Draw Operations
        if(operations.size() > 0 && attributes.size() == 0) {
            for(int i = 0; i < operations.size(); i++) {
                g.drawString(operations.get(i), xPos + 5, (20 + (yPos + 35)) + (i * 20));
            }
        } else {
            for(int i = 0; i < operations.size(); i++) {
                g.drawString(operations.get(i), xPos + 5, ((attributes.size() * 20) + (yPos + 35)) + (i * 20));
            }
        }
        
        //Draw Selected Highlight
        if(isSelected){
            for(int i = 0; i < 3; i++) {
                g.setColor(Color.DARK_GRAY);
                g.drawRect(xPos + i, yPos + i, width , getHeight());
            }
        }
    }

    /**
     * Returns if the object is being clicked
     * @return
     */
    public boolean isClicked() {
        return isClicked;
    }

    /**
     * Sets the object as clicked
     * @param bool
     */
    public void setIsClicked(boolean bool) {
        isClicked = bool;
    }
    
    /**
     * Returns longest string in the attribute list
     * @return
     */
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

    /**
     * Returns longest string in the operation list
     * @return
     */
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
    
    /**
     * Sets a predetermined width for the object
     * @return
     */
    public int setWidth(){
        int max = Math.max(name.length(), getLongestAttribute());
        return Math.max(max, getLongestOperation());
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    
}
