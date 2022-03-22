package P08PetClinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    switch (tokens[1]) {
                        case "Pet":
                            pets.putIfAbsent(tokens[2], new Pet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]));
                            break;
                        case "Clinic":
                            try {
                                Clinic clinic = new Clinic(tokens[2], Integer.parseInt(tokens[3]));
                                clinics.putIfAbsent(tokens[2], clinic);
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                    }
                    break;
                case "Add":
                    System.out.println(clinics.get(tokens[2]).add(pets.get(tokens[1])));
                    break;
                case "Release":
                    System.out.println(clinics.get(tokens[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(tokens[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (tokens.length == 2){
                        System.out.println(clinics.get(tokens[1]).toString());
                    } else {
                        Pet pet = clinics.get(tokens[1]).getRoom(Integer.parseInt(tokens[2]));
                        System.out.println((pet == null ? "Room empty" : pet.toString()));
                    }
                    break;
            }
        }

    }
}
