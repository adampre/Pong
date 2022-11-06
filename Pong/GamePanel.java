import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener
{
    private Entity paddle;
    private Entity ball;

    private Entity game;

    private Random random;

    public GamePanel()
    {
        this.setBackground(Color.BLACK);

        random = new Random();

        game = new Entity(10, 10, 800, 700);

        paddle = new Entity(30, 30, 20, 150, 0, 10);
        ball = new Entity(60, random.nextInt(game.height - 20) + game.y + 10, 30, 30, 5, 5);
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        g.setColor(Color.WHITE);

        g.drawRect(game.x, game.y, game.width, game.height);

        g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);

        g.fillOval(ball.x, ball.y, ball.width, ball.height);
    }

    public void update()
    {
        if(ball.y <= game.y || ball.y + ball.height >= game.y + game.height - ball.speed.y)
        {
            ball.speed.y *= -1;
        }

        if(ball.x + ball.width >= game.x + game.width - ball.speed.x)
        {
            ball.speed.x *= -1;
        }

        if((ball.x >= paddle.x && ball.x <= paddle.x + paddle.width) && (ball.y >= paddle.y && ball.y <= paddle.y + paddle.height))
        {
            ball.speed.x *= -1;
        }

        ball.x += ball.speed.x;
        ball.y += ball.speed.y;

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(paddle.y + paddle.height < game.y + game.height)
            {
                paddle.y += paddle.speed.y;
            } 
        }
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            if(paddle.y > game.y) 
            {
                paddle.y -= paddle.speed.y;
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
