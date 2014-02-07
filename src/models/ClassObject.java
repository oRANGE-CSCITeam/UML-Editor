/*
 *This object represents the Class Object or box for the UML editor to hold all
 *of the data of each instance of a Class Object.
 */

package models;

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
    
    public ClassObject(String name){
        this.name = name;
        attributes = new ArrayList<String>();
        operations = new ArrayList<String>();
        relationMap = new HashMap<ClassObject, Relationship>();
    }
    
    /*
     * Adds an attribute to the class object, must provide wether it is a private
     * attribute with the parameter boolean isPrivate.
     */
    public void addAttribute(String attributeName, boolean isPrivate){
        if(isPrivate){
            attributes.add(attributeName + " -");
        } else{
            attributes.add(attributeName + " +");
        }
    }
    
    public void removeAttribute(int index){
        attributes.remove(index);
    }
    
    public void removeAllAtributes(){
        attributes.clear();
    }
    
    public void addOperation(String operationName){
        operations.add(operationName);
    }
    
    public void removeOperation(int index){
        operations.remove(index);
    }
    
    public void removeAllOperations(){
        operations.clear();
    }
    
    public void addRelationship(ClassObject classObject, Relationship relationship){
        relationMap.put(classObject, relationship);
    }
    
    public void removeRelationship(ClassObject classObject){
        relationMap.remove(classObject);
    }
    
    public void removeAllRelationships(){
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
    
    
}
