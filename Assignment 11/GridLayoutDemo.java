import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridLayoutDemo extends JFrame implements ActionListener {

    JButton b[] = new JButton[6];

    String temp = "";

    GridLayoutDemo() {

        setLayout(new GridLayout(2,3));

        for(int i=0;i<6;i++) {

            b[i] = new JButton("" + (i+1));

            add(b[i]);

            b[i].addActionListener(this);
        }

        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        JButton clicked =
                (JButton)e.getSource();

        if(temp.equals("")) {

            temp = clicked.getText();

            clicked.setText("");
        }

        else {

            clicked.setText(temp);

            temp = "";
        }
    }

    public static void main(String[] args) {

        new GridLayoutDemo();
    }
}