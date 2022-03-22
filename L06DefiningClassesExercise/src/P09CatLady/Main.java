package P09CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Cat> cats = new HashMap<>();
        String input = scan.nextLine();

        while(!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            String name = tokens[1];
            double parameter = Double.parseDouble(tokens[2]);

            switch (tokens[0]){
                case "Siamese":
                    cats.putIfAbsent(name, new Siamese(name,parameter));
                    break;
                case "Cymric":
                    cats.putIfAbsent(name, new Cymric(name,parameter));
                    break;
                case "StreetExtraordinaire":
                    cats.putIfAbsent(name, new StreetExtraordinaire(name,parameter));
                    break;
            }
            input = scan.nextLine();
        }

        String catName = scan.nextLine();
        System.out.println(cats.get(catName));
    }
}
