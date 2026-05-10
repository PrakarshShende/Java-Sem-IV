import javax.swing.*;
import java.awt.event.*;

public class StationarySystem extends JFrame implements ActionListener {

    JCheckBox notebook, pen, pencil;
    JButton order;

    StationarySystem() {

        setTitle("Stationary Purchase System");

        notebook = new JCheckBox("Notebook @ 50");
        pen = new JCheckBox("Pen @ 30");
        pencil = new JCheckBox("Pencil @ 10");

        order = new JButton("Order");

        notebook.setBounds(80, 50, 150, 30);
        pen.setBounds(80, 100, 150, 30);
        pencil.setBounds(80, 150, 150, 30);

        order.setBounds(100, 220, 100, 30);

        add(notebook);
        add(pen);
        add(pencil);
        add(order);

        order.addActionListener(this);

        setLayout(null);
        setSize(350, 350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        int total = 0;
        String msg = "";

        if (notebook.isSelected()) {

            String q = JOptionPane.showInputDialog(
                    "Enter Quantity for Notebook");

            int qty = Integer.parseInt(q);

            total = total + (qty * 50);

            msg = msg + "Notebook Quantity: "
                    + qty + "  Total: "
                    + (qty * 50) + "\n";
        }

        if (pen.isSelected()) {

            String q = JOptionPane.showInputDialog(
                    "Enter Quantity for Pen");

            int qty = Integer.parseInt(q);

            total = total + (qty * 30);

            msg = msg + "Pen Quantity: "
                    + qty + "  Total: "
                    + (qty * 30) + "\n";
        }

        if (pencil.isSelected()) {

            String q = JOptionPane.showInputDialog(
                    "Enter Quantity for Pencil");

            int qty = Integer.parseInt(q);

            total = total + (qty * 10);

            msg = msg + "Pencil Quantity: "
                    + qty + "  Total: "
                    + (qty * 10) + "\n";
        }

        msg = msg + "\nTotal: " + total;

        JOptionPane.showMessageDialog(
                this,
                msg
        );

        JOptionPane.showMessageDialog(
                this,
                "Successfully Ordered."
        );
    }

    public static void main(String[] args) {

        new StationarySystem();
    }
}