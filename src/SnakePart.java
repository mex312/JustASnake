import java.awt.*;

public class SnakePart extends Entity{
    SnakePart parent = null;
    SnakePart child = null;

    public SnakePart(SnakePart parent){
        super("Snake Part");
        setBounds(0, 0, 50, 50);
        this.parent = parent;
        if(parent != null) parent.setChild(this);
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
    public void Update() {

    }
}
