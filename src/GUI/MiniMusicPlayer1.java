package GUI;
import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
/**
 * Created by Mihnea on 07.05.2017.
 */
public class MiniMusicPlayer1 implements ControllerEventListener {
    static JFrame frame = new JFrame("My First Music Video");
    static MyDrawPanel01 m1;

    public static void main(String[] args) {
        MiniMusicPlayer1 mini = new MiniMusicPlayer1();
        mini.go();
    }

    public void setUpGui() {
        m1 = new MyDrawPanel01();
        frame.setContentPane(m1);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
        setUpGui();
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

//            int[] eventsIWant={127};
            sequencer.addControllerEventListener(m1, new int[]{127});
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            int r = 0;
            for (int i = 0; i < 180; i += 4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 100, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }
            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
        }
        return event;
    }

    @Override
    public void controlChange(ShortMessage event) {

    }

    class MyDrawPanel01 extends JPanel implements ControllerEventListener {
        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (msg) {
                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);
                g.setColor(new Color(r, gr, b));
                int height = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);
                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);
                g.fillRect(x, y, height, width);
                msg = false;
            }
        }
    }
}


