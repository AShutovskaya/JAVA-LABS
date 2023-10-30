import java.util.Scanner;
import Elements.Cinemas;
import Elements.Halls;
import Elements.Sessions;
public class Main {
    static Data data = Data.getInstance();

    public static void main(String[] args) {
        System.out.println("---Введите свой запрос---");
        String answer;
        Scanner scanner = new Scanner(System.in);
        answer = scanner.next();
        if (answer.equals("Афиша")) {
            System.out.println("---Выберите кинотеатр---");
            Cinemas[] cinema = data.findAllCinemas();
            for (int i = 0; i < cinema.length; i++) {
                Cinemas Cinemas = cinema[i];
                System.out.println(Cinemas);
            }
            answer = scanner.next();
            if (answer.equals("Люмен")) {
                Sessions[] shows = data.sessions1cinema();
                for (int i = 0; i < shows.length; i++) {
                    Sessions Sessions = shows[i];
                    System.out.println(Sessions);
                }
                System.out.println("---Выберите сеанс---");
                answer = scanner.next();
                if (answer.equals("1")) {
                    Halls hall = data.hall1();
                    System.out.println(hall);
                    data.selectSeat(hall);

                }
                else if (answer.equals("2")) {
                    Halls hall = data.hall2();
                    System.out.println(hall);
                    data.selectSeat(hall);

                } else if (answer.equals("3")) {
                    Halls hall = data.hall3();
                    System.out.println(hall);
                    data.selectSeat(hall);
                }

            }

        }
        if (answer.equals("Киносфера")) {
            Sessions[] shows = data.sessions2cinema();
            for (int i = 0; i < shows.length; i++) {
                Sessions Sessions = shows[i];
                System.out.println(Sessions);

            }
            System.out.println("---Выберите сеанс---");
            answer = scanner.next();
            if (answer.equals("1")) {
                Halls hall = data.hall4();
                System.out.println(hall);
                data.selectSeat(hall);

            } else if (answer.equals("2")) {

                Halls hall = data.hall5();
                System.out.println(hall);
                data.selectSeat(hall);
            }

        }
        if (answer.equals("Заря")) {
            Sessions[] shows = data.sessions3cinema();
            for (int i = 0; i < shows.length; i++) {
                Sessions Sessions = shows[i];
                System.out.println(Sessions);

            }

            System.out.println("---Выберите сеанс---");
            answer = scanner.next();
            if (answer.equals("1")) {
                Halls hall = data.hall6();
                System.out.println(hall);
                data.selectSeat(hall);
            } else if (answer.equals("2")) {

                Halls hall = data.hall7();
                System.out.println(hall);
                data.selectSeat(hall);


            } else if (answer.equals("3")) {
                Halls hall = data.hall8();
                System.out.println(hall);
                data.selectSeat(hall);
            }

        }

    }

}



