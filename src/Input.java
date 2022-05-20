import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Input {
    private static final HashMap<Integer, Boolean> pressedKeys = new HashMap<>();
    private static final HashMap<Integer, Boolean> unpressedKeys = new HashMap<>();

    private static final HashMap<Integer, Boolean> keys = new HashMap<>();
    private static final HashMap<Integer, Boolean> keysOnce = new HashMap<>();

    public static void pressKey(int key) {
        pressedKeys.put(key, true);
    }

    public static void releaseKey(int key) {
        unpressedKeys.put(key, false);
    }

    public static void updatePressedKeys(){
        HashMap<Integer, Boolean> events = (HashMap<Integer, Boolean>) Input.pressedKeys.clone();
        Input.pressedKeys.clear();

        keysOnce.replaceAll((k, v) -> false);

        for(int key : events.keySet()){
            keys.put(key, events.get(key));
            keysOnce.putIfAbsent(key, true);
        }
    }

    public static void updateUnpressedKeys(){
        HashMap<Integer, Boolean> events = (HashMap<Integer, Boolean>) Input.unpressedKeys.clone();
        Input.unpressedKeys.clear();

        for(int key : events.keySet()){
            keys.put(key, events.get(key));
            keysOnce.remove(key);
        }
    }

    public static boolean getKey(int key) {
        return keys.getOrDefault(key, false);
    }

    public static boolean getKeyDown(int key) {
        return keysOnce.getOrDefault(key, false);
    }
}
