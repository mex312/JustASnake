import javax.swing.*;

public abstract class Entity extends JComponent {
    String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Entity(String name){
        this.name = name;
        MainClass.addEntityToUpdate(this);
    }

    public void move(int deltaX, int deltaY){
        setBounds(getX() + deltaX, getY() + deltaY, getWidth(), getHeight());
    }

    public abstract void Update();
}
