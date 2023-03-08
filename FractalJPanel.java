package finalFractal;

//this part of the program draws and calculates the fractals
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
 import java.awt.Dimension;
 import javax.swing.JPanel;
 import java.awt.geom.Ellipse2D;
 public class FractalJPanel extends JPanel
 {
 private Color color; // color used 
 private int level; //fractal level
 private static final int WIDTH = 800; // width of JPanel
 private static final int HEIGHT = 800; // height of JPanel
 public FractalJPanel( int currentLevel )
 {
color = Color.BLUE; // starting color
level = currentLevel; // set initial fractal level
 setBackground( Color.WHITE );//set back ground as white
 setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
} // end FractalJPanel constructor
static void drawTree(Graphics g, int xA, int yA, double angle, int level) {//draws fractal that resembles tree
   
	if (level == 0)
		g.drawLine(xA, yA, xA, yA);//draws initial line
    else{//calculates second position
    int xB = xA + (int) (Math.cos(Math.toRadians(angle)) * level * 10);//casts long into int adds it to xA(uses cos to get x and sin for y)
    int yB = yA + (int) (Math.sin(Math.toRadians(angle)) * level * 10);
    g.drawLine(xA, yA, xB, yB);//draws new lines
    drawTree(g, xB, yB, angle - 15, level - 1);//draws with decreased angles and new points
    drawTree(g, xB, yB, angle + 15, level - 1);//draws with increased angles and new points
  
    }
}
void drawTriangles(Graphics g, int xMid, int yMid, int radius, int level) {
    // end recursion
    if(level==0)
    {
	    g.drawLine(xMid, yMid, xMid+level, yMid+level);//draws new lines
   		g.drawLine(xMid+level, yMid+level,xMid, yMid);//draws new lines
    }
    else
    {
    g.drawLine(xMid, yMid,xMid+radius, yMid-radius);//draws new lines
    g.drawLine(xMid-radius, yMid-radius,xMid+radius, yMid-radius);//draws new lines
    g.drawLine(xMid-radius, yMid-radius,xMid, yMid);//draws new lines
   
    drawTriangles(g, (int)(xMid+radius/2), (int)(yMid-radius/2), radius /2,level-1);
    drawTriangles(g, (int)(xMid-radius/2), (int)(yMid-radius/2), radius /2,level-1);
    drawTriangles(g, (int)(xMid), (int)(yMid), radius /2,level-1);
    
    }
}
 void drawCircles(Graphics g, int xMid, int yMid, int radius, int level) {
	    // end recursion
	    if(level==0)
	    	 g.drawOval(xMid - radius, yMid - radius, radius * 2, radius * 2);//draws first circle(at 0)
	    else
	    {
	    g.drawOval(xMid - radius, yMid - radius, radius * 2, radius * 2);//draws next circles
	    drawCircles(g, xMid-radius, yMid, radius /2,level-1);
	    drawCircles(g, xMid+radius, yMid, radius /2, level-1);
	    drawCircles(g, yMid-radius, xMid, radius /2,level-1);
	    drawCircles(g, yMid+radius, xMid, radius /2,level-1);
	    }
	}
//start drawing the fractal
 public void paintComponent( Graphics g )
 {
 super.paintComponent( g );
// draw fractal pattern
g.setColor( color );
if(Fractal.Triangle==true)
{
	drawTriangles(g,400,100, -400, level);
}
if(Fractal.Tree==true)
{
	drawTree(g,400,800, -90, level);
}
//drawFractal( level, 100, 90, 290, 200, g );
if(Fractal.Circle==true)
{
	drawCircles(g,400,400,200,level);
}
 } // end method paintComponent
public void setColor( Color c )//sets the color
{
	color = c;
} 

 // sets the level taking from method in Fractal
 public void setLevel( int currentLevel )
 {
 level = currentLevel;
 }
 public int getLevel()//getter for level
 {
return level;
 } 
 }

