package homework.MyMap;

import java.util.Collection;
import java.util.Set;
import java.util.Map;
public interface MyMapInterface<K,V> {
    /**
     *  ��ѯ����
     *
     */
    //size()�洢��ֵ����Ŀ
    int size();
    //�жϼ����Ƿ�Ϊ��,�����Ϊ��,����true
    boolean isEmpty();
    //�жϼ����Ƿ����ָ���ļ�,����booleanֵ
    boolean containsKey(Object key);
    //�жϼ����Ƿ����ָ���ļ�,����booleanֵ
    boolean containsValue();
    //���ݼ���ȡֵ
    V get(Object key);
    /**
     * �޸Ĳ���
     */
    //�򼯺�������,�洢key��value,������value
    V put(K key,V value);
    //����key�Ƴ�Map�����еļ�ֵ��,����value
    V remove(Object key);
    /**
     * �������
     */
    //��ָ����Map���ϸ��ƴ洢�������󼯺�
    void putAll(Map<? extends K,? extends V> m);
    //�Ƴ�map�����е�����mapping
    void clear();
    /**
     * ��ʾ
     */
    //����Map���ϵ�Set key����
    Set<K> keySet();
    //����Map���ϵ�Collection valueֵ����
    Collection<V> values();
    //����Map���ϵļ�ֵ�Լ���
    Set<MyMapInterface.Entry<K,V>> entrySet();
    /**
     *     ����һ�����Entry,���ڶԼ�ֵ�ԵĲ���
     */
        interface Entry<K,V>{
            //���ص�ǰentry��ֵ�Ե�Key
            K getKey();
            //���ص�ǰentry��ֵ�Ե�value
            V getValue();
            //�Ƚ�ָ��Object�����뱾�����Ƿ����,����booleanֵ
            boolean equals(Object o);
            //����entry��hashcode,int����
            int hashCode();
        }
    /**
     * �ȽϺ�hashcode
     */
    boolean equals(Object o);
    int hashCode();
}
