import java.util.Scanner;
import java.util.Arrays;
public class main {
    public static void main(String[] args) {

         //problem1();
       // problem2();
        problem3();
        //problem4();
        //problem5();
       // problem6();
        //problem7();
        //problem8();

    }
    public static void problem1() {
        Scanner s1 = new Scanner(System.in);
        String s = s1.nextLine();
        int max_str = 0;//длина максимальной строки
        int current_substr = 0;//длина текущей подстроки
        int start_ind = 0;//индекс начала подстроки
        int[] array = new int[256];//массив для хранения встречающихся символов
        char[] CharArray = s.toCharArray();//преобразует строку в массив с символами
        for (int i = 0; i < CharArray.length; i++) {
            if (array[CharArray[i]] > 0)//если символ уже встречался
            {
                current_substr = 0;//сбрасываем длину текущей подстроки
                array = new int[256];//сбрасываем счетчик встречающихся символов

            }
            array[CharArray[i]]++;
            current_substr++;
            if (current_substr > max_str) {//если длина текущей подстроки больше максимальной длины
                max_str = current_substr;//обновляем макс.длину
                start_ind = i - max_str + 1;//обновляем индекс начала подстроки
            }

        }
        String longestSubstring = s.substring(start_ind, start_ind + max_str);
        System.out.println("Наибольшая подстрока с уникальными символами: " + longestSubstring);

    }
    public static void problem2() {
        Scanner s2 = new Scanner(System.in);
        int i = 0;
        int j = 0;
        int k = 0;

        System.out.println("Введите количество чисел в первом массиве:");
        int x_length = s2.nextInt();

        System.out.println("Введите числа первого массива:");
        int[] X = new int[x_length];
        for ( i = 0; i < x_length; i++) {
            X[i] = s2.nextInt();
        }

        System.out.println("Введите количество чисел во втором массиве:");
        int y_length = s2.nextInt();

        System.out.println("Введите числа второго массива:");
        int[] Y = new int[y_length];
        for ( j = 0; j < y_length; j++) {
            Y[j] = s2.nextInt();
        }

        int[] arr = new int[x_length + y_length];
        // пока есть элементы в первом и втором массивах
        while (i < x_length && j < y_length) {
            if (X[i] < Y[j]) {
                arr[k] = X[i];
                i++;
            } else {
                arr[k] = Y[j];
                j++;
            }
            k++;
        }
        // копируем оставшиеся элементы
        while (i < x_length) {
            arr[k] = X[i];
            i++;
            k++;
        }

        while (j < y_length) {
            arr[k] = Y[j];
            j++;
            k++;
        }

        System.out.println("First Array : " + Arrays.toString(X));
        System.out.println("Second Array: " + Arrays.toString(Y));
        System.out.println("After Merge : " + Arrays.toString(arr));
    }
    public static void problem3(){
        Scanner s3 = new Scanner(System.in);
        System.out.println("Введите количество чисел в массиве:");
        int length = s3.nextInt();
        int[] arr=new int [length];
        System.out.println("Введите числа  массива:");
        for(int i = 0;i<length;i++)
        {
            arr[i]=i;
            arr[i]=s3.nextInt();

        }
        int maxmas = arr[0];;// сохраняет максимальный суммарный подмассив, найденный на данный момент
        int maxsum=arr[0];// сохраняет максимальную сумму подмассива, заканчивающегося на текущей позиции
        for(int i=0;i<length;i++)
        {

            maxsum=Integer.max(arr[i],maxsum+arr[i]);
            maxmas=Integer.max(maxmas,maxsum);  // обновить результат, если текущая сумма подмассива окажется больше

        }
        System.out.println(maxmas);

    }
    public static void problem4() {
        Scanner s4 = new Scanner(System.in);
        System.out.println("Введите количество строк");
        int n = s4.nextInt();
        System.out.println("Введите количество столбцов");
        int m = s4.nextInt();

        int[][] arr = new int[n][m];
        int[][] fin_arr = new int[m][n];//для повернутого массива
        System.out.println("Введите массив:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                arr[i][j] = s4.nextInt();
            }
        }
        //поворот по часовой стрелке
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               fin_arr[j][m-i-1]=arr[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print( fin_arr[i][j]);
            }
            System.out.println();

        }
    }
    public static void problem5() {
        Scanner s5 = new Scanner(System.in);
        System.out.println("Введите количество элементов массива:");
        int n = s5.nextInt();
        int arr[] = new int[n];
        System.out.println("Введите массив:");
        for (int i =0;i<n;i++)
        {
            arr[i]=s5.nextInt();
        }
        System.out.println("Введите число target:");
        int target = s5.nextInt();
        int flag = 0;//для проверки наличия подходящей пары чисел
        for(int i =0;i<(n-1);i++)
        {
            for (int j=i;j<n;j++){
                if(arr[i]+arr[j] == target)
                {
                    System.out.printf("%d %s%n",arr[i],arr[j]);
                    flag ++;
                    break;
                }

            }
        }
        if(flag == 0)//если не нашлась такая пара чисел
        {
            System.out.println("null");
        }

    }
    public static void problem6() {
        Scanner s6 = new Scanner(System.in);
        System.out.println("Введите количество строк");
        int n = s6.nextInt();
        System.out.println("Введите количество столбцов");
        int m = s6.nextInt();
        int[][] arr=new int[n][m];
        int sum =0 ;//сумма элементов
        System.out.println("Введите массив");
        for(int i =0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                arr[i][j]= s6.nextInt();
            }
        }
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
    public static void problem7() {
        Scanner s7 = new Scanner(System.in);
        System.out.println("Введите количество строк");
        int n = s7.nextInt();
        System.out.println("Введите количество столбцов");
        int m = s7.nextInt();
        int arr[][]=new int[n][m];

        System.out.println("Введите массив");
        for(int i =0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                arr[i][j]= s7.nextInt();
            }
        }

        for (int i =0;i<n;i++){

            int max=arr[i][0];
            for(int j=1;j<m;j++){

                if(max<arr[i][j]){
                    max = arr[i][j];
                }
            }
            System.out.printf("%3d",max);

        }

    }

    public static void problem8() {
        Scanner s4 = new Scanner(System.in);
        System.out.println("Введите количество строк");
        int n = s4.nextInt();
        System.out.println("Введите количество столбцов");
        int m = s4.nextInt();

        int[][] arr = new int[n][m];
        int[][] fin_arr = new int[m][n];// для повернутого массива
        System.out.println("Введите массив:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                arr[i][j] = s4.nextInt();
            }
        }
        //поворот против часовой стрелки
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fin_arr[m-j-1][i]=arr[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d",fin_arr[i][j]);
            }
            System.out.println();

        }
    }

}


