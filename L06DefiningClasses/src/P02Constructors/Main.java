package P02Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int counter = Integer.parseInt(scan.nextLine());
        while (counter-- >0){
            String[] tokens = scan.nextLine().split("\\s+");
            Car car = null;
            if (tokens.length == 3){
                car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            } else {
                car = new Car(tokens[0]);
            }
            System.out.println(car.carInfo());
        }
    }
}
