import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;

public class MainClass{

    private static final Timer mainCycle = new Timer(200, e -> mainUpdate());

    private static final JFrame mainScene = new JFrame("TITLE");
    private static final ArrayList<Entity> entitiesToUpdate = new ArrayList<>();
    private static final ArrayList<Entity> addedEntitiesToUpdate = new ArrayList<>();
    private static final ArrayList<Entity> removedEntitiesToUpdate = new ArrayList<>();

    public static void setUpdateDelay(int delay){
        mainCycle.setDelay(delay);
    }

    public static void addEntityToUpdate(Entity e){
        addedEntitiesToUpdate.add(e);
    }

    public static void removeEntityFromUpdate(Entity e){
        removedEntitiesToUpdate.add(e);
    }

    public static <T extends Entity> ArrayList<T> getObjectsOfType(Class<T> t){
        ArrayList<T> list = new ArrayList<>();

        for(Entity e : entitiesToUpdate){
            if(t.isInstance(e))
                list.add((T)e);
        }

        return list;
    }

    public static <T extends Entity> T getObjectOfType(Class<T> t){
        for(Entity e : entitiesToUpdate){
            if(t.isInstance(e)) return (T)e;
        }

        return null;
    }

    static void updateEntitiesList(){
        for(Entity e : addedEntitiesToUpdate){
            entitiesToUpdate.add(e);
            mainScene.add(e);
            e.Start();
        }
        for(Entity e : removedEntitiesToUpdate){
            entitiesToUpdate.remove(e);
            mainScene.remove(e);
        }
        addedEntitiesToUpdate.clear();
        removedEntitiesToUpdate.clear();
    }

    public static void exit() {
        System.exit(0);
    }

    public MainClass(){
        new SnakeHead();
        new SnakeFood(400, 300, 4).regenerate();
        new SnakeListener();

        mainScene.setUndecorated(true);
        mainScene.setSize(800, 600);
        mainScene.setLayout(null);
        mainScene.setVisible(true);
        mainScene.setBackground(Color.GRAY);
        mainScene.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainScene.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                Input.pressKey(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Input.releaseKey(e.getKeyCode());
            }
        });

        mainCycle.start();
    }

    private static void mainUpdate(){
        Input.updatePressedKeys();

        for(Entity e : entitiesToUpdate){
            e.Update();
        }

        updateEntitiesList();

        Input.updateUnpressedKeys();

        MainClass.mainScene.repaint();
    }



    public static void main(String[] args){
        new MainClass();
    }
}
