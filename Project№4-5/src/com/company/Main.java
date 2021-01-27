package com.company;
public class Main
{

    public static void main(String[] args)
    {


        String nums[];
        int i = -1;
        String y ;
        int j ;
        nums = new String [ 1 ];                  // массив из 1 чисел

        nums = Put("1",nums ,i = in(i)) ;      // Пример добовление числа в очередь + динамическое увеличение масива

        nums = Put("3",nums ,i = in(i)) ;

        nums = Put("5",nums ,i = in(i)) ;

        nums = Put("6",nums ,i = in(i)) ;

        nums = Put("11",nums ,i = in(i)) ;

        nums = Put("5",nums ,i = in(i)) ;

        //  System.out.println(i);  // <-- Вывод для проверки

        nums = Put("6",nums ,i = in(i)) ;

        //  System.out.println(i);  // <-- Вывод для проверки

        nums = Put("999",nums ,i = in(i)) ;

        //  System.out.println(i);  // <-- Вывод для проверки

        nums = Put("66",nums ,i = in(i)) ;

        System.out.println("---------------------- Ввод данны успех ---------------------------------");
        y = Get(nums) ; nums = Gets(nums) ;       // Пример достования числа из очериди
        System.out.println(y);  // <-- Вывод для проверки

        y = Get(nums) ; nums = Gets(nums) ;
        System.out.println(y);  // <-- Вывод для проверки

        y = Get(nums) ; nums = Gets(nums) ;
        System.out.println(y);  // <-- Вывод для проверки

        System.out.println("---------------------- доставание из очереди успех ----------------------");
        System.out.println(nums.length); // <-- Вывод для проверки


        nums = AllGets(nums);                    // Очищаем пустые ечейки масива (размер равен количеству ечек)

        System.out.println(nums.length); // <-- Вывод для проверки

        System.out.println("----------------- Очистка масива от пустых полей успех ------------------");


        int R[] = new int [ nums.length   ];

        for ( j = 0; j < nums.length ; j++)
        {
            // System.out.println(nums[j]);
            R[j] = Integer.parseInt (nums[j]) ;           // Преобразование масива из String[] в Int[]
        }
        R = insertionSortImperative(R);                   // Вызываем метод для сортировки по вырянту 3 (Сортировка вставками)

        for ( j = 0; j < R.length ; j++){
            System.out.println(R[j]);                    // Выводим массив для проверки сортировки
        }
        System.out.println("------------ Работа сортировки успех (первое индивидуальное задание ) -----------");

        String c[] = new String [ 2 ];
        int max = 0 , min = 40 ;
        double a ;
        String m ;
        for (j = 0; j < 10 ; j++)                // Цикл с данными из задания
        {
            a =  Math.random()*40;             // Случайное значени от 0 до 40
            m = (int)a + "";
            if ( a > max ){                   // Запоминаем максимальное
                max = j ;
            }
            if ( a < min ){                     // Запоминаем минимальное
                min = j ;
            }
            //    System.out.println(m); // <-- Вывод для проверки
            //    System.out.println("==" + j); // <-- Вывод для проверки
            c = Put(m,c,j) ;        // Помешаем случайные числа в масив
        }

        String s ;
        s = c[max] ;
        c[max] = c[min] ;     // Меняю местами минимальное и максимальное
        c[min] = s ;

        System.out.println("------------ Ввывод финального масива -----------");
        for (j = 0; j < 10 ; j++){
            System.out.println(c[j]);
        }

    }


    static String[] Put ( String x,String y[] , int i)
    {
        if (y.length  <= i  )
        {
            // System.out.println(")-Увеличение размера-( " + y.length + "--" + i);


            String  GGG[] = new String [y.length * 2 ];

            for (int j = 0; j < y.length; j++){
                GGG[j] = y[j];
            }
            y = GGG;
        }

        y[i] = x ;
        return  y ;
    }
    static int in (int x )
    {
        x++ ;
        return x ;
    }

    static String Get (String y[] )
    {
        return y[0] ;
    }


    static String[] Gets (String y[] )
    {
        for (int j = 1; j < y.length ; j++)
        {
            y[j - 1] = y[j];
        }
        y[y.length - 1] = null ;
        return y ;
    }
    static String[] AllGets (String y[] )
    {
        int k = 0 ;
        for (int i = 0 ; i < y.length; i++)
        {
            if (y[i] == null )
            {
                k++;
            }
        }
        String  GGG[] = new String [ (y.length - k) ];

        for (int j = 0; j < GGG.length; j++){
            GGG[j] = y[j];
        }
        return GGG;
    }

    public static int[] insertionSortImperative(int[]input)
    {
        for (int i = 1; i < input.length; i++)
        {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j]> key)
            {
                input[j + 1]= input[j];
                j = j - 1;
            }
            input[j + 1]= key;
        }

        return input;
    }






}