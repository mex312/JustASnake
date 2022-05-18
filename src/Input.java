import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Input {
    static final HashMap<Integer, Boolean> events = new HashMap<>();

    static final HashMap<Integer, Boolean> keys = new HashMap<>();
    static final HashMap<Integer, Boolean> keysOnce = new HashMap<>();

    public static void pressKey(int key) {
        events.put(key, true);
    }

    public static void releaseKey(int key) {
        events.put(key, false);
    }

    public static void updateKeys(){
        HashMap<Integer, Boolean> events = (HashMap<Integer, Boolean>) Input.events.clone();
        Input.events.clear();

        keysOnce.replaceAll((k, v) -> false);

        for(int key : events.keySet()){
            keys.put(key, events.get(key));
            if(events.get(key)){
                keysOnce.putIfAbsent(key, true);
            }else{
                keysOnce.remove(key);
            }
        }
    }

    public static boolean getKey(int key) {
        return keys.getOrDefault(key, false);
    }

    public static boolean getKeyDown(int key) {
        return keysOnce.getOrDefault(key, false);
    }
}
