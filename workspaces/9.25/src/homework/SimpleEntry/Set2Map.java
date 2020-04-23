package homework.SimpleEntry;

import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.HashSet;
/**
 * 将set扩展成Map
 * @param <K>
 * @param <V>
 */
class SimpleEntry<K,V> implements Map.Entry<K,V>,java.io.Serializable {
    private K key;
    private V value;

    public SimpleEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public SimpleEntry(Map.Entry<? extends K ,? extends V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldvalue=this.value;
        this.value=value;
        return oldvalue;
    }
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o.getClass()==this.getClass()){
            SimpleEntry se=(SimpleEntry)o;
            return this.getKey().equals(se.getKey());
        }
        return false;
    }
    public int hashCode(){
        return key==null?0:key.hashCode();
    }
    public String toString(){
        return key+"="+value;
    }
}
public class Set2Map<K,V> extends HashSet<SimpleEntry<K,V>>{
    //清空所有的key-value对的方法
    public void clear(){
        super.clear();
    }
    //判断是否包含某个key,返回boolean值
    public boolean containsKey(K key){
        return super.contains(new SimpleEntry<K, V>(key,null));
    }
    //判断是否包含某个value,返回boolean值
    public boolean containsValue(Object value){
        for(SimpleEntry<K,V> se:this){
            if(se.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }
    //根据对应的Key值取出对应的value
    public V get(Object Key){
        for (SimpleEntry<K, V> se:this){
            if (se.getKey().equals(Key)){
                return se.getValue();
            }
        }
        return null;
    }
    //将指定的key-value对放入集合和中,返回value
    public V put(K key,V value){
        add(new SimpleEntry<K, V>(key,value));
        return value;
    }
    //将另一个Map的key-value放入这个Map中
    public void putAll(Map<?extends K,?extends V> m){
        for (K key :
                m.keySet()) {
            add(new SimpleEntry<K, V>(key,m.get(key)));
        }
    }
    //根据指定key删除指定key-value对,返回当前value值
    public V removeEntry(Object key){
        for (Iterator<SimpleEntry<K,V>> it= this.iterator(); it.hasNext(); ) {
            SimpleEntry<K,V> se=it.next();
            if (se.getKey().equals(key)){
                V value=se.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }
    //获取map包中含有多少key-value对
    public int size(){
        return super.size();
    }
}