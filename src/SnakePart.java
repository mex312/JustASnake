import java.awt.*;
import java.awt.geom.AffineTransform;

public class SnakePart extends Entity{
    SnakePart parent = null;
    SnakePart child = null;

    boolean readyToDie = false;

    public SnakePart(SnakePart parent){
        super("Snake Part");
        setBounds(0, 0, 20, 20);
        this.parent = parent;
        if(parent != null) parent.setChild(this);
    }

    public SnakePart(SnakePart parent, int x, int y){
        super("Snake Part");
        setBounds(x, y, 20, 20);
        this.parent = parent;
        if(parent != null) parent.setChild(this);
    }

    public void die(){
        readyToDie = true;
    }

    public void setChild(SnakePart child){
        this.child = child;
    }

    public void moveToParent(){
        if(child != null) child.moveToParent();

        setBounds(parent.getBounds());
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.fillOval(0, 0, this.getBounds().width,this.getBounds().height);
    }

    @Override
    public void Start() {
    }

    @Override
    public void Update() {
        if(parent != null){
            SnakePart part = this;

            while(part.parent != null){
                part = part.parent;
            }

            //if(this.getX() == part.getX() && this.getY() == part.getY()) part.die(); // ALL THE SNAKE DIES
            if(this.getX() == part.getX() && this.getY() == part.getY()) this.die(); // SNAKE CUT ITSELF
        }

        if(readyToDie) {
            if(child != null) {
                child.parent = null;
                child = null;
            }
            if(parent != null){
                parent.child = null;
                parent = null;
            }
            MainClass.removeEntityFromUpdate(this);
        }

        if(!(this instanceof SnakeHead) && parent == null) die();
    }
}
