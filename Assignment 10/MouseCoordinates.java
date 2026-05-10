import javax.swing.*;
import java.awt.event.*;

public class MouseCoordinates extends JFrame implements MouseMotionListener {

    JLabel label;

    MouseCoordinates() {

        label = new JLabel();

        label.setBounds(100, 100, 200, 30);

        add(label);

        addMouseMotionListener(this);

        setLayout(null);
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mouseMoved(MouseEvent e) {

        label.setText("X = " + e.getX() +
                "  Y = " + e.getY());
    }

    public void mouseDragged(MouseEvent e) {
    }

    public static void main(String[] args) {

        new MouseCoordinates();
    }
}