package android.arch.core.internal;

import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo
public class FastSafeIterableMap<K, V>
  extends SafeIterableMap<K, V>
{
  private HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap();
  
  public Map.Entry<K, V> ceil(K paramK)
  {
    if (contains(paramK)) {
      return ((SafeIterableMap.Entry)this.mHashMap.get(paramK)).mPrevious;
    }
    return null;
  }
  
  public boolean contains(K paramK)
  {
    return this.mHashMap.containsKey(paramK);
  }
  
  protected SafeIterableMap.Entry<K, V> get(K paramK)
  {
    return (SafeIterableMap.Entry)this.mHashMap.get(paramK);
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    SafeIterableMap.Entry localEntry = get(paramK);
    if (localEntry != null) {
      return (V)localEntry.mValue;
    }
    this.mHashMap.put(paramK, put(paramK, paramV));
    return null;
  }
  
  public V remove(K paramK)
  {
    Object localObject = super.remove(paramK);
    this.mHashMap.remove(paramK);
    return (V)localObject;
  }
}


/* Location:              C:\Users\marci\Downloads\dex2jar-2.0\dex2jar-2.0\sportagram-dex2jar.jar!\android\arch\core\internal\FastSafeIterableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */