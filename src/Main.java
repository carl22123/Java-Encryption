import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.reflect.Array.set;

public class Main <T> extends JFrame
{
    private Function function = new Function(); // this is a class within the project

    // note: InsertKey, text, and output are structured in this way, allowing the text to be included
    private JTextField insertKey = new JTextField();
    private JTextArea text = new JTextArea() ;
    private JTextArea output = new JTextArea();

    private JButton generateKey, encrypt, decrypt;

    // array for there prespective components
    private T[] TComponents = (T[]) new Object[3]; // text fields and text areas
    private JButton[] BComponent = new JButton[3];

    public static void main(String[] args)
    {
       new Main();
    }

    Main()
    {
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Encryption");

        setBounds(100,100,700,500);

        // text fields and text areas
        TComponents[0] = (T) textfield(insertKey, 10,10,380,50);
        TComponents[1] = (T) textArea(text, 10,105,380,270);
        TComponents[2] = (T) textArea(output, 10, 10, 230, 420);

        // Buttons
        BComponent[0] = Button(generateKey, "Generate Key", 10,64,380,35,1);
        BComponent[1] = Button(encrypt, "Encrypt",10, 380,185,50,2);
        BComponent[2] = Button(decrypt, "Decrypt", 205, 380,185,50,3);

        // panels
        add(panel(new JPanel(), Color.gray, 10,10, 400, 440, (T[]) TComponents, (T[]) BComponent, null,1));
        add(panel(new JPanel(), Color.gray, 420,10, 250, 440, null, null, TComponents[2],2));

        setLocationRelativeTo(null); // I put it here so Frame will be in the Center
        setVisible(true);
    }

    // note: i cannot combine textfield and textArea because different object/class
    private JTextField textfield(JTextField field, int x, int y, int width, int height)
    {
        field.setBounds(x, y, width, height);
        return field;
    }

    private JTextArea textArea(JTextArea field, int x, int y, int width, int height)
    {
        field.setBounds(x, y, width, height);
        return field;
    }

    private JButton Button(JButton button, String buttonText, int x, int y, int width, int height, int specificButton)
    {
        button = new JButton();
        button.setBounds(x,y,width,height);
        button.setText(buttonText);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(specificButton == 1)
                {
                    function.newKey();
                    insertKey.setText(function.getKey());
                }
                if(specificButton == 2)
                {

                }
            }
        });

        return button;
    }

    // T for generics
    // this will how every panel is made
    private JPanel panel(JPanel panel, Color color, int x, int y, int width, int height, T[] Component, T[] SecondComponent, T specificComponent, int specificPanel)
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);

        // add to what panel
        if(specificPanel == 1) // this is for panel 1
        {
            // text field
            for(int i = 0; i < Component.length; i++)
                panel.add((java.awt.Component) Component[i]);

            // Button
            for(int j = 0; j < SecondComponent.length; j++)
                panel.add((java.awt.Component) SecondComponent[j]);
        }

        if(specificPanel == 2) // this is for panel 2
        {
            panel.add((java.awt.Component) specificComponent);
        }
        return panel;
    }
}