import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutDemo extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;

    BorderLayoutDemo() {

        JLabel l1 = new JLabel("Enter Number");
        JLabel l2 = new JLabel("Result");

        t1 = new JTextField(10);
        t2 = new JTextField(10);

        b1 = new JButton("Binary");
        b2 = new JButton("Octal");
        b3 = new JButton("Hex");

        JPanel top = new JPanel();
        JPanel center = new JPanel();
        JPanel bottom = new JPanel();

        top.add(l1);
        top.add(t1);

        center.add(b1);
        center.add(b2);
        center.add(b3);

        bottom.add(l2);
        bottom.add(t2);

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        int n = Integer.parseInt(t1.getText());

        if(e.getSource()==b1)
            t2.setText(Integer.toBinaryString(n));

        if(e.getSource()==b2)
            t2.setText(Integer.toOctalString(n));

        if(e.getSource()==b3)
            t2.setText(Integer.toHexString(n));
    }

    public static void main(String[] args) {

        new BorderLayoutDemo();
    }
}