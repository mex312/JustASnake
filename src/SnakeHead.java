import com.sun.tools.javac.Main;

import java.awt.event.KeyEvent;

public class SnakeHead extends SnakePart{

    private int deltaX = 20;
    private int deltaY = 0;

    public SnakeHead() {
        super(null);
    }

    public void addPart(){
        SnakePart part = this;

        while(part.child != null){
            part = part.child;
        }

        new SnakePart(part, part.getX(), part.getY());
    }

    public void Update(){
        super.Update();

        if(Input.getKeyDown(KeyEvent.VK_W) && deltaY != 20) { deltaY = -20; deltaX = 0; }
        else if(Input.getKeyDown(KeyEvent.VK_S) && deltaY != -20) { deltaY = 20; deltaX = 0; }
        else if(Input.getKeyDown(KeyEvent.VK_D) && deltaX != -20) { deltaX = 20; deltaY = 0; }
        else if(Input.getKeyDown(KeyEvent.VK_A) && deltaX != 20) { deltaX = -20; deltaY = 0; }

        if(deltaY != 0 || deltaX != 0) {
            if(child != null) child.moveToParent();

            move(deltaX, deltaY);
        }

        if (this.getBounds().getCenterX() >= 800 || this.getBounds().getCenterX() <= 0 || this.getBounds().getCenterY() >= 600 || this.getBounds().getCenterY() <= 0) this.die();
    }
}
