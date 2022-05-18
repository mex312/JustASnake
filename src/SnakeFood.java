import java.awt.*;

public class SnakeFood extends Entity{

    Entity snakeHead;

    public SnakeFood(Entity snakeHead, int x, int y, int size){
        super("Snake Food");

        this.snakeHead = snakeHead;
        setBounds(x, y, size * 5, size * 5);
    }

    @Override
    public void Update() {
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.fillOval(0, 0, bounds().width, bounds().height);
    }
}
