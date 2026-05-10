import javax.swing.*;
import java.awt.event.*;

public class SimpleTimer extends JFrame implements ActionListener {

    JLabel label;
    JButton start, stop;

    Timer timer;

    int count = 0;

    SimpleTimer() {

        label = new JLabel("0");

        start = new JButton("Start");
        stop = new JButton("Stop");

        label.setBounds(150, 50, 100, 30);

        start.setBounds(80, 120, 100, 30);
        stop.setBounds(200, 120, 100, 30);

        add(label);
        add(start);
        add(stop);

        start.addActionListener(this);
        stop.addActionListener(this);

        timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                count++;

                label.setText("" + count);
            }
        });

        setLayout(null);
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start)
            timer.start();

        if (e.getSource() == stop)
            timer.stop();
    }

    public static void main(String[] args) {

        new SimpleTimer();
    }
}