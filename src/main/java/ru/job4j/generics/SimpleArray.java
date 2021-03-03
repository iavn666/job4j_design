package ru.job4j.generics;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private int count = 0;

    private T[] myArray = (T[]) new Object[10];

    public void add(T model) {
        myArray[count++] = model;
    }


    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        myArray[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(myArray, index + 1, myArray, index, myArray.length - 1 - index);
        count--;
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return myArray[index];

    }

    @Override
    public Iterator<T> iterator() {

        Iterator num = new Iterator<>() {

            private int current;

            @Override
            public boolean hasNext() {
                return current < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {

                    throw new NoSuchElementException();

                }
                return myArray[current++];
            }

        };
        return num;
    }









}