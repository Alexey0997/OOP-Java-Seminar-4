package Homework4;

/*
Так же класс будет иметь следующие публичные методы:
1. Вставка в массив
2. Удаление элемента по индексу
3. Удаление всех элементов с заданным значением
4. Поиск минимума
5. Поиск максимума
6. Поиск суммы элементов массива
7. Поиск произведения элементов массива
8. Поиск индекса заданного элемента в массиве, если такого элемента в массиве нет, то возвращать -1.
9. Проверка наличия элемента в массиве. Возвращает true, если элемент в массиве есть, false – нет.
10. Пузырьковая сортировка
11. Сортировка простыми вставками
12. Сортировка простым выбором
13. Получение элемента массива по индексу
14. Задание значения элементу массива с заданным индексом
15. Печать массива на экран
16. Длинна массива

*Так же массив должен содержать следующие перегруженные операторы:
1. Оператор, получающий элемент по заданному индексу
2. Оператор, позволяющий установить значение элемента по заданному индексу
*Так же в случае, если могут произойти ошибки или некорретная работа в конструкторах или методах,
необходимо использовать механизм исключений для обработки возможных ошибок.
*/


import java.util.Scanner;


public class Menu {
    protected static void getData(DiffTypesArray<Integer> diffTypesArray) {
        // МЕНЮ ДЛЯ ВЗАИМОДЕЙСТВИЯ С ПОЛЬЗОВАТЕЛЕМ
        System.out.print("""
                Уважаемый пользователь,
                для работы с массивом выберете одно из следующих действий:
                Вставка в массив                                          - нажмите 1
                Удаление элемента по индексу                              - нажмите 2
                Удаление всех элементов с заданным значением              - нажмите 3
                Поиск минимума                                            - нажмите 4

                Поиск максимума                                           - нажмите 5
                Поиск суммы элементов массива                             - нажмите 6
                Поиск произведения элементов массива                      - нажмите 7
                Поиск индекса заданного элемента в массиве (инд./-1)      - нажмите 8

                Проверка наличия элемента в массиве (true/false)          - нажмите 9
                Пузырьковая сортировка                                    - нажмите 10
                Сортировка простыми вставками                             - нажмите 11
                Сортировка простым выбором                                - нажмите 12

                Получение элемента массива по индексу                     - нажмтие 13
                Задание значения элемента массива с заданным индексом     - нажмите 14
                Печать массива на экран                                   - нажмите 15
                Длинна массива                                            - нажмите 16
                Ваше решение: \s""");
        Scanner aScanner = new Scanner(System.in);
        int decisionNumber = aScanner.nextInt();
        if (decisionNumber > 0 & decisionNumber < 17) {
            switch (decisionNumber) {
                case 1 -> {
                    System.out.print("\nВведите целое число, которое нужно добавть в массив: ");
                    Scanner bScanner = new Scanner(System.in);
                    int number = bScanner.nextInt();
                    diffTypesArray.add(number);
                    System.out.printf("\n Число %s", number + " добавлено в массив.");
                    System.out.println(diffTypesArray);
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 2 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.printf("\nВведите индекс элемента от 1 до %s", diffTypesArray.getLength() + ", который нужно удалить: ");
                    Scanner bScanner = new Scanner(System.in);
                    int index = bScanner.nextInt() - 1;
                    if (0 <= index && index < diffTypesArray.getLength()) {
                        diffTypesArray.removeByIndex(index);
                        System.out.printf("\n Элемент с индексом %s", index + 1 + " удален из массива.");
                        System.out.println(diffTypesArray);
                        System.out.println();
                        getData(diffTypesArray);
                    } else {
                        System.out.println("Индекс выходит за пределы массива.");
                        getData(diffTypesArray);
                    }
                }

                case 3 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.print("\nВведите значение элементов, которые нужно удалить: ");
                    Scanner cScanner = new Scanner(System.in);
                    int number = cScanner.nextInt();
                    diffTypesArray.removeByValue(number);
                    System.out.printf("\nЭлементы с индексом %s", number + " отсутствуют в массиве.");
                    System.out.println(diffTypesArray);
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 4 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.printf("\nЗначение минимального элмента в массиве: %s", + diffTypesArray.getMin());
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }


                case 5 -> {
                    System.out.println(diffTypesArray);
                    System.out.printf("\nЗначение максимального элмента в массиве: %s", + diffTypesArray.getMax());
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 6 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.printf("\nСумма элементов массива: %s", + diffTypesArray.getSum());
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 7 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.printf("\nПроизведение элементов массива: %s", + diffTypesArray.getProduct());
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 8 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.print("\nВведите элемент массива, индекс которого нужно найти: ");
                    Scanner cScanner = new Scanner(System.in);
                    int element = cScanner.nextInt();

                    System.out.println(diffTypesArray);
                    if (diffTypesArray.getIndex(element) == -1){
                        System.out.println("Такого элемента нет в массиве.");
                    } else {
                        System.out.printf("\nЭлемент %s ",  "[" + element + "] имеет индекс: " + diffTypesArray.getIndex(element));
                    }
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 9 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.print("\nВведите элемент, наличие которого в массиве нужно проверить: ");
                    Scanner cScanner = new Scanner(System.in);
                    int element = cScanner.nextInt();
                    System.out.printf("\nРезультат проверки: %s ",  diffTypesArray.contains(element));
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 10 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.printf("\nИсходный массив:      %s ",  diffTypesArray);
                    diffTypesArray.bubbleSort();
                    System.out.printf("\nСортировка пузырьком: %s ",  diffTypesArray);
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 11 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.printf("\nИсходный массив:               %s ",  diffTypesArray);
                    diffTypesArray.insertionSort();
                    System.out.printf("\nСортировка простыми вставками: %s ",  diffTypesArray);
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 12 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.printf("\nИсходный массив:            %s ",  diffTypesArray);
                    diffTypesArray.selectionSort();
                    System.out.printf("\nСортировка простым выбором: %s ",  diffTypesArray);
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 13 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.printf("\nВведите индекс элемента от 1 до %s", diffTypesArray.getLength() + ", который нужно вывести на печать: ");
                    Scanner bScanner = new Scanner(System.in);
                    int index = bScanner.nextInt() - 1;
                    if (0 <= index && index < diffTypesArray.getLength()) {
                        System.out.printf("\n Индексу %s", index + 1 + " соответствует элемент: [" + diffTypesArray.getValue(index) + "]");
                        System.out.println(diffTypesArray);
                        System.out.println();
                        getData(diffTypesArray);
                    } else {
                        throw new IndexOutOfBoundsException("Данного индекса в массиве нет.");
                    }
                }

                case 14 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.printf("\nИсходный массив: %s", diffTypesArray);
                    System.out.printf("\nВведите индекс элемента от 1 до %s", diffTypesArray.getLength() + ", который необходимо изменить: ");
                    Scanner bScanner = new Scanner(System.in);
                    int index = bScanner.nextInt() - 1;
                    if (index >= 0 && index < diffTypesArray.getLength()) {
                        System.out.print("\nВведите новое значение элемента: ");
                        Scanner cScanner = new Scanner(System.in);
                        int newValue = cScanner.nextInt();
                        diffTypesArray.changeValue(index, newValue);
                        System.out.printf("\nИзмененный массив: %s", diffTypesArray);
                        System.out.println();
                        System.out.println();
                        getData(diffTypesArray);
                    } else {
                        throw new IndexOutOfBoundsException("Данного индекса в массиве нет.");
                    }
                }


                case 15 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.println(diffTypesArray);
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }

                case 16 -> {
                    if (diffTypesArray.getLength() == 0) throw new IllegalArgumentException("Массив пустой.");
                    System.out.printf("\nДлина массива: %s", diffTypesArray.getLength());
                    System.out.println();
                    System.out.println();
                    getData(diffTypesArray);
                }
            }
        }
    }
}
