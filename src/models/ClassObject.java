/*
 *This object represents the Class Object or box for the UML editor to hold all
 *of the data of each instance of a Class Object.
 */

package models;

import java.util.Map;

/**
 *
 * @author marcos
 */
public class ClassObject {
    private String name;
    private String[] attributes;
    private String[] operations;
    private Map<ClassObject, Relationship> relationMap;
    
    public ClassObject(String name){
        this.name = name;
        
    }
    
}
