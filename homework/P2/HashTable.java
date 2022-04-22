package homework;

import java.util.ArrayList;

class HashTable<K,V> {
    protected int size;
    protected ArrayList<Pair<K,V>> table[];

    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList[size];

        for (int i = 0; i < size; i++) {
            table[i] = new ArrayList<Pair<K,V>>();
        }
    }
    public HashTable() {
        this(10);
    }
    protected int getIndex(K key) {
        int hash_key = Math.abs(key.hashCode() % size);
        return hash_key;
    }
}
