import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PingPongGame extends JPanel implements ActionListener {
    private Ball ball;
    private LeftPaddle leftPaddle;
    private RightPaddle rightPaddle;
    private int scoreLeft = 0;
    private int scoreRight = 0;
    private Timer timer;
    private boolean gameStarted = false;
    private int ballX = 0;
    private int ballY = 0;
    private int ballSpeedX = 1;
    private int ballSpeedY = 1;
    private int paddleLeftY = 150;
    private int paddleRightY = 150;


    String player1Name;
    String player2Name;

    public PingPongGame(String player1Name, String player2Name) {

        this.player1Name = player1Name;
        this.player2Name = player2Name;

        setBackground(Color.BLACK);
        timer = new Timer(5, this);
        timer.start();
        ball = new Ball(0, 0, 20, 20, 2, 2);
        leftPaddle = new LeftPaddle(0, 150, 10, 80);
        rightPaddle = new RightPaddle(590, 150, 10, 80);


        

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    gameStarted = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    paddleRightY -= 20;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    paddleRightY += 20;
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    paddleLeftY -= 20;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    paddleLeftY += 20;
                }
            }
        });
        
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (gameStarted) {
            g.setColor(Color.WHITE);
            g.fillRect(0, paddleLeftY, 10, 80);
            g.fillRect(590, paddleRightY, 10, 80);
            g.fillOval(ballX, ballY, 20, 20);


            g.drawString(player1Name, 10, 20); // display player1Name on top left corner
        g.drawString(player2Name, 430, 20); // display player2Name on top right corner
            g.setColor(Color.RED);
            g.drawString("Score: " + scoreLeft + " - " + scoreRight, 250, 20);
        } else {
            g.setColor(Color.RED);
            g.drawString("Press SPACE to start the game.", 200, 200);
        }
        
    }

    public void actionPerformed(ActionEvent e) {
        if (gameStarted) {
            ballX += ballSpeedX;
            ballY += ballSpeedY;

            if (ballY <= 0 || ballY >= 480) {
                ballSpeedY = -ballSpeedY;
            }

            if (ballX <= 0) {
                ballSpeedX = -ballSpeedX;
                scoreRight++;
            }

            if (ballX >= 570) {
                ballSpeedX = -ballSpeedX;
                scoreLeft++;
            }

            if (ballX <= 10 && ballY >= paddleLeftY && ballY <= paddleLeftY + 80) {
                ballSpeedX = -ballSpeedX;
            }

            if (ballX >= 560 && ballY >= paddleRightY && ballY <= paddleRightY + 80) {
                ballSpeedX = -ballSpeedX;
            }

            repaint();
        }
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ping Pong Game");

        String player1Name = JOptionPane.showInputDialog(frame, "Enter Player 1 Name:");
        String player2Name = JOptionPane.showInputDialog(frame, "Enter Player 2 Name:");
        PingPongGame game = new PingPongGame(player1Name, player2Name);
        frame.add(game);
        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}