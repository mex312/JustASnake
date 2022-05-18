import java.awt.event.KeyEvent;

public class SnakeHead extends SnakePart{

    int deltaX = 0;
    int deltaY = 0;

    public SnakeHead() {
        super(null);
    }

    public void addPart(){
        SnakePart part = this;

        while(part.child != null){
            part = part.child;
        }

        new SnakePart(part);
    }

    public void Update(){
        deltaY = 0;
        deltaX = 0;

        if(Input.getKey(KeyEvent.VK_W)) deltaY -= 5;
        if(Input.getKey(KeyEvent.VK_S)) deltaY += 5;
        if(Input.getKey(KeyEvent.VK_D)) deltaX += 5;
        if(Input.getKey(KeyEvent.VK_A)) deltaX -= 5;

        if(deltaY != 0 || deltaX != 0) {
            if(child != null) child.moveToParent();

            move(deltaX, deltaY);
        }


    }
}
