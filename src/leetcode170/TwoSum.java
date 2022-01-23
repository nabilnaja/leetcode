package leetcode170;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private final Map<Integer, Integer> storage;

    public TwoSum() {
        storage = new HashMap<>();
    }

    public void add(int number) {
        this.storage.put(number, storage.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for(Integer key : this.storage.keySet()) {
            int complement = value - key;
            if(complement != key) {
                if(this.storage.containsKey(complement))
                    return true;
            } else if(this.storage.get(key) > 1)
                return true;
        }
        return false;
    }
}
