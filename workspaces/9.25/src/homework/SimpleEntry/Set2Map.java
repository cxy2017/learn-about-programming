package homework.SimpleEntry;

import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.HashSet;
/**
 * ��set��չ��Map
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
    //������е�key-value�Եķ���
    public void clear(){
        super.clear();
    }
    //�ж��Ƿ����ĳ��key,����booleanֵ
    public boolean containsKey(K key){
        return super.contains(new SimpleEntry<K, V>(key,null));
    }
    //�ж��Ƿ����ĳ��value,����booleanֵ
    public boolean containsValue(Object value){
        for(SimpleEntry<K,V> se:this){
            if(se.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }
    //���ݶ�Ӧ��Keyֵȡ����Ӧ��value
    public V get(Object Key){
        for (SimpleEntry<K, V> se:this){
            if (se.getKey().equals(Key)){
                return se.getValue();
            }
        }
        return null;
    }
    //��ָ����key-value�Է��뼯�Ϻ���,����value
    public V put(K key,V value){
        add(new SimpleEntry<K, V>(key,value));
        return value;
    }
    //����һ��Map��key-value�������Map��
    public void putAll(Map<?extends K,?extends V> m){
        for (K key :
                m.keySet()) {
            add(new SimpleEntry<K, V>(key,m.get(key)));
        }
    }
    //����ָ��keyɾ��ָ��key-value��,���ص�ǰvalueֵ
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
    //��ȡmap���к��ж���key-value��
    public int size(){
        return super.size();
    }
}