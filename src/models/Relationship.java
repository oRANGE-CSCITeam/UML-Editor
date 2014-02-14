/*
 *This a relationship class that will hold information suchas what type of
 *relationship as well as the
 */

package models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author marcos
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
    
    public void update() {
        mX = (mainC.getWidth() / 2) + mainC.getxPos();
        mY = (mainC.getHeight() / 2) + mainC.getyPos();
        
        dX = (derivedC.getWidth() / 2) + derivedC.getxPos();
        dY = (derivedC.getHeight() / 2) + derivedC.getyPos();
    }
    
    public void drawLines(Graphics g){
        g.setColor(Color.black);
        g.drawLine(mX, mY, dX, dY);    
    }

    public ClassObject getMainC() {
        return mainC;
    }

    public int getmX() {
        return mX;
    }

    public int getmY() {
        return mY;
    }

    public ClassObject getDerivedC() {
        return derivedC;
    }

    public int getdX() {
        return dX;
    }

    public int getdY() {
        return dY;
    }

    public int getrType() {
        return rType;
    }

    public void setMainC(ClassObject mainC) {
        this.mainC = mainC;
    }

    public void setmX(int mX) {
        this.mX = mX;
    }

    public void setmY(int mY) {
        this.mY = mY;
    }

    public void setDerivedC(ClassObject derivedC) {
        this.derivedC = derivedC;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public void setrType(int rType) {
        this.rType = rType;
    }
    
    
}
