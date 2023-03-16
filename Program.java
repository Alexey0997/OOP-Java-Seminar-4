package Homework4;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class Program {

    public static void main(String[] args) {

        // ФОРМИРОВАНИЕ МАССИВА ПРОИЗВЛОЬНОГО ТИПА

        DiffTypesArray<Integer> diffTypesArray = new DiffTypesArray<Integer>();
        diffTypesArray.add(1);
        diffTypesArray.add(5);
        diffTypesArray.add(7);
        diffTypesArray.add(4);

        // ВЫЗОВ МЕТОДА ВЗАИМОДЕЙСТВИЯ С ПОЛЬЗОВАТЕЛЕМ
        Menu.getData(diffTypesArray);
    }
}





