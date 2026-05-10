import javax.swing.*;
import java.awt.event.*;

public class CounterGUI extends JFrame implements ActionListener {

    JLabel lblCounter;
    JTextField txtCounter;
    JButton btnUp, btnDown, btnReset;

    int count = 0;

    CounterGUI() {
        // Frame Title
        setTitle("Counter");

        // Components
        lblCounter = new JLabel("Counter");
        txtCounter = new JTextField("0", 10);

        btnUp = new JButton("Count Up");
        btnDown = new JButton("Count Down");
        btnReset = new JButton("Reset");

        // Layout
        setLayout(null);

        // Set Bounds
        lblCounter.setBounds(30, 30, 80, 30);
        txtCounter.setBounds(100, 30, 100, 30);

        btnUp.setBounds(220, 30, 100, 30);
        btnDown.setBounds(330, 30, 120, 30);
        btnReset.setBounds(460, 30, 80, 30);

        // Add Components
        add(lblCounter);
        add(txtCounter);

        add(btnUp);
        add(btnDown);
        add(btnReset);

        // Action Listeners
        btnUp.addActionListener(this);
        btnDown.addActionListener(this);
        btnReset.addActionListener(this);

        // Frame Settings
        setSize(600, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnUp) {
            count++;
            txtCounter.setText(String.valueOf(count));
        }

        if (e.getSource() == btnDown) {
            count--;
            txtCounter.setText(String.valueOf(count));
        }

        if (e.getSource() == btnReset) {
            count = 0;
            txtCounter.setText(String.valueOf(count));
        }
    }

    public static void main(String[] args) {
        new CounterGUI();
    }
}