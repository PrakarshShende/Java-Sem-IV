import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BackgroundColor extends JFrame implements ActionListener {

    JButton red, green, blue;

    BackgroundColor() {

        red = new JButton("Red");
        green = new JButton("Green");
        blue = new JButton("Blue");

        red.setBounds(50, 50, 100, 30);
        green.setBounds(50, 100, 100, 30);
        blue.setBounds(50, 150, 100, 30);

        add(red);
        add(green);
        add(blue);

        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);

        setLayout(null);
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == red)
            getContentPane().setBackground(Color.RED);

        if (e.getSource() == green)
            getContentPane().setBackground(Color.GREEN);

        if (e.getSource() == blue)
            getContentPane().setBackground(Color.BLUE);
    }

    public static void main(String[] args) {

        new BackgroundColor();
    }
}