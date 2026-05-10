import javax.swing.*;
import java.awt.event.*;

public class ComboBoxDemo extends JFrame implements ItemListener {

    JComboBox box;
    JLabel label;

    ComboBoxDemo() {

        String images[] = {"Lion", "Tiger", "Elephant"};

        box = new JComboBox(images);

        label = new JLabel();

        box.setBounds(100, 50, 150, 30);

        label.setBounds(100, 120, 200, 30);

        add(box);
        add(label);

        box.addItemListener(this);

        setLayout(null);
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void itemStateChanged(ItemEvent e) {

        label.setText("Selected: " +
                box.getSelectedItem());
    }

    public static void main(String[] args) {

        new ComboBoxDemo();
    }
}