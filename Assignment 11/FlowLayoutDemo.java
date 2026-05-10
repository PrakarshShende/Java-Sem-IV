import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo extends JFrame {

    FlowLayoutDemo() {

        setLayout(new FlowLayout(
                FlowLayout.LEFT,
                10,
                20));

        JCheckBox c1 = new JCheckBox("Java");
        JCheckBox c2 = new JCheckBox("Python");
        JCheckBox c3 = new JCheckBox("C++");

        add(c1);
        add(c2);
        add(c3);

        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new FlowLayoutDemo();
    }
}