import java.awt.*;

public class SnakeFood extends Entity{

    SnakeHead snakeHead;

    public SnakeFood(SnakeHead snakeHead, int x, int y, int size){
        super("Snake Food");

        this.snakeHead = snakeHead;
        setBounds(x, y, size * 5, size * 5);
    }

    @Override
    public void Update() {
        if(snakeHead.getBounds().x == bounds().x && snakeHead.getBounds().y == bounds().y){
            for(int i = 0; i < bounds().height / 10; i++) snakeHead.addPart();
            MainClass.removeEnityFromUpdate(this);
        }
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.fillOval(0, 0, bounds().width, bounds().height);
    }
}
