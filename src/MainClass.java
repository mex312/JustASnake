import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;

public class MainClass{

    static final JFrame mainScene = new JFrame("TITLE");
    static final ArrayList<Entity> entitiesToUpdate = new ArrayList<>();

    public static void addEntityToUpdate(Entity e){
        entitiesToUpdate.add(e);
        mainScene.add(e);
    }

    public MainClass(){
        SnakeHead snakeHead = new SnakeHead();
        snakeHead.addPart();
        snakeHead.addPart();
        snakeHead.addPart();
        snakeHead.addPart();
        snakeHead.addPart();
        snakeHead.addPart();
        snakeHead.addPart();
        snakeHead.addPart();
        snakeHead.addPart();

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

        Timer mainCycle = new Timer(15, e -> {
            mainUpdate();
        });

        mainCycle.start();
    }

    private void mainUpdate(){
        Input.updateKeys();

        for(Entity e : entitiesToUpdate){
            e.Update();
        }

        MainClass.mainScene.repaint();
    }



    public static void main(String[] args){
        new MainClass();
    }
}
