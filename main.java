import java.util.Scanner;
public class main {
    public static void main(String[] args) {

        // problem1();
         //problem2();
        problem3();
        //problem4();
        //problem 5();

    }
    public static void problem1() {
        System.out.println("Task 1");
        System.out.println("Введите натуральное число:");
        Scanner s1 = new Scanner(System.in);
        int i = s1.nextInt();
        int count = 0;//для подсчета шагов
        while (i != 1) {
            if (i % 2 == 0) {
                i /= 2;
            }
            else {
                i = i * 3 + 1;
            }
            count++;
        }

        //Вывод
        System.out.println("Кол-во шагов:"+count);

    }
    public static void problem2() {
        System.out.println("Task2");
        int sum =0 ;
        Scanner s2 = new Scanner(System.in);
        System.out.println("Введите количество чисел:");
        int length = s2.nextInt();
        int[] array = new int[length];
        System.out.println("Введите числа :");
        for (int i =0;i<length ;i++){
            array[i]= i;
            array[i]=s2.nextInt();
            //если индекс четный,то складываем
            if(i % 2 ==0 ){
                sum += array[i];
            }
            //иначе вычетаем
            else{
                sum -= array[i];
            }
        }
        //Вывод
        System.out.println("Результат:"+sum);

    }
    public static void problem3(){
        Scanner s3 = new Scanner(System.in);
        int x_0 = 0;//начальная координата
        int y_0 = 0;//начальная координата
        int count = 0;//для подсчета кол-ва указаний
        int num = 0;//для проверки мин.кол-ва указаний
        int final_num=0;//переменная для результата
        int t=0;
        String z = "";
        System.out.println("Координата x клада:");
        int x = s3.nextInt();
        System.out.println("Координата y клада :");
        int y = s3.nextInt();
        System.out.println("Сторона света :");
        System.out.println("Кол-во шагов :");

        while(true) {
            z = s3.next();
             if (z.equals("стоп")) {
                break;
            }
            t= s3.nextInt();
            s3.nextLine();
            if (z.equals("север")) {
                y_0 += t;
                count += 1;
            } else if (z.equals("запад")) {
                x_0 -= t;
                count += 1;
            } else if (z.equals("восток")) {
                x_0 += t;
                count += 1;
            } else if (z.equals("юг")) {
                y_0 -= t;
                count += 1;
            }
            //если дошли до клада
            if(x_0 == x && y_0 == y)
            {
                num +=1;
                //для минимального кол-ва указаний
                if(num == 1){
                    final_num = count;

                }
            }
        }
        System.out.print(final_num);

    }


    public static void problem4() {
        Scanner s4 = new Scanner(System.in);
        int max = 0;
        int doroga =0;
        int min_height = 500000;
        System.out.println("Task4");
        System.out.println("Введите количество дорог:");
        int r = s4.nextInt();//кол-во дорог
        int[] arr = new int[r];
        for (int i = 0; i < r; i++) {
            System.out.println("Введите количество туннелей:");
            int tun = s4.nextInt();//кол-во туннелей
            min_height = 500000;
            for (int j = 0; j < tun; j++) {
                System.out.println("Введите высоту туннеля:");
                int height = s4.nextInt();//высота туннеля
                if (height < min_height) {
                    min_height = height;//определяем минимальную высоту
                }
            }
            arr[i] = min_height;//в массиве будут храниться минимальные
            // высоты туннелей каждой из дорог
        }
        //найдем максимальную высоту грузовика и номер дороги
        for (int i =0;i<r;i++){
            if (max < arr[i]) {
                max = arr[i];
                doroga = i + 1;
            }
        }
        //Вывод
        System.out.println("Номер дороги:"+doroga);
        System.out.println("Максимальная высота:"+max);
    }


        public static void problem5 () {
            System.out.println("Task5");
            System.out.println("Введите положительное трехзначное число:");
            Scanner n = new Scanner(System.in);
            int i = n.nextInt();
            //проверка на трехзначность
            if (i >= 100 && i <= 999) {
                int sum = 0;//для вычисления суммы
                int pr = 1;//для вычисления произведения
                while (i != 0) {
                    //Суммирование цифр числа
                    sum += (i % 10);
                    //Произведение цифр числа
                    pr *= (i % 10);
                    i /= 10;
                }
                if (pr % 2 == 0 && sum % 2 == 0) {
                    System.out.println("Это число дважды четное");

                } else {
                    System.out.println("Это число не дважды четное");

                }
            } else {
                System.out.println("Ошибка");

            }
        }
    }

