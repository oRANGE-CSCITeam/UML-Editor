
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import models.ClassObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcos
 */
public class EditorPane extends JPanel {
    private boolean canAddClassObject;
    private int isDragging;
    private int j = 0;
    ArrayList<ClassObject> classObjectList = new ArrayList();
    
    public EditorPane() {
        canAddClassObject = false;
        isDragging = -1;
        
        //Listen to click and will create a new classObject to be displayed.
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                if(canAddClassObject){
                    classObjectList.add(new ClassObject("My SuperClass", evt.getX() - 20, evt.getY() - 20));
                    classObjectList.get(j).addAttribute("names", true);
                    classObjectList.get(j).addAttribute("numbers", false);
                    j++;  
                }
                repaint();
            }
            
        });
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if(classObjectList.size() > 0){
                    for(int i = 0; i < classObjectList.size(); i++){
                        if((me.getX() > classObjectList.get(i).getxPos())
                                && (me.getY() > classObjectList.get(i).getyPos()) && (me.getX() < (classObjectList.get(i).getWidth() + classObjectList.get(i).getxPos())) && (me.getY() < (classObjectList.get(i).getHeight()) + classObjectList.get(i).getyPos())){
                                       isDragging = i;         
                        }
                    } 
                }
            }
        });

        
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                if(classObjectList.size() > 0){
                    for(int i = 0; i < classObjectList.size(); i++){
                        if((evt.getX() > classObjectList.get(i).getxPos())
                                && (evt.getY() > classObjectList.get(i).getyPos()) && (evt.getX() < (classObjectList.get(i).getWidth() + classObjectList.get(i).getxPos())) && (evt.getY() < (classObjectList.get(i).getHeight()) + classObjectList.get(i).getyPos())){
                                    
                                    moveClassObject(classObjectList.get(isDragging),evt.getX() - 20, evt.getY() - 20);
                                    
                        }
                    }
                }   
            }      
        });
        
    }
    
    
    
    private void moveClassObject(ClassObject classObject, int x, int y) {
        // Current classObject state, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_X = classObject.getxPos();
        final int CURR_Y = classObject.getyPos();
        final int CURR_W = classObject.getWidth();
        final int CURR_H = classObject.getHeight();
        final int OFFSET = 1;

        if ((CURR_X!=x) || (CURR_Y!=y)) {

            // The classObject is moving, repaint background 
            // over the old classObject location. 
            repaint(CURR_X,CURR_Y,CURR_W+OFFSET,CURR_H+OFFSET);

            // Update coordinates.
            classObject.setxPos(x);
            classObject.setyPos(y);

            // Repaint the classObject at the new location.
            repaint(classObject.getxPos(), classObject.getxPos(), 
                    classObject.getWidth()+OFFSET, 
                    classObject.getHeight()+OFFSET);
        } 
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw Text
        g.drawString("Click to insert Class Objects", 10, 20);
        
        //Draw All Class Objects
        for(int i = 0; i < classObjectList.size(); i++){
            classObjectList.get(i).display(g);
        }   
    }  
    
    public void toggleCanAddClassObject(){   
        if(!canAddClassObject){
            canAddClassObject = true;
        } else{
            canAddClassObject = false;
        }
    }
}
