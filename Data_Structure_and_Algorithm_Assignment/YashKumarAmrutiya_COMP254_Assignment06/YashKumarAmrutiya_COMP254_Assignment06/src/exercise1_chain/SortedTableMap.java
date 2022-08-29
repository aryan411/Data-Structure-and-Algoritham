
 package exercise1_chain;

import java.util.ArrayList;
import java.util.Comparator;


public class SortedTableMap<K,V> extends AbstractSortedMap<K,V> {

  private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

  
  public SortedTableMap() { super(); }

  
  public SortedTableMap(Comparator<K> comp) { super(comp); }

  // variant of binary search that returns relevant index
  
  private int findIndex(K key, int low, int high) {
    if (high < low) return high + 1;         // no entry qualifies
    int mid = (low + high) / 2;
    int comp = compare(key, table.get(mid));
    if (comp == 0)
      return mid;                            // found exact match
    else if (comp < 0)
      return findIndex(key, low, mid - 1);   // answer is left of mid (or possibly mid)
    else
      return findIndex(key, mid + 1, high);  // answer is right of mid
  }

  
  private int findIndex(K key) { return findIndex(key, 0, table.size() - 1); }

  
  @Override
  public int size() { return table.size(); }

  
  @Override
  public V get(K key) throws IllegalArgumentException {
    checkKey(key);
    int j = findIndex(key);
    if (j == size() || compare(key, table.get(j)) != 0) return null;   // no match
    return table.get(j).getValue();
  }

  
  @Override
  public V put(K key, V value) throws IllegalArgumentException {
    checkKey(key);
    int j = findIndex(key);
    if (j < size() && compare(key, table.get(j)) == 0)                 // match exists
      return table.get(j).setValue(value);
    table.add(j, new MapEntry<K,V>(key,value));                        // otherwise new
    return null;
  }

  
  @Override
  public V remove(K key) throws IllegalArgumentException {
    checkKey(key);
    int j = findIndex(key);
    if (j == size() || compare(key, table.get(j)) != 0) return null;  // no match
    return table.remove(j).getValue();
  }

  
  private Entry<K,V> safeEntry(int j) {
    if (j < 0 || j >= table.size()) return null;
    return table.get(j);
  }

  
  @Override
  public Entry<K,V> firstEntry() { return safeEntry(0); }

  
  @Override
  public Entry<K,V> lastEntry() { return safeEntry(table.size()-1); }

  
  @Override
  public Entry<K,V> ceilingEntry(K key) throws IllegalArgumentException {
    return safeEntry(findIndex(key));
  }

  
  @Override
  public Entry<K,V> floorEntry(K key) throws IllegalArgumentException {
    int j = findIndex(key);
    if (j == size() || ! key.equals(table.get(j).getKey()))
      j--;    // look one earlier (unless we had found a perfect match)
    return safeEntry(j);
  }

  
  @Override
  public Entry<K,V> lowerEntry(K key) throws IllegalArgumentException {
    return safeEntry(findIndex(key) - 1);   // go strictly before the ceiling entry
  }

  
  @Override
  public Entry<K,V> higherEntry(K key) throws IllegalArgumentException {
    int j = findIndex(key);
    if (j < size() && key.equals(table.get(j).getKey()))
      j++;    // go past exact match
    return safeEntry(j);
  }

  // support for snapshot iterators for entrySet() and subMap() follow
  private Iterable<Entry<K,V>> snapshot(int startIndex, K stop) {
    ArrayList<Entry<K,V>> buffer = new ArrayList<>();
    int j = startIndex;
    while (j < table.size() && (stop == null || compare(stop, table.get(j)) > 0))
      buffer.add(table.get(j++));
    return buffer;
  }

  
  @Override
  public Iterable<Entry<K,V>> entrySet() { return snapshot(0, null); }

  
  @Override
  public Iterable<Entry<K,V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
    return snapshot(findIndex(fromKey), toKey);
  }
}
