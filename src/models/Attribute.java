/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author marcos
 */
public class Attribute {
    private String attributeName;
    private boolean type;
    
    public Attribute(String attributeName, boolean type){
        this.attributeName = attributeName;
        this.type = type;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
    
    
    
}
