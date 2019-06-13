package finalFractal;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
//this class sets up the frame and levels of recursion, color of lines
public class Fractal extends JFrame
{
	private static final int WIDTH = 800; // define width of GUI
	private static final int HEIGHT = 880; // define height of GUI
	private static final int MIN_LEVEL = 0, MAX_LEVEL = 5;
	private JButton changeColorJButton, increaseLevelJButton,decreaseLevelJButton;
	
	private JLabel levelJLabel;
	private FractalJPanel drawSpace;
	private JPanel mainJPanel, controlJPanel;
	// set up GUI
 public Fractal()
 {
	 super( "Double fractal " );
// set up control panel
	controlJPanel = new JPanel();
	controlJPanel.setLayout( new FlowLayout() );
 // set up color button
	changeColorJButton = new JButton( "Color" );
	controlJPanel.add( changeColorJButton );
	changeColorJButton.addActionListener(
		 new ActionListener()//action listener for button
		 {
 //change color setup
			 public void actionPerformed( ActionEvent event )
			 {
				 Color color = JColorChooser.showDialog(
						 Fractal.this, "Choose a color", Color.BLUE );
 // set default color, if no color is returned
	 						if ( color == null )
	 							color = Color.BLUE;
	 						drawSpace.setColor( color );
 				} // end method actionPerformed
 			} 
		 ); // end addActionListener

decreaseLevelJButton = new JButton( "Decrease Level" );//button to decrease the level
controlJPanel.add( decreaseLevelJButton );
decreaseLevelJButton.addActionListener(
new ActionListener() // anonymous inner class
{
 public void actionPerformed( ActionEvent event )
 {
	 int level = drawSpace.getLevel();//gets current level
	 --level; // decrease level by one
 if ( ( level >= MIN_LEVEL )  &&
 ( level <= MAX_LEVEL ) )
 {
	levelJLabel.setText( "Level: " + level );
	drawSpace.setLevel( level );
	repaint();

 } // end if
 } 
 }
 ); // end addActionListener

increaseLevelJButton = new JButton( "Increase Level" );//adds increase level button
controlJPanel.add( increaseLevelJButton );
increaseLevelJButton.addActionListener(
 new ActionListener() 
 {
 // process increaseLevelJButton event
 public void actionPerformed( ActionEvent event )

 {
	 int level = drawSpace.getLevel();

	 ++level; // increase level by one


 if ( ( level >= MIN_LEVEL )  &&
 ( level <= MAX_LEVEL ) )
{

	levelJLabel.setText( "Level: " + level );

	drawSpace.setLevel( level );

	repaint();
} 
 } 
 } 

 );

 levelJLabel = new JLabel( "Level: 0" );
 controlJPanel.add( levelJLabel );
drawSpace = new FractalJPanel( 0 );
 mainJPanel = new JPanel();
 mainJPanel.add( controlJPanel );
 mainJPanel.add( drawSpace );
 add( mainJPanel ); // add JPanel to JFrame
 setSize( WIDTH, HEIGHT ); // set size of JFrame
 setVisible( true ); // display JFrame
} 
public static void main( String[] args )
 {
 Fractal demo = new Fractal();//runs 
demo.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );//adds close
 } // end main
}

