import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;

public class MainClass{

    static final JFrame mainScene = new JFrame("TITLE");
    static final ArrayList<Entity> entitiesToUpdate = new ArrayList<>();
    static final ArrayList<Entity> addedEntitiesToUpdate = new ArrayList<>();
    static final ArrayList<Entity> removedEntitiesToUpdate = new ArrayList<>();

    public static void addEntityToUpdate(Entity e){
        addedEntitiesToUpdate.add(e);
    }

    public static void removeEnityFromUpdate(Entity e){
        removedEntitiesToUpdate.add(e);
    }

    static void updateEntitiesList(){
        for(Entity e : addedEntitiesToUpdate){
            entitiesToUpdate.add(e);
            mainScene.add(e);
        }
        for(Entity e : removedEntitiesToUpdate){
            entitiesToUpdate.remove(e);
            mainScene.remove(e);
        }
        addedEntitiesToUpdate.clear();
        removedEntitiesToUpdate.clear();
    }

    public MainClass(){
        SnakeHead snakeHead = new SnakeHead();

        addEntityToUpdate(new SnakeFood(snakeHead, 400, 300, 4));

        mainScene.add(snakeHead);
        mainScene.setSize(800, 600);
        mainScene.setLayout(null);
        mainScene.setVisible(true);
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

        Timer mainCycle = new Timer(200, e -> {
            mainUpdate();
        });

        mainCycle.start();
    }

    private void mainUpdate(){
        Input.updateKeys();

        for(Entity e : entitiesToUpdate){
            e.Update();
        }

        updateEntitiesList();

        MainClass.mainScene.repaint();
    }



    public static void main(String[] args){
        new MainClass();
    }
}
