package com.myapp.sevice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputService {

    private final Scanner scanner;

    public InputService() {
        this.scanner = new Scanner(System.in);
    }
    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public Date getDate(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return dateFormat.parse(input);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Ожидается формат: dd.MM.yyyy");
            return null;
        }
    }

//    // ИЗБЫТОЧНО НО МОЖЕТ ПРИГОДИТСЯ ПРИ ПОЯВЛЕНИИ ДРУГИХ ПОЛЕЙ
//    // Универсальный метод для ввода значений
//    public Object inputValue(String prompt, Class<?> type) {
//        System.out.print(prompt);
//        String input = scanner.nextLine();  // Ввод всех данных как строки
//
//        // Преобразуем строку в нужный тип данных
//        if (type == String.class) {
//            return input;  // Если это строка, просто возвращаем введённую строку
//        } else if (type == int.class) {
//            return Integer.parseInt(input);
//        } else if (type == Date.class) {
//            // Пример формата даты "dd-MM-yyyy"
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//            try {
//                return dateFormat.parse(input);  // Преобразование строки в объект Date
//            } catch (ParseException e) {
//                System.out.println("Неверный формат даты. Ожидается формат: dd-MM-yyyy");
//                return null;  // Вернём null в случае ошибки парсинга
//            }
//        } else {
//            return null;  // Для других типов можно добавить обработку
//        }
//    }


}
