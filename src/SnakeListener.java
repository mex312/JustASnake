public class SnakeListener extends Entity{
    private int ticksToEnd = 5;

    public SnakeListener() {
        super("Snake Listener");
    }

    @Override
    public void Start() {

    }

    @Override
    public void Update() {
        if(MainClass.getObjectOfType(SnakeHead.class) == null && MainClass.getObjectOfType(SnakePart.class) != null) MainClass.setUpdateDelay(100 / 6); else MainClass.setUpdateDelay(200);

        if(MainClass.getObjectOfType(SnakePart.class) == null) ticksToEnd--; else ticksToEnd = 5;

        if(ticksToEnd <= 0) MainClass.exit();
    }
}
