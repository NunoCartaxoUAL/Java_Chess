package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;


public class GUI extends JPanel{

    private JFrame jf;

    public void paint(Graphics gp) //paints stuff , i dont rly know how
    {

        gp.fillRect(50, 50, 600, 600); //makes a big black square

        for(int x=50; x<=600; x+=150) { //makes all the odd rows in chess board
            for(int y=50; y<=600; y+=150) {
                gp.clearRect(x, y, 75, 75); //clear rectangle
            }
        }

        for(int x=125; x<=600; x+=150) { //makes all the even rows in chess board
            for(int y=125; y<=600; y+=150) {
                gp.clearRect(x, y, 75, 75); //clear rectangle
            }
        }
    }


    public GUI() {
        this.jf=new JFrame(); // adds a panel or a window in JAVA SWING
        this.jf.setSize(700, 700);
        this.jf.setTitle("Draw Chess Board");
        this.jf.getContentPane().add(this); //adds GUI paint to the frame
        this.jf.setLocationRelativeTo(null); //makes all positions be absolute , top left is [0;0]  bottom left is [width,height]
        this.jf.setBackground(Color.BLACK);
        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //idk
        this.jf.setVisible(true); // must not forget this on all elements or else the default is false (invisible)
    }

    public void addPiece(){
        //TODO to implement + get the images of each chess piece and add to a new folder called resources
    }
    public void removePiece(){
        //TODO to implement + get the images of each chess piece and add to a new folder called resources
    }

}
