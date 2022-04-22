package homework;

import java.util.Objects;

class Pair<K,V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() { return key; }
    V getValue() { return value; }

    void setKey(K key) { this.key = key; }
    void setValue(V key) { this.value = value; }

    public int hashCode() { return key.hashCode(); }

    public boolean equals (Object a) {

        if (this == a)
            return true;
        if (!(a instanceof Pair))
            return false;

        Pair<?, ?> pair = (Pair<?, ?>) a;
        return Objects.equals(key, pair.key);
    }

    public String toString() {
        return "{" + key + " = " + value + "}";
    }
}
