/*
Реализовать класс для работы с одномерными динамическими массивами произвольных данных(произвольного типа).
Так же класс должен содержать следующие приватные поля:
1. Сам массив произвольных данных.
2. Длину массива.

Класс будет иметь следующие конструкторы:
1. Конструктор без параметров – конструктор по умолчанию, проводящий базовую инициализацию массива
2. Конструктор с параметром T[] – конструктор, который проводит инициализацию и заполняет массив данными,
пришедшими из параметра.
*/

package Homework4;

import java.util.Arrays;

public class DiffTypesArray<T extends Comparable<T>> {

    // ПОЛЯ КЛАССА DiffTypesArray
    private T[] array;
    private int length;

    // КОНСТРУКТОРЫ КЛАССА DiffTypesArray

    public int getLength() {
        return length;
    }

    public DiffTypesArray() {
        this.length = 0;
        this.array = (T[]) new Comparable[0];
    }

    public DiffTypesArray(T[] values) {
        this.array = Arrays.copyOf(values, values.length);
        this.length = values.length;
    }


    // ПЕРЕОПРЕДЕЛИМ ПАРАМЕТРЫ ВЫВОДА ДАННЫХ НА ПЕЧАТЬ
    public String toString() {
        return String.format("\n Длина массива: %d\n Массив: %s", length, Arrays.toString(array));
    }

    // МЕТОДЫ ОБРАБОТКИ ДАННЫХ В МАССИВЕ

    public void add(T value) {                                                    // Добавление элементов в массив.
        if (this.length == this.array.length) {
            array = Arrays.copyOf(array, length + 1);
        }
        array[length] = value;
        length++;
    }

    public void removeByIndex(int index) {                                        // Удаление элементов по индекску.
        for (int i = index; i < length - 1; i++) {
            array[i] = array[i + 1];
        }
        length--;
        array = Arrays.copyOf(array, length);
    }

    public void removeByValue(T value) {                                          // Удаление элементов по значению.
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i].equals(value)) count++;
            else array[i - count] = array[i];
        }
        length -= count;
        array = Arrays.copyOf(array, length);
    }

    public T getMin() {                                                           // Поиск минимального числа в массиве.
        T min = array[0];
        for (int i = 0; i < length; i++) {
            if (this.array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    public T getMax() {                                                          // Поиск максимального числа в массиве.
        T max = array[0];
        for (int i = 0; i < length; i++) {
            if (this.array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    public T getSum() {                                                          // Расчет суммы элементов массива.
        if (array[0] instanceof Integer sum) {
            for (int i = 1; i < length; i++) sum = sum + ((Integer) array[i]);
            return (T) sum;
        }
        return null;
    }

    public T getProduct() {                                                     // Расчет произведения элементов массива.
        if (array[0] instanceof Integer product) {
            for (int i = 1; i < length; i++) {
                product = product * ((Integer) array[i]);
            }
            return (T) product;
        }
        return null;
    }

    public int getIndex(T value) {                                               // Печать элемента по индекску.
        for (int i = 0; i < this.length; i++) {
            if (this.array[i].equals(value)) return i;
        }
        return -1;
    }

    public boolean contains(T value) {                                           // Проверка наличия элемента в массиве.
        for (int i = 0; i < this.length; i++) {
            if (this.array[i].equals(value)) return true;
        }
        return false;
    }

    public void bubbleSort() {                                                   // Сортировка пузырьком.
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.length - i - 1; j++) {
                if (this.array[j].compareTo(this.array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public void insertionSort() {                                                // Сортировка простыми вставками.
        for (int i = 1; i < length; i++) {
            T temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(temp) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }


    public void selectionSort() {                                                // Сортировка простым выбором
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public T getValue(int index) {                                              // Вывод элемента массива по индексу.
        return this.array[index];
    }

    public void changeValue(int index, T value) {
        if (0 > index || index >= length) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы массива");
        } else {
            this.array[index] = value;
        }
    }


}

