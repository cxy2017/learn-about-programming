import java.io.Serializable;
import java.util.*;

/**
 * ????,????洢???????????
 */
public class MyArrayList<E> extends AbstractList<E> implements List<E>,RandomAccess,Cloneable,java.io.Serializable {
    /**
     * ?????????????????????????,???
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * ?????????????????
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};
    /**
     * ??????????????????,???????????????????
     */
    private static final Object[] DEFAULTECAPACITY_EMPTY_ELEMENTDATA = {};
    /**
     * ????????????л???????,????洢????????
     */
    transient Object[] elementData;
    /**
     * ?洢?????????????
     */
    private int size;

    /**
     * ?????????????????
     *
     * @param initialCapacity
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("???????????:" + initialCapacity);
        }
    }

    /**
     * ??ι?????,????????????????
     */
    public MyArrayList() {
        this.elementData = DEFAULTECAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * ????????????????????,?????????????????
     *
     * @param c
     */
    public MyArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            if (elementData.getClass() != Object[].class)
                //c,toArray()?????????Object[]????,??????????????????
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * ???????????????,?????????????????????С
     */
    public void trimToSize() {
        modCount++;
        if (size < elementData.length) {
            elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
        }
    }

    /**
     * ????????????????
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        int minExpand = (elementData != DEFAULTECAPACITY_EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;
        if (minCapacity > minExpand) {
            ensurExplicitCapacity(minCapacity);
        }
    }

    public void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTECAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensurExplicitCapacity(minCapacity);
    }

    private void ensurExplicitCapacity(int minCapacity) {
        modCount++;
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * ?????????????С
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * ???????????,?????????С??С
     *
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    /**
     * ??????????????
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * ??????????????????true
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * ????????а?????????o????true
     *
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * ????????а????????????????????
     * @param o
     * @return  ???????????????? 
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i]))
                    return i;

            }
        }
        return -1;
    }
     /**
      * ????????а??????????????????????
      * @param o
      * @return  ?????????????????
      */
     public int lastIndexOf(Object o){
       if(o==null){
           for (int i=size-1;i>=0;i--)
               if (elementData[i]==null)
                   return i;
       }else {
           for (int i=size-1;i>=0;i--)
               if (o.equals(elementData[i]))
                   return i;
       }
       return -1;
     }

    /**
     * ?????????????
     * @return
     */
      public Object clone(){
          MyArrayList<?> v=null;
          try {
             v = (MyArrayList<?>) super.clone();
             v.elementData=Arrays.copyOf(elementData,size);
             v.modCount=0;

         }catch (CloneNotSupportedException e){
          //??????,???????????

         }finally {

          return v;
          }
      }

    /**
     * ??????????????????Object[]????
     * @return
     */
      public Object[] toArray(){return Arrays.copyOf(elementData,size);}

    /**
     * ??????洢?????????????
     * ???????????????????
     * @param a
     * @param <T>
     * @return
     */
      public <T> T[] toArray(T[] a){
          if (a.length<size)
              return (T[])Arrays.copyOf(elementData,size,a.getClass());
          System.arraycopy(elementData,0,a,0,size);
          if (a.length>size)
              a[size]=null;
          return a;
      }

    /**
     * ??????????????????
     * ?????????????Χ
     * @param index
     * @return
     */
      E elementData(int index){return (E)elementData[index];}
      public E get(int index){
          rangeCheck(index);
          return elementData(index);
      }

    /**
     * ???????????????,???滻???????????
     * @param index
     * @param element
     * @return
     */
        public E set(int index,E element){
          rangeCheck(index);
          E oldValue=elementData(index);
          elementData[index]=element;
          return oldValue;
        }

    /**
     * ????β?????????,?????????true
     * @param e
     * @return
     */
    public boolean add(E e){
            ensureCapacityInternal(size+1);
            elementData[size++]=e;
            return true;
        }

}