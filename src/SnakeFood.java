import java.awt.*;
import java.util.Random;

public class SnakeFood extends Entity{

    private int size = 0;

    public SnakeFood(int x, int y, int size){
        super("Snake Food");

        setBounds(x + 10 - size * 5, y + 10 - size * 5, size * 10, size * 10);
        this.size = size;
    }

    public void regenerate(){
        Random rand = new Random();
        int newX = rand.nextInt(760); newX -= newX % 20;
        int newY = rand.nextInt(560); newY -= newY % 20;
        int newSize = rand.nextInt(1,10);
        setBounds(newX + 10 - newSize * 5, newY + 10 - newSize * 5, newSize * 10, newSize * 10);
        this.size = newSize;
        for(SnakePart part : MainClass.getObjectsOfType(SnakePart.class)){
            if(part.getBounds().getCenterX() == this.getBounds().getCenterX() && part.getBounds().getCenterY() == this.getBounds().getCenterY()){
                regenerate();
                break;
            }
        }
    }

    @Override
    public void Start() {
        //MainClass.mainScene.setComponentZOrder(this, 0);
    }

    @Override
    public void Update() {
        SnakeHead snakeHead = MainClass.getObjectOfType(SnakeHead.class);
        if(snakeHead == null) return;

        if(snakeHead.getBounds().getCenterX() == bounds().getCenterX() && snakeHead.getBounds().getCenterY() == bounds().getCenterY()){
            for(int i = 0; i < this.size; i++) snakeHead.addPart();
            regenerate();
        }
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.fillOval(0, 0, bounds().width, bounds().height);
    }
}
