import javax.swing.*;

public abstract class Entity extends JComponent {
    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Entity(String name){
        this.name = name;
        MainClass.addEntityToUpdate(this);
    }

    public void move(int deltaX, int deltaY){
        setBounds(getX() + deltaX, getY() + deltaY, getWidth(), getHeight());
    }

    public abstract void Start();

    public abstract void Update();
}
