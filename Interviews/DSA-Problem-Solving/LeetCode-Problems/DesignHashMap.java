// 706. Design HashMap
// https://leetcode.com/problems/design-hashmap/


class MyHashMap {
    
    LinkedList<Entry>[] hashmap;
    public static int SIZE = 769;
        
    public MyHashMap() {
        hashmap = new LinkedList[SIZE];
    }
    
    public void put(int key, int value) {
        int bucket = key % SIZE;
        
        if(hashmap[bucket] == null) {
            hashmap[bucket] = new LinkedList<Entry>();
            hashmap[bucket].add(new Entry(key, value));
        }
        else {
            for(Entry entry : hashmap[bucket]) {
                if(entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            hashmap[bucket].add(new Entry(key, value));
        }
    }
    
    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = hashmap[bucket];
        if(entries == null) {
            return -1;
        }
        for(Entry entry : entries) {
            if(entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = key % SIZE;
        if(hashmap[bucket] == null) {
            return;
        }
        else {
            for(Entry entry : hashmap[bucket]) {
                if(entry.key == key) {
                    hashmap[bucket].remove(entry);
                    return;
                }
            }
            return;
        }
    }
    
}

class Entry {
    public int key;
    public int value;
    
    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

//     private int len = 1000001;
//     private int[] hashmap = new int[len];
    
//     public MyHashMap() {
//         for (int i = 0; i < len; i++) {
//             hashmap[i] = -1;
//         }
//     }
    
//     public void put(int key, int value) {
//         hashmap[key] = value;
//     }
    
//     public int get(int key) {
//         return hashmap[key];
//     }
    
//     public void remove(int key) {
//         hashmap[key] = -1;
//     }
    
//     private int size = 1000001;
//     private int[] hashmap;
    
//     public MyHashMap() {
//         hashmap = new int[size];
//     }
    
//     public void put(int key, int value) {
//         hashmap[key] = value + 1;
//     }
    
//     public int get(int key) {
//         return hashmap[key] - 1;
//     }
    
//     public void remove(int key) {
//         hashmap[key] = 0;
//     }
// }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
