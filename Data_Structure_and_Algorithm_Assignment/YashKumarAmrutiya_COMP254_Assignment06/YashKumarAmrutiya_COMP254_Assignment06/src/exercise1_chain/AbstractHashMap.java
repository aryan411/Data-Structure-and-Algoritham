package exercise1_chain;
import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
  protected int n = 0;                 // number of entries in the dictionary
  protected int capacity;              // length of the table
  private int prime;                   // prime factor
  private long scale, shift;           // the shift and scaling factors
  private double alpha;

  public AbstractHashMap(int cap, int p, double loadFactor) {
    prime = p;
    capacity = cap;
    alpha = loadFactor;
    Random rand = new Random();
    scale = rand.nextInt(prime-1) + 1;
    shift = rand.nextInt(prime);
    createTable();
  }
  
  public void setScale(long scale) {
	  this.scale = scale;
  }
  

  public void setShift(long shift) {
	  this.shift = shift;
  }
    public AbstractHashMap(int cap) { this(cap, 109345121, 0.5); }  // default prime
  public AbstractHashMap() { this(17); }                     // default capacity

  @Override
  public int size() { return n; }

  @Override
  public V get(K key) { return bucketGet(hashValue(key), key); }

  @Override
  public V remove(K key) { return bucketRemove(hashValue(key), key); }

  @Override
  public V put(K key, V value) {
    V answer = bucketPut(hashValue(key), key, value);
    if ((double)n/capacity > alpha)              // keep load factor <= 0.5
      resize(2 * capacity - 1);        // (or find a nearby prime)
    return answer;
  }

  // private utilities
  private int hashValue(K key) {
    return (int) ((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
  }

  private void resize(int newCap) {
    ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
    for (Entry<K,V> e : entrySet())
      buffer.add(e);
    capacity = newCap;
    createTable();                     // based on updated capacity
    n = 0;                             // will be recomputed while reinserting entries
    for (Entry<K,V> e : buffer)
      put(e.getKey(), e.getValue());
  }

  // protected abstract methods to be implemented by subclasses
  /** Creates an empty table having length equal to current capacity. */
  protected abstract void createTable();

  protected abstract V bucketGet(int h, K k);

  protected abstract V bucketPut(int h, K k, V v);

  protected abstract V bucketRemove(int h, K k);
}
