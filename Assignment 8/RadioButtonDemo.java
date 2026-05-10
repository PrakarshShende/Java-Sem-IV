import javax.swing.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {

    JLabel lblResult;
    JRadioButton rbMale, rbFemale;
    JButton btnSubmit;
    ButtonGroup bg;

    RadioButtonDemo() {

        setTitle("Gender Selection");

        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        btnSubmit = new JButton("Submit");

        lblResult = new JLabel();

        bg = new ButtonGroup();

        bg.add(rbMale);
        bg.add(rbFemale);

        setLayout(null);

        rbMale.setBounds(50, 30, 100, 30);
        rbFemale.setBounds(160, 30, 100, 30);

        btnSubmit.setBounds(90, 80, 100, 30);

        lblResult.setBounds(50, 130, 250, 30);

        add(rbMale);
        add(rbFemale);

        add(btnSubmit);

        add(lblResult);

        btnSubmit.addActionListener(this);

        setSize(350, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (rbMale.isSelected()) {
            lblResult.setText("Selected Gender: Male");
        }

        else if (rbFemale.isSelected()) {
            lblResult.setText("Selected Gender: Female");
        }

        else {
            lblResult.setText("Please select a gender");
        }
    }

    public static void main(String[] args) {
        new RadioButtonDemo();
    }
}