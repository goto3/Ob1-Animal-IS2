package dominio.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomID {

    private static RandomID Instance;

    private final List<String> ids;
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static RandomID getInstance() {
        if (Instance == null) {
            Instance = new RandomID();
        }
        return Instance;
    }

    private RandomID() {
        ids = new ArrayList<>();
    }

    public String getNewID() {
        String id = newID();
        if (!ids.contains(id)){
            ids.add(id);
            return id;
        }else{
            return getNewID();
        }        
    }

    private String newID() {
        String id = "";
        for (int i = 0; i < 6; i++) {
            Random r = new Random();
            int charPos = r.nextInt(chars.length());
            String c = String.valueOf(chars.charAt(charPos));
            id = id.concat(c);
        }
        return id;
    }
}
