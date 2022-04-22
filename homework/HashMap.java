import java.util.LinkedList;
import java.util.ListIterator;

public class HashMap<K, V> extends HashTable<K, V> {

    public HashMap(int size) { super(size); }

    public HashMap() { super(); }

    public void set(K key, V value) {
        Pair<K , V> pair = new Pair<>(key, value);
        ListIterator<Pair<K, V>> i = table[getIndex(key)].listIterator();

        while (i.hasNext()) {
            if (i.next().equals(pair)) {
                i.set(pair);
                return;
            }
        }
        table[getIndex(key)].add(pair);
    }
    
    public V get(K key) {
        for (Pair<K,V> pair : table[getIndex(key)]) {
            if (pair.getKey().equals(key))
                return pair.getValue();
        }
        return null;
    }

    public void del(K key) {
        ListIterator<Pair<K, V>> i2 = table[getIndex(key)].listIterator();

        while (i2.hasNext()) {
            if (i2.next().getKey().equals(key)){
                i2.remove();
                return;
            }
        }
    }
    public boolean contains(K key) {
        for (Pair<K,V> pair : table[getIndex(key)]) {
            if (pair.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String string = "";
        for (int i = 0; i < size; i++) {
            for (Pair<K,V> pair : table[i]) {
                string += pair.toString() + "\n";
            }
        }
        return string;
    }

}
