package com.company;
import java.lang.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /*
        Person tom = new Person(); // создание объекта
        tom.displayInfo();
        // изменяем имя и возраст
        tom.name = "Tom";
        tom.age = 34;
        tom.displayInfo();
         */
        /*
        Person bob = new Person();      // вызов первого конструктора без параметров
        bob.displayInfo();
        Person tom = new Person("Tom"); // вызов второго конструктора с одним параметром
        tom.displayInfo();
        Person sam = new Person("Sam", 25); // вызов третьего конструктора с двумя параметрами
        sam.displayInfo();
         */

        double r;
        Circle k1 = new Circle(3.1 , 4.1,5.1,"\u201c");
        System.out.println("Длина окружности = " + k1.getLength() +
                " см\n");
        Scanner source = new Scanner(System.in) ;
        System.out.println("Введите радиус = ");
        r = source.nextDouble() ;
        k1.setR(r);
        System.out.println("\n Длина окруности = " + k1.getLength() +
                " см");
    }
}
class Circle
{
    private double x ;
    private double y ;
    private double r ;
    private String colour ;

    public  double getX()
    {
        return x ;
    }
    public void setX(double x)
    {
        this.x = x ;
    }
    public  double getY()
    {
        return y ;
    }
    public void setY(double y)
    {
        this.y = y ;
    }
    public  double getR()
    {
        return r ;
    }
    public void setR(double r)
    {
        this.r = r ;
    }

    public  String getColour()
    {
        return colour ;
    }
    public void setColour (String co)
    {
        this.colour = colour ;
    }
    public Circle (double x, double y, double r, String colour)
    {
        this.x=x ;
        this.y=y ;
        this.r=r ;
        this.colour=colour ;
    }

    public String toSring()
    {
        return "Circle{" +
                "x = " + x +
                ",y = " + y +
                ",r = " + r +
                ",colour = '" + colour + '\'' +
                '}' ;
    }
    public double getLength(){
        double c;
        c = 2 * Math.PI*r;
        return c;
    }

}
/*
class Person{
    String name;    // имя
    int age;        // возраст
    void displayInfo(){
        System.out.printf("Name: %s \tAge: %d\n", name, age);
    }
}
 */

/*
class Person{
    String name;    // имя
    int age;        // возраст
    Person()
    {
        name = "Undefined";
        age = 18;
    }
    Person(String n)
    {
        name = n;
        age = 18;
    }
    Person(String n, int a)
    {
        name = n;
        age = a;
    }
    void displayInfo(){
        System.out.printf("Name: %s \tAge: %d\n", name, age);
    }
}
 */