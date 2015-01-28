public class MyEntry<K extends Comparable<K>,V> implements Entry<K,V> {
  protected K key;
  protected V value;
  public MyEntry(K k, V v) { key = k; value = v; }
  public K getKey() { return key; }
  public V getValue() { return value; }
  public String toString() { return "(" + key + "," + value + ")"; }
}
