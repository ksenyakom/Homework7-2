package com.company;

import java.util.*;

public class Main {



    public static void main(String[] args) {
//        TreeMap<String, String> vocabulary = new TreeMap<String, String>(initHashMap());
        TreeMap<String, String> vocabulary =
                new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        vocabulary.putAll(initHashMap());
        boolean cycle = true;
        while (cycle) {
            showMenu();
            int userChoice = scanInt("");
            switch (userChoice) {
                case (1): {
                    showTreeMap(vocabulary);
                    break;
                }
                case (2): {
                    findWord(vocabulary);
                    break;
                }
                case (3): {
                    itemEdit(vocabulary);
                    break;
                }
                case (4): {
                    itemAdd(vocabulary);
                    break;
                }
                case (5): {
                    cycle = false;
                    break;
                }
                default:
                    System.out.println("Нет такого номера, сделайте свой выбор");
            }
        }


    }


    private static void showTreeMap(TreeMap map) {

        map.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    public static HashMap initHashMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("HashMap", " предназначен для создания структур данных в виде словаря, где каждый элемент имеет уникальный \"ключ\" и неуникальное \"значение\", не наследуется от Collection");
        map.put("ArrayList", " инкапсулирует в себе обычный массив, длина которого меняется при добавлениив него новых элементоа, доступ к элементам по индексу, элементы не уникальны");
        map.put("Queue", "это коллекция, предназначенная для хранения элементов в порядке, нужном для их обработки");
        map.put("HashSet", "набор уникальных элементов или хеш-множество, где каждый элемент имеет ключ - уникальный хеш-код");
        return map;
    }

    public static String scanString(String s) {
        System.out.print(s);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int scanInt(String s) {
        System.out.print(s);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void showMenu() {
        System.out.println("****");
        System.out.println("1. Показать словарь");
        System.out.println("2. Найти слово");
        System.out.println("3. Редактировать запись");
        System.out.println("4. Ввести новую запись");
        System.out.println("5. Выход");
        System.out.println("* Ваш выбор: ");
    }

    public static String findWord(Map map) {
        String userChoice1 = (scanString("Введите слово: "));
        if (map.containsKey(userChoice1.trim()))
            System.out.println(userChoice1 + " - " + map.get(userChoice1)); // как вывести ключ????
        else {
            System.out.println("В словаре нет такого слова");
            return "";
        }
        return userChoice1;
    }

    public static void itemEdit(TreeMap map) {
        String currentKey = findWord(map);
        if (currentKey != "") {
            System.out.println("Редактирование");
            String key = (scanString("Введите слово(Enter - пропустить): "));
            String value = (scanString("Введите определение(Enter - пропустить): "));
            if (key.isEmpty() && value.isEmpty()) {
                System.out.println("Вы не ввели изменений");
            } else {
                map.remove(currentKey);
                map.put(key, value);
            }
        }
    }

    public static void itemAdd(TreeMap map) {
        System.out.println("Введите новую запись:");
        String key = (scanString("Введите слово: "));
        if (map.containsKey(key)) {
            System.out.println("В словаре уже имеется данное слово:");
            System.out.println(key + " - " + map.get(key));
        } else {
            String value = (scanString("Введите определение: "));
            if (key.isEmpty()) {
                System.out.println("Вы не ввели слово, запись не сохранена.");
            } else {
                map.put(key, value);
            }
        }
    }
}
