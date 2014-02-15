
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.ClassObject;
import models.Relationship;


/**
 * The EditorPane is the container which will draw all of the 2D graphics of the
 * UML Editor. It has to maintain lists of the different types of objects it holds.
 * 
 * @author oRANGE
 */
public class EditorPane extends JPanel {

    private boolean canAddClassObject;
    private boolean isDragging;
    private int isDraggingWho, selectedClassObject;
    private int xOffSet, yOffSet;

    private boolean showPopUp;
    ArrayList<ClassObject> classObjectList = new ArrayList();
    ArrayList<Relationship> relationList = new ArrayList();

    public EditorPane() {
        //If the add class button toggled "on" this will be true and a new classObject can be added
        canAddClassObject = false;
        //This is to determine which of the classObjectes is being dragged in the List
        isDraggingWho = -1;
        isDragging = false;
        
        selectedClassObject = -1;
        showPopUp = false;
        
        //This will determine which is class object is being clicked on to be dragged
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if (classObjectList.size() > 0) {
                    
                    if(selectedClassObject >= 0){
                        classObjectList.get(selectedClassObject).setIsSelected(false);
                        selectedClassObject = -1;
                        repaint();
                    }
                    
                    for (int i = 0; i < classObjectList.size(); i++) {
                        if ((me.getX() > classObjectList.get(i).getxPos())
                                && (me.getY() > classObjectList.get(i).getyPos())
                                && (me.getX() < (classObjectList.get(i).getWidth() + classObjectList.get(i).getxPos()))
                                && (me.getY() < (classObjectList.get(i).getHeight()) + classObjectList.get(i).getyPos())) {
                            if(me.isPopupTrigger()) {
                                togglePopUp();
                                isDraggingWho = i;
                                selectedClassObject = i;
                                classObjectList.get(selectedClassObject).setIsSelected(true);
                                repaint();
                            } else {
                                isDraggingWho = i;
                                isDragging = true;
                                selectedClassObject = i;
                                classObjectList.get(selectedClassObject).setIsSelected(true);
                                xOffSet = me.getX() - classObjectList.get(i).getxPos();
                                yOffSet = me.getY() - classObjectList.get(i).getyPos();
                                repaint();
                                
                            }
                        }
                    }
                }
            }
        });
        
        //This is to reset the class object being dragged to none
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                if(isDraggingWho >= 0 && isDragging == true) {
                    isDraggingWho = -1;
                    isDragging = false;
                }
            }
        });

        //This will dragg the determine class object box
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                if (classObjectList.size() > 0 && isDraggingWho >= 0 && isDragging == true) {
                    moveClassObject(classObjectList.get(isDraggingWho), evt.getX() - xOffSet, evt.getY() - yOffSet);
                    repaint(); 
                }
            }
        });
    }

    //This takes the classObject and coordinates to be moved to
    private void moveClassObject(ClassObject classObject, int x, int y) {
        // Current classObject state, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_X = classObject.getxPos();
        final int CURR_Y = classObject.getyPos();
        final int CURR_W = classObject.getWidth();
        final int CURR_H = classObject.getHeight();
        final int OFFSET = 1;

        if ((CURR_X != x) || (CURR_Y != y)) {

            // The classObject is moving, repaint background 
            // over the old classObject location. 
            repaint(CURR_X, CURR_Y, CURR_W + OFFSET, CURR_H + OFFSET);

            // Update coordinates.
            classObject.setxPos(x);
            classObject.setyPos(y);

            // Repaint the classObject at the new location.
            repaint(classObject.getxPos(), classObject.getxPos(),
                    classObject.getWidth() + OFFSET,
                    classObject.getHeight() + OFFSET);
        }
    }

    //This method paints all components in the EditorPane
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw Text
        g.drawString("Click to insert Class Objects", 10, 20);

        //Draw All Relationship Lines
        for(int i = 0; i < relationList.size(); i++) {
            relationList.get(i).update();
            relationList.get(i).drawLines(g);
        }
        
        //Draw All Class Objects
        for (int i = 0; i < classObjectList.size(); i++) {
            classObjectList.get(i).display(g);
        }
        
    }

    //This method toggles if a new Class object can be added
    public void toggleCanAddClassObject() {
        if (!canAddClassObject) {
            canAddClassObject = true;
        } else {
            canAddClassObject = false;
        }
    }

    public boolean isShowPopUp() {
        return showPopUp;
    }

    public int getIsDraggingWho() {
        return isDraggingWho;
    }

    public void setIsDraggingWho(int isDraggingWho) {
        this.isDraggingWho = isDraggingWho;
    }
    
    
    public void togglePopUp() {
        if (!showPopUp) {
            showPopUp = true;
        } else {
            showPopUp = false;
        }
    }

    public ArrayList<Relationship> getRelationList() {
        return relationList;
    }

    public void setRelationList(ArrayList<Relationship> relationList) {
        this.relationList = relationList;
    }

    public boolean isCanAddClassObject() {
        return canAddClassObject;
    }

    public ArrayList<ClassObject> getClassObjectList() {
        return classObjectList;
    }

    public boolean isIsDragging() {
        return isDragging;
    }

    public void setIsDragging(boolean isDragging) {
        this.isDragging = isDragging;
    }

    public int getSelectedClassObject() {
        return selectedClassObject;
    }

    public void setSelectedClassObject(int selectedClassObject) {
        this.selectedClassObject = selectedClassObject;
    }
    
    
}
