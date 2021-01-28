package com.company;

import java.lang.reflect.Method;

public class Main {

    enum Day {

        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    static class Book {

        String name;
        Type bookType;
        String author;

        Book(String name, String author, Type type) {

            bookType = type;
            this.name = name;
            this.author = author;
        }
    }

    enum Type {
        SCIENCE,
        BELLETRE,
        PHANTASY,
        SCIENCE_FICTION
    }

    enum Type2 {
        SCIENCE,
        BELLETRE,
        PHANTASY,
        SCIENCE_FICTION
    }

    enum Color {
        RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");
        private String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    enum Operation {
        SUM {
            public int action(int x, int y) {
                return x + y;
            }
        },
        SUBTRACT {
            public int action(int x, int y) {
                return x - y;
            }
        },
        MULTIPLY {
            public int action(int x, int y) {
                return x * y;
            }
        };

        public abstract int action(int x, int y);
    }

    static class ButtonClickHandler implements EventHandler {

        public void execute() {

            System.out.println("Кнопка нажата!");
        }
    }

    interface EventHandler {

        void execute();
    }

    static class Button {

        EventHandler handler;

        Button(EventHandler action) {

            this.handler = action;
        }

        public void click() {

            handler.execute();
        }
    }

    public static void main(String[] args) {
        System.out.println("\n+ ------------- Задание 1 ------------- +\n");

        Button button = new Button(new ButtonClickHandler());
        button.click();
        button.click();
        button.click();

        Button tvButton = new Button(new EventHandler(){

            private boolean on = false;
            public void execute(){

                if(on) {
                    System.out.println("Телевизор выключен..");
                    on=false;
                }
                else {
                    System.out.println("Телевизор включен!");
                    on=true;
                }
            }
        });

        Button printButton = new Button(new EventHandler(){

            public void execute(){

                System.out.println("Начата печать на принтере...");
            }
        });

        tvButton.click();
        printButton.click();
        tvButton.click();

        System.out.println("\n+ ------------- Задание 3 ------------- +\n");

        Car c1 = new Car("Ford", "Mustang", "VI", 3000000, 2014);
        c1.println();
        Car c2 = new Car("Chevrolet", "Corvette", "C4", 1300000, 1992);
        c2.println();
        Car c3 = new Car("Mitsubishi", "Eclipse", "|||", 1550000, 2001);
        c3.println();

        System.out.println("\n+ ------------- Задание 4 ------------- +\n");

        Day current = Day.MONDAY;
        System.out.println(current);    // MONDAY

        Book b1 = new Book("War and Peace", "L. Tolstoy", Type.BELLETRE);
        System.out.printf("Book '%s' has a type %s", b1.name, b1.bookType);

        switch (b1.bookType) {
            case BELLETRE:
                System.out.println("Belletre");
                break;
            case SCIENCE:
                System.out.println("Science");
                break;
            case SCIENCE_FICTION:
                System.out.println("Science fiction");
                break;
            case PHANTASY:
                System.out.println("Phantasy");
                break;
        }

        Type2[] types = Type2.values();
        for (Type2 s : types) {
            System.out.println(s);
        }

        System.out.println(Color.RED.getCode());        // #FF0000
        System.out.println(Color.GREEN.getCode());      // #00FF00

        Operation op = Operation.SUM;
        System.out.println(op.action(10, 4));   // 14
        op = Operation.MULTIPLY;
        System.out.println(op.action(6, 4));    // 24

    }
}