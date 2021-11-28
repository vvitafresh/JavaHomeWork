package com.pb.antonov.hw10;

public class NumBox<T extends Number> {

    private final T[] numbers;
    private int currentSize;

    /**
     * массив из объектов класса T, инициализировать массив в конструкторе
     * @param size
     */
    public NumBox(int size) {
        this.numbers = (T[]) new Number[size];
        currentSize = 0;
    }

    /**
     * Возвращающает число по индексу
     *
     * @param index индекс элемента
     * @return возвращающает число по индексу
     */
    public T get(int index) {
        return numbers[index];
    }

    /**
     * Добавить в конец массива, если массив полон - выбросить исключение
     * @param number добавляемый в массив элемент
     * @throws ArrayIndexOutOfBoundsException
     */
    public void add(T number) throws ArrayIndexOutOfBoundsException {
        if (currentSize < numbers.length) {
            this.numbers[currentSize] = number;
            currentSize++;
        } else {
            System.out.println("Массив полон - ошибка!");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Текущее количество элементов
     *
     * @return Возвращает текущее количество элементов
     */
    public int length() {
        return currentSize;
    }

    /**
     * Подсчет среднего арифметического среди элементов массива
     *
     * @return среднее арифметическое
     */
    public double average() {
        return sum() / currentSize;
    }

    /**
     * Сумма всех элементов массива
     *
     * @return Сумма всех элементов массива
     */
    public double sum() {
        double sum = 0;
        for (T number :
                numbers) {
            if (number != null) {
//                sum += Double.parseDouble(String.valueOf(number));
                sum += number.doubleValue();
            }
        }
        return sum;
    }

    /**
     * максимальный элемент массива
     *
     * @return максимальный элемент массива
     */
    public T max() {
        T max = numbers[0];
        for (T number :
                numbers) {
            if (number != null && number.doubleValue() > max.doubleValue()) {
                max = number;
            }
        }
        return max;
    }

}
