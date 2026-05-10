import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm extends JFrame
implements ActionListener {

    JLabel l1, l2;

    JTextField t1;

    JPasswordField t2;

    JButton b1;

    LoginForm() {

        l1 = new JLabel("Username");
        l2 = new JLabel("Password");

        t1 = new JTextField();

        t2 = new JPasswordField();

        b1 = new JButton("Register");

        l1.setBounds(50,50,100,30);
        l2.setBounds(50,100,100,30);

        t1.setBounds(150,50,150,30);
        t2.setBounds(150,100,150,30);

        b1.setBounds(120,170,100,30);

        add(l1);
        add(l2);

        add(t1);
        add(t2);

        add(b1);

        b1.addActionListener(this);

        setLayout(null);

        setSize(400,300);

        setVisible(true);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        String username = t1.getText();

        String password =
                new String(t2.getPassword());

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/college",
                            "root",
                            "root"
                    );

            PreparedStatement ps =
                    con.prepareStatement(
                            "insert into login values(?,?)"
                    );

            ps.setString(1, username);
            ps.setString(2, password);

            int i = ps.executeUpdate();

            if (i > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Registration Successful"
                );
            }

            con.close();

        } catch (Exception ex) {

            System.out.println(ex);
        }
    }

    public static void main(String[] args) {

        new LoginForm();
    }
}