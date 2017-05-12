package GUI;

/**
 * Created by Mihnea on 07.05.2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {
    JFrame frame;

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Change colors");
        button.addActionListener(this);

        GradientCircle drawPanel = new GradientCircle();
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }

    public static void main(String[] args) {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }
}
class TwoButtons {
    JFrame frame;
    JLabel label;

    public void go() {
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());
        label = new JLabel("I'm a label");
        GradientCircle drawPanel = new GradientCircle();

        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.getContentPane().add(BorderLayout.WEST,label);

        frame.setSize(400,300);
        frame.setVisible(true);
    }
    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Ouch!");
        }
    }
    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }
}
