import javax.swing.*;
import java.awt.*;

import static java.lang.reflect.Array.set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame
{
    private Frame frame;

    private JTextField generateKey, insertKey;
    private JTextField[] Components = {generateKey,insertKey};

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

        add(panel(new JPanel(), Color.green, 10,10, 400, 440, Components));
        add(panel(new JPanel(), Color.BLUE, 420,10, 250, 440, Components));

        setLocationRelativeTo(null); // I put it here so Frame will be in the Center
        setVisible(true);
    }

    //10, 10, 400,440
    // T for generics 
    private <T> JPanel panel(JPanel panel, Color color, int x, int y, int width, int height, T[] Component)
    {
        panel = new JPanel();
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);

        //panel.add((java.awt.Component) Component[0]);

        return panel;
    }

    private JTextField Text_Field(JTextField text, int x, int y)
    {
          text = new JTextField();
          text.setBounds(x, y, 100, 50);

          return text;
    }


}