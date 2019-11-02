package UI;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(String title) {
        super(title);
        setLayout(null);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(new start(this));
        setVisible(true);
    }
}
