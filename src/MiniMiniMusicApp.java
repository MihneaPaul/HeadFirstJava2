/**
 * Created by Mihnea on 16.04.2017.
 */
import javax.sound.midi.*;
public class MiniMiniMusicApp {
    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer(); // get a Sequencer and open it to use it
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack(); // ask the sequence for a track. Track lives in the Sequence, MIDI data lives in the Track

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192,1,102,100);
            MidiEvent changeInstrument = new MidiEvent(first,1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,67,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,67,100);
            MidiEvent noteOff = new MidiEvent(b,15);
            track.add(noteOff);

            player.setSequence(seq); // give the Sequence to the Sequencer (put CD in the CD player)
            player.start();
//            System.out.println("We got a sequencer");
        } catch (Exception ex) {
            ex.printStackTrace();
//            System.out.println("Bummer");
        }
    }

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
//        if(args.length<1) {
//            System.out.println("Don't forget args.");
//        } else {

            mini.play();
        }
    }

