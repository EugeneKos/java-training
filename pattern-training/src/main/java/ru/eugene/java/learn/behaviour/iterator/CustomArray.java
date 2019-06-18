package ru.eugene.java.learn.behaviour.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class CustomArray<T> implements Iterable<T> {
    private Object[] array = new Object[]{};
    private int index = 0;

    public void add(T element){
        if(index >= array.length){
            array = Arrays.copyOf(array, array.length + 1);
        }
        array[index] = element;
        index++;
    }

    public T get(int index){
        if(index >= array.length){
            throw new ArrayIndexOutOfBoundsException("array length: " + array.length);
        }
        return (T) array[index];
    }

    public T remove(int index){
        T item = get(index);
        array[index] = null;
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array = Arrays.copyOf(array, array.length - 1);
        this.index--;
        return item;
    }

    public int size(){
        return array.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public T next() {
                T item = (T) array[index];
                index++;
                return item;
            }

            @Override
            public void remove() {
                CustomArray.this.remove(--index);
            }
        };
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
