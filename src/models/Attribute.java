/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 * Attribute class that hold all the basic information needed for an 
 * attribute
 * 
 * @author oRANGE
 */
public class Attribute {
    private String attributeName;
    private boolean type;
    
    /**
     * Constructor for a new attribute
     * 
     * @param attributeName
     * @param type
     */
    public Attribute(String attributeName, boolean type){
        this.attributeName = attributeName;
        this.type = type;
    }

    /**
     * Returns name of the attribute
     * @return
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Sets a predetermined name for the attribute
     * @param attributeName
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * Returns if type is private or public
     * @return
     */
    public boolean isType() {
        return type;
    }

    /**
     * Sets the attribute to be private of public
     * @param type
     */
    public void setType(boolean type) {
        this.type = type;
    }
    
    
    
}
