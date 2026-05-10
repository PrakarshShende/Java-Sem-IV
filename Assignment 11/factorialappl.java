import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class factorialappl extends Applet
implements ActionListener {

    Label l1, l2;

    TextField t1, t2;

    Button b;

    public void init() {

        l1 = new Label("Enter Number");
        l2 = new Label("Factorial");

        t1 = new TextField(10);
        t2 = new TextField(10);

        b = new Button("Find");

        add(l1);
        add(t1);

        add(b);

        add(l2);
        add(t2);

        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        int n =
            Integer.parseInt(t1.getText());

        int fact = 1;

        for(int i=1;i<=n;i++) {

            fact = fact * i;
        }

        t2.setText("" + fact);
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Factorial Calculator");
        factorialappl applet = new factorialappl();
        applet.init();
        frame.add(applet);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}