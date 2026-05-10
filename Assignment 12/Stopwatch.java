import javax.swing.*;
import java.awt.event.*;

public class Stopwatch extends JFrame
implements Runnable, ActionListener {

    JLabel label;

    JButton start, stop, reset;

    Thread t;

    int count = 0;

    boolean running = false;

    Stopwatch() {

        label = new JLabel("0");

        start = new JButton("Start");
        stop = new JButton("Stop");
        reset = new JButton("Reset");

        label.setBounds(150, 50, 100, 30);

        start.setBounds(50, 120, 80, 30);
        stop.setBounds(150, 120, 80, 30);
        reset.setBounds(250, 120, 80, 30);

        add(label);

        add(start);
        add(stop);
        add(reset);

        start.addActionListener(this);
        stop.addActionListener(this);
        reset.addActionListener(this);

        setLayout(null);

        setSize(400,250);

        setVisible(true);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }

    public void run() {

        while(running) {

            count++;

            label.setText("" + count);

            try {

                Thread.sleep(1000);

            } catch(Exception e) {
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == start) {

            running = true;

            t = new Thread(this);

            t.start();
        }

        if(e.getSource() == stop) {

            running = false;
        }

        if(e.getSource() == reset) {

            running = false;

            count = 0;

            label.setText("0");
        }
    }

    public static void main(String[] args) {

        new Stopwatch();
    }
}