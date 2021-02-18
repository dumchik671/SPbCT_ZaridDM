package com.company;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1); // 1 разрешение
        CommonResource res = new CommonResource();
        new Thread(new CountThread(res, sem, "CountThread 1")).start();
        new Thread(new CountThread(res, sem, "CountThread 2")).start();
        new Thread(new CountThread(res, sem, "CountThread 3")).start();

        Semaphore sem1 = new Semaphore(2);
        for(int i=1;i<6;i++)
            new Philosopher(sem1,i).start();

        System.out.println("\n+ ---------------- Задание 1 ---------------- +\n");
    }
}

class CommonResource{

    int x=0;
}

class CountThread implements Runnable {

    CommonResource res;
    Semaphore sem;
    String name;

    CountThread(CommonResource res, Semaphore sem, String name) {
        this.res = res;
        this.sem = sem;
        this.name = name;
    }

    public void run() {

        try {
            System.out.println(name + " ожидает разрешение");
            sem.acquire();
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(this.name + ": " + res.x);
                res.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " освобождает разрешение");
        sem.release();
    }
}

class Philosopher extends Thread
{
    Semaphore sem;
    int num = 0;
    int id;
    Philosopher(Semaphore sem, int id)
    {
        this.sem=sem;
        this.id=id;
    }

    public void run()
    {
        try
        {
            while(num<3)
            {
                sem.acquire();
                System.out.println ("Философ " + id+" садится за стол");
                sleep(500);
                num++;
                System.out.println ("Философ " + id+" выходит из-за стола");
                sem.release();
                sleep(500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println ("у философа " + id + " проблемы со здоровьем");
        }
    }
}