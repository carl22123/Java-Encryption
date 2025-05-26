import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.reflect.Array.set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main <T>  extends JFrame
{

    // this is a challenged for my self if i can make it shorter

    private Frame frame;

    private JTextField insertKey;
    private JTextArea text;
    private JButton generateKey, encrypt, decrypt;
    private JLabel Key, WText;

    // array for there prespective components
    private T[] TComponents = (T[]) new Object[2];
    private JButton[] BComponent = new JButton[3];
    private JLabel[] LComponent = new JLabel[2];

    public static void main(String[] args)
    {
       new Main();
    }

    Main()
    {
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Encryption");

        setBounds(100,100,700,500);

        // text fields and text areas
        TComponents[0] = (T) textfield(insertKey, 10,10,250,50);
        TComponents[1] = (T) textArea(text, 10,105,250,270);

        // Buttons
        BComponent[0] = Button(generateKey, "Generate Key", 10,64,250,35,1);
        BComponent[1] = Button(encrypt, "Encrypt",10, 380,120,50,2);
        BComponent[2] = Button(decrypt, "Decrypt", 140, 380,120,50,3);

        // panels
        add(panel(new JPanel(), Color.gray, 10,10, 400, 440, (T[]) TComponents, (T[]) BComponent, 1));
        add(panel(new JPanel(), Color.BLUE, 420,10, 250, 440, null, null, 2));

        setLocationRelativeTo(null); // I put it here so Frame will be in the Center
        setVisible(true);
    }

    // T for generics
    // this will how every panel is made
    private JPanel panel(JPanel panel, Color color, int x, int y, int width, int height, T[] Component, T[] SecondComponent, int specificPanel)
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);

        // add to what panel
        if(specificPanel == 1 ) // this is for panel 1
        {
            // text field
            for(int i = 0; i < Component.length; i++)
                panel.add((java.awt.Component) Component[i]);

            // Button
            for(int j = 0; j < SecondComponent.length; j++)
                panel.add((java.awt.Component) SecondComponent[j]);
        }

        return panel;
    }

    // note: i cannot combine textfield and textArea because different object/class
    private JTextField textfield(JTextField field, int x, int y, int width, int height)
    {
        field = new JTextField();
        field.setBounds(x, y, width, height);

        return field;
    }

    private JTextArea textArea(JTextArea field, int x, int y, int width, int height)
    {
        field = new JTextArea();
        field.setBounds(x, y, width, height);

        return field;
    }

    private JButton Button(JButton button, String buttonText, int x, int y, int width, int height, int specificTextField)
    {
        button = new JButton();
        button.setBounds(x,y,width,height);
        button.setText(buttonText);

        return button;
    }
}