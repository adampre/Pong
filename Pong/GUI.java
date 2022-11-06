import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener
{
    private JFrame frame;

    private GamePanel gamePanel;

    public GUI()
    {
        frame = new JFrame("Pong");
        frame.setLayout(new BorderLayout());
        frame.setBounds(0, 0, 1300, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel();

        frame.add(gamePanel, BorderLayout.CENTER);

        frame.addKeyListener(gamePanel);

        Timer timer = new Timer(1, this);
        timer.start();

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        gamePanel.update();
    }
}
