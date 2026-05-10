import javax.swing.*;
import java.awt.event.*;

public class TextAreaCount extends JFrame implements KeyListener {

    JTextArea area;

    JLabel chars, words;

    TextAreaCount() {

        area = new JTextArea();

        chars = new JLabel("Characters: 0");
        words = new JLabel("Words: 0");

        area.setBounds(50, 50, 250, 100);

        chars.setBounds(50, 170, 150, 30);
        words.setBounds(50, 210, 150, 30);

        add(area);
        add(chars);
        add(words);

        area.addKeyListener(this);

        setLayout(null);
        setSize(400, 350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void keyReleased(KeyEvent e) {

        String text = area.getText();

        chars.setText("Characters: " +
                text.length());

        String w[] = text.split("\\s+");

        words.setText("Words: " + w.length);
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {

        new TextAreaCount();
    }
}