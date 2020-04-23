package homework.MyMap;

import java.util.Collection;
import java.util.Set;
import java.util.Map;
public interface MyMapInterface<K,V> {
    /**
     *  查询操作
     *
     */
    //size()存储键值对数目
    int size();
    //判断集合是否为空,若如果为空,返回true
    boolean isEmpty();
    //判断集合是否包含指定的键,返回boolean值
    boolean containsKey(Object key);
    //判断集合是否包含指定的键,返回boolean值
    boolean containsValue();
    //根据键获取值
    V get(Object key);
    /**
     * 修改操作
     */
    //向集合中输入,存储key和value,并返回value
    V put(K key,V value);
    //根据key移除Map集合中的键值对,返回value
    V remove(Object key);
    /**
     * 扩充操作
     */
    //将指定的Map集合复制存储到本对象集合
    void putAll(Map<? extends K,? extends V> m);
    //移除map集合中的所有mapping
    void clear();
    /**
     * 显示
     */
    //返回Map集合的Set key集合
    Set<K> keySet();
    //返回Map集合的Collection value值集合
    Collection<V> values();
    //返回Map集合的键值对集合
    Set<MyMapInterface.Entry<K,V>> entrySet();
    /**
     *     定义一个借口Entry,用于对键值对的操作
     */
        interface Entry<K,V>{
            //返回当前entry键值对的Key
            K getKey();
            //返回当前entry键值对的value
            V getValue();
            //比较指定Object对象与本对象是否相等,返回boolean值
            boolean equals(Object o);
            //返回entry的hashcode,int类型
            int hashCode();
        }
    /**
     * 比较和hashcode
     */
    boolean equals(Object o);
    int hashCode();
}
