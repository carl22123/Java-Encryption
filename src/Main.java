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

    private JTextField insertKey, text;
    private JButton generateKey, encrypt, decrypt;
    private JLabel Key, WText;

    private JTextField[] TComponents = {insertKey, text}; // arraylist for components like textfield
    private JButton[] BComponent = {generateKey, encrypt, decrypt};
    private JLabel[] LComponent = {Key, WText};

    public static void main(String[] args)
    {
       new Main();
    }

    Main()
    {
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100,100,700,500);

        // text field
        TComponents[0] =  textfield(insertKey, 10,70,250,50,2);
        TComponents[1] =  textfield(text, 10,130,250,50,3);

        add(panel(new JPanel(), Color.green, 10,10, 400, 440, (T[]) TComponents, null, 1));
        add(panel(new JPanel(), Color.BLUE, 420,10, 250, 440, null, null, 2));

        setLocationRelativeTo(null); // I put it here so Frame will be in the Center
        setVisible(true);
    }

    //10, 10, 400,440
    // T for generics
    // this will how every panel is made
    private JPanel panel(JPanel panel, Color color, int x, int y, int width, int height, T[] Component, T[] SComponent, int specificPanel)
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);

        // add to what panel
        if(specificPanel == 1 ) // this is for panel 1
        {
            panel.add((java.awt.Component) Component[0]);
            panel.add((java.awt.Component) Component[1]);
        }

        return panel;
    }

    // this is how textfield is made
    private JTextField textfield(JTextField field, int x, int y, int width, int height, int specificTextField)
    {
        field = new JTextField();
        field.setBounds(x, y, width, height);

        return field;
    }

    private JButton Button(JButton button, int x, int y, int width, int height, int specificTextField)
    {
        button = new JButton();

        return button;
    }
}