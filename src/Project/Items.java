package Project;

import java.util.HashMap;
import java.util.Map;

public class Items {
    Map<String,Integer> items = new HashMap<>();

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items.put("Ifnity Edge", 200);
        this.items.put("Goredrinker", 300);
        this.items.put("Static",150);
    }
}
