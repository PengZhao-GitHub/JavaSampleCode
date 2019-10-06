
import java.beans.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Vector;
import java.util.EventObject;

public class SimpleBean extends Canvas
                        implements Serializable
{
    private Color color = Color.green;
    private Vector listener = new Vector();    

    //Constructor sets inherited properties
    public SimpleBean(){
        setSize(60,40);
        setBackground(color);
    }

    public Color getColor(){
    	return color;
    } 

    public void setColor(Color newColor) {
    	Color oldColor = color;
	color = newColor;
    	repaint();
    }

    public void paint(Graphics g) {
	g.setColor(color);
	g.fillRect(20,5,20,30);
    }

    //Mehtods
    public void Hello() {
	
	
    }

    // Add event 
    public synchronized void addMyTestListener(MyTestListener i){
	listener.addElement(i);
    }
	
    public synchronized void removeMyTestListener(MyTestListener i){
	listener.removeElement(i);
    }

    //fire the event
    protected void notifyMyTest() {

	Vector l;
	MyTestEvent e = new MyTestEvent("Cool");
	
   	synchronized(this) { 
		l = (Vector) listener.clone(); 
	}

	for (int i=0; i<l.size(); i++) {
		((MyTestListener)l.elementAt(i)).Cool(e);
	}
    }
}
