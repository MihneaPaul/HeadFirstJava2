package GUI;
import  javax.swing.*;
import java.awt.*;
/**
 * Created by Mihnea on 07.05.2017.
 */
public class SimpleAnimation {
    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanelAnim circle = new MyDrawPanelAnim();
        frame.getContentPane().add(circle);
        frame.setSize(400,400);
        frame.setVisible(true);

        for(int i=0;i<130;i++) {
            x++;
            y++;
            circle.repaint();
            try {
                Thread.sleep(50);
            }catch (Exception ex) {}
        }
    }
    class MyDrawPanelAnim extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
//            Graphics2D g2d = (Graphics2D) g;
//            int red = (int)(Math.random()*256);
//            int green = (int)(Math.random()*256);
//            int blue = (int)(Math.random()*256);
//            Color startColor = new Color(red,green,blue);
//            red = (int)(Math.random()*256);
//            green = (int)(Math.random()*256);
//            blue = (int)(Math.random()*256);
//            Color endColor = new Color(red,green,blue);
//            GradientPaint gradientPaint = new GradientPaint(70,70,startColor,150,150,endColor);
//            g2d.setPaint(gradientPaint);
//            g2d.fillOval(x,y,40,40);

            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            g.setColor(Color.green);
            g.fillOval(x,y,40,40);
        }
    }
}
