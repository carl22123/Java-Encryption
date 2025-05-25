import javax.swing.*;
import java.awt.*;

import static java.lang.reflect.Array.set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame
{
    private Frame frame;

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

        add(panel1());

        setLocationRelativeTo(null); // I put it here so Frame will be in the Center
        setVisible(true);
    }

    private JPanel panel1()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setBounds(10, 10, 400,440);

        return panel;
    }
}