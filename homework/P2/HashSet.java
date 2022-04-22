package homework;

import java.util.ListIterator;

class HashSet<K> extends HashTable<K, K> {

    public HashSet(int size) {
        super(size);
    }

    public HashSet() {
        super();
    }

    public K get(K key) {
        for (Pair<K, K> pair : table[getIndex(key)]) {
            if (pair.getKey().equals(key))
                return pair.getValue();
        }
        return null;
    }

    public void set(K key) {
        Pair <K, K> pair = new Pair<>(key, key);
        ListIterator<Pair<K, K>> i = table[getIndex(key)].listIterator();

        while (i.hasNext()) {
            if (i.next().equals(pair)) {
                i.set(pair);
                return;
            }
        }
        table[getIndex(key)].add(pair);
    }

    public void del(K key) {
        ListIterator<Pair<K, K>> i = table[getIndex(key)].listIterator();

        while (i.hasNext()) {
            if (i.next().getKey().equals(key)) {
                i.remove();
                return;
            }
        }
    }

    public boolean contains(K key) {
        for (Pair<K, K> pair : table[getIndex(key)]) {
            if (pair.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public HashSet<K> intersection (HashSet<K> setB) {
        HashSet<K> newSet = new HashSet<>(size);

        for (int i = 0; i < size; i++) {
            for (Pair<K, K> pair : table[i]) {
                if (setB.contains(pair.getKey()))
                    newSet.set(pair.getKey());
            }
        }
        return newSet;
    }

    public HashSet<K> difference(HashSet<K> setB) {
        HashSet<K> newSet = new HashSet<>(size);

        for (int i = 0; i < size; i++) {
            for (Pair<K,K> pair : table[i]) {
                if (!setB.contains(pair.getKey()))
                    newSet.set(pair.getKey());
            }
        }
        return newSet;
    }

    public HashSet<K> union(HashSet<K> setB) {
        HashSet<K> newSet = new HashSet<>(size*2);

        for (int i = 0; i < size; i++) {
            for (Pair<K,K> pair : table[i]) {
                newSet.set(pair.getKey());
            }
        }

        for (int i = 0; i < setB.size; i++) {
            for (Pair<K,K> pair : setB.table[i]) {
                newSet.set(pair.getKey());
            }
        }
        return newSet;
    }

    public String toString() {
        StringBuilder string = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            for (Pair<K,K> pair : table[i]) {
                string.append(pair.getKey().toString() + ", ");
            }
        }
        if (string.length() > 3)
            string.delete(string.length() - 2, string.length());
        return string.append("]").toString();
    }
}
