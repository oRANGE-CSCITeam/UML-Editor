
package models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class that will hold information such as what type of
 * relationship as well as the ????
 * @author oRANGE
 */
public class Relationship  {
    private ClassObject mainC;
    private int mX;
    private int mY;
    
    private ClassObject derivedC;
    private int dX;
    private int dY;
    
    private int rType;
    
    /**
     * Creates a new Relationship
     * 
     * @param mainClass main class of the relationship
     * @param derivedClass the derived class of the relationship
     * @param mainX x-coordinate of main class
     * @param mainY y-coordinate of main class
     * @param derivedX x-coordinate of derived class
     * @param derivedY y-coordinate of derived class
     * @param relaType relationship type.
     */
        
    public Relationship(ClassObject mainClass, ClassObject derivedClass, int relaType){
        mainC = mainClass;
        mX = (mainC.getWidth() / 2) + mainC.getxPos();
        mY = (mainC.getHeight() / 2) + mainC.getyPos();
        
        derivedC = derivedClass;
        dX = (derivedC.getWidth() / 2) + derivedC.getxPos();
        dY = (derivedC.getHeight() / 2) + derivedC.getyPos();
        
        rType = relaType;
        
    }
    
    /**
     *
     */
    public void update() {
        mX = (mainC.getWidth() / 2) + mainC.getxPos();
        mY = (mainC.getHeight() / 2) + mainC.getyPos();
        
        dX = (derivedC.getWidth() / 2) + derivedC.getxPos();
        dY = (derivedC.getHeight() / 2) + derivedC.getyPos();
    }
    
    /**
     * Draws the line relationship between one class and the other
     * @param g
     */
    public void drawLines(Graphics g){
        g.setColor(Color.black);
        g.drawLine(mX, mY, dX, dY);    
    }

    /**
     * Returns information about the main class in a relationship
     * @return mainC -  the main class
     */
    public ClassObject getMainC() {
        return mainC;
    }

    /**
     * Returns the x-coordinate of the main class
     * @return mX - x-coordinate of main class
     */
    public int getmX() {
        return mX;
    }

    /**
     * Returns y-coordinate of the main class
     * @return mY - y-coordinate of main class
     */
    public int getmY() {
        return mY;
    }

    /**
     * Returns the derived class in the relationship
     * @return derivedC - the derived class
     */
    public ClassObject getDerivedC() {
        return derivedC;
    }

    /**
     * Returns the x-coordinate of the derived class
     * @return dX - x-coordinate of derived class
     */
    public int getdX() {
        return dX;
    }

    /**
     * Returns the y-coordinate of the derived class
     * @return dY - y coordinate of derived class
     */
    public int getdY() {
        return dY;
    }

    /**
     * Return relationship type of the classes
     * @return rType - integer corresponding relationship type
     */
    public int getrType() {
        return rType;
    }

    /**
     * Sets main class to which ever class the user decides
     * @param mainC - the class the user decides to be the main class
     */
    public void setMainC(ClassObject mainC) {
        this.mainC = mainC;
    }

    /**
     * Sets a predetermined x-coordinate for the main class
     * @param mX - the new x-coordinate for the main class
     */
    public void setmX(int mX) {
        this.mX = mX;
    }

    /**
     * Sets a predetermined y-coordinate for the main class
     * @param mY - new y-coordinate for the main class
     */
    public void setmY(int mY) {
        this.mY = mY;
    }

    /**
     * Set the derived class to be whichever the user wants
     * @param derivedC - the derived class
     */
    public void setDerivedC(ClassObject derivedC) {
        this.derivedC = derivedC;
    }

    /**
     * Sets a predetermined x-coordinate for the derived class
     * @param dX - new x-coordinate
     */
    public void setdX(int dX) {
        this.dX = dX;
    }

    /**
     * Sets a predetermined y-coordinate for the derived class
     * @param dY - the new y-coordinate
     */
    public void setdY(int dY) {
        this.dY = dY;
    }

    /**
     * Sets the relationship type be the one chosen by the user
     * @param rType - the relationship type
     */
    public void setrType(int rType) {
        this.rType = rType;
    }
    
    
}
