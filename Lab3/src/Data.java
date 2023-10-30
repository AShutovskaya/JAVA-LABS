import Elements.Halls;
import Elements.Cinemas;
import Elements.Sessions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
    private static Data ourInstance;
    public Cinemas[] Cinemas;
    private Halls[] Halls;

    private Sessions[] shows1;
    private Sessions[] shows2;
    private Sessions[] shows3;
    private static boolean[][] seatStatus;
    private static List<String> userHistory;

    public synchronized static Data getInstance() {
        if (ourInstance == null) {
            ourInstance = new Data();
        }
        return ourInstance;
    }
    private Data() {
        Halls=new Halls[]{  new Halls("1", 8, 10, "IMAX"),
                new Halls("2", 3, 4, "VIP"),
                new Halls("3", 6, 10, "IMAX"),
                new Halls("1", 3, 4, "VIP"),
                new Halls("2", 5, 9, "IMAX"),
                new Halls("1", 3, 4, "VIP"),
                new Halls("2", 10, 10, "IMAX"),
                new Halls("3", 8, 12, "IMAX")};

        Cinemas = new Cinemas[]{
                new Cinemas("Люмен", "Московский пр.,257", "есть парковка"),
                new Cinemas("Киносфера", "ул.Генерала Челнокова ,11", "нет парковки"),
                new Cinemas("Заря", "Пр-т Мира,41/43", "есть парковка")};



        shows1 = new Sessions[]{new Sessions(1,"Жанна Дюббари", "3:30pm", 100),
                new Sessions(2,"Тетрис", "4:00pm", 300),
                new Sessions(3,"1+1", "6:00pm", 200)};

        shows2 = new Sessions[]{new Sessions(1,"Тайная жизнь домашних животных", "2:00pm", 200),
                new Sessions(2,"Тетрис", "7:00pm", 200)};

        shows3 = new Sessions[]{new Sessions(1,"Жанна Дюббари", "5:00pm", 200),
                new Sessions(2,"Король Ричард ", "1:00pm", 200),
                new Sessions(3,"1+1", "7:00pm", 200)};

    }
    public synchronized Cinemas[] findAllCinemas() {
        return Cinemas;
    }
    public synchronized Sessions[] sessions1cinema() {
        return shows1;
    }
    public synchronized Sessions[] sessions2cinema() {
        return shows2;
    }
    public synchronized Sessions[] sessions3cinema() {
        return shows3;
    }
    public synchronized Halls hall1() {
        return Halls[0];
    }
    public synchronized Halls hall2() {
        return Halls[1];
    }
    public synchronized Halls hall3() {
        return Halls[2];
    }
    public synchronized Halls hall4() {
        return Halls[3];
    }
    public synchronized Halls hall5() {
        return Halls[4];
    }
    public synchronized Halls hall6() { return Halls[5];}
    public synchronized Halls hall7() {return Halls[6];}
    public synchronized Halls hall8() {return Halls[7];}

    public static void selectSeat(Halls hall) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Зал:");

        int flag = 0;
        int rows = hall.get_row();
        int seats = hall.get_seat();
        if (seatStatus == null) {
            seatStatus = new boolean[rows][seats];
        }
        if (userHistory == null) {
            userHistory = new ArrayList<>();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (seatStatus[i][j]) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[0]");
                }
            }
            System.out.println();
            flag++;
        }
        while (flag > 0) {
            System.out.println("Выберите ряд:");
            int selectedRow = scanner.nextInt() - 1;
            System.out.println("Выберите место:");
            int selectedSeat = scanner.nextInt() - 1;
            if (selectedRow >= 0 && selectedRow < rows && selectedSeat >= 0 && selectedSeat < seats) {
                if (seatStatus[selectedRow][selectedSeat]) {
                    System.out.println("Место занято. Пожалуйста, выберите другое.");
                    continue;
                } else {
                    seatStatus[selectedRow][selectedSeat] = true;
                    String seatInfo = String.format("Ряд %d, Место %d", selectedRow + 1, selectedSeat + 1);
                    userHistory.add(seatInfo);

                    System.out.printf("Место свободно. Выбранное место: %s\n", seatInfo);
                }
            } else {
                System.out.println("Некорректный выбор ряда или места.");
                continue;
            }
            System.out.println("---Хотите ли вы забронировать еще место? (Да/Нет)---");
            String answer = scanner.next();
            if (answer.equals("Да")) {
                flag++;
            } else {
                flag = 0;
                System.out.printf("---Ваши места: %s ---\n---Приятного просмотра!---\n", userHistory);
            }
        }

        System.out.println("Зал:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (seatStatus[i][j]) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[0]");
                }
            }
            System.out.println();
        }
    }


}






