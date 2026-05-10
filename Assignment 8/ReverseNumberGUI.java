import javax.swing.*;
import java.awt.event.*;

public class ReverseNumberGUI extends JFrame implements ActionListener {

    JLabel lblNum, lblResult;
    JTextField txtNum, txtResult;
    JButton btnReverse;

    ReverseNumberGUI() {

        setTitle("Reverse Number");

        lblNum = new JLabel("Enter Number:");
        lblResult = new JLabel("Reverse:");

        txtNum = new JTextField();
        txtResult = new JTextField();

        btnReverse = new JButton("Reverse");

        setLayout(null);

        lblNum.setBounds(30, 30, 100, 30);
        txtNum.setBounds(140, 30, 150, 30);

        btnReverse.setBounds(100, 80, 120, 30);

        lblResult.setBounds(30, 130, 100, 30);
        txtResult.setBounds(140, 130, 150, 30);

        add(lblNum);
        add(txtNum);

        add(btnReverse);

        add(lblResult);
        add(txtResult);

        btnReverse.addActionListener(this);

        setSize(350, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        int num = Integer.parseInt(txtNum.getText());
        int rev = 0;

        while (num != 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }

        txtResult.setText(String.valueOf(rev));
    }

    public static void main(String[] args) {
        new ReverseNumberGUI();
    }
}