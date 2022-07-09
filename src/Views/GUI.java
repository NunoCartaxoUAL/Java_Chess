package Views;

import Models.Board;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI{
    private JFrame jf;
    private Board board;
    private CardLayout lyt;

    public GUI() {
        this.board = new Board();
        this.jf = new JFrame();
        this.jf.setLayout(new GridLayout(1,1));
        this.jf.setPreferredSize(new Dimension(440,440));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel bP = new JPanel();
        JPanel containerPanel = new JPanel();
        bP.setLayout(new GridLayout(8,8));
        addSpacesToButtonPanel(bP);
        bP.setPreferredSize(new Dimension(400, 400));
        containerPanel.add(bP);

        jf.getContentPane().add(containerPanel);
        jf.pack();
        jf.setVisible(true);

    }
    public void addSpacesToButtonPanel(JPanel bP){
        var b = this.addSpace();
        for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    bP.add(addSpace());
                }

        }
    }
    public JButton addSpace(){
        JButton b = new JButton();
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setBackground(Color.BLACK);
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(b.getX()+"_"+b.getY()+"_"+b.getWidth()+"_"+b.getHeight());
            }
        };
        b.addActionListener(aL);
        return b;
    }

    /*

     */


    public void addPiece(){
        //TODO to implement + get the images of each chess piece and add to a new folder called resources
    }
    public void removePiece(){
        //TODO to implement + get the images of each chess piece and add to a new folder called resources
    }

}
