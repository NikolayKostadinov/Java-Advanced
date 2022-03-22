package P01Car;

import L06DefiningClasses.P01Car.Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int counter = Integer.parseInt(scan.nextLine());
        while (counter-- >0){
            Car car = new Car();
            String[] tokens = scan.nextLine().split("\\s+");
            car.setBrand(tokens[0]);
            car.setModel(tokens[1]);
            car.setHorsePower(Integer.parseInt(tokens[2]));
            System.out.println(car.carInfo());
        }
    }
}
