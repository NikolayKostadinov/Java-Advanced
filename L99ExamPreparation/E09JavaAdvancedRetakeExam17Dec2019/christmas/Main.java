package L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas;

public class Main {
    public static void main(String[] args) {
        // Initialize the repository
        Bag bag = new Bag("black", 10);

        // Initialize entity
        Present present = new Present("Doll", 0.4, "girl");

        // Print L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas.Present
        System.out.println(present); // L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas.Present Doll (0.40) for a girl

        // Add L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas.Present
        bag.add(present);

        // Remove L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas.Present
        System.out.println(bag.remove("Toy"));

        Present secondPresent = new Present("Train", 2, "boy");
        // Add L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas.Present
        bag.add(secondPresent);

        Present heaviestPresent = bag.heaviestPresent();
        System.out.println(heaviestPresent);
        // L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas.Present Train (2.00) for a boy

        Present p = bag.getPresent("Doll");
        System.out.println(p);
        // L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas.Present Doll (0.40) for a girl

        System.out.println(bag.count()); // 2
        System.out.println(bag.report());

        // Black bag contains:
        // L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas.Present Doll (0.40) for a girl
        // L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019.christmas.Present Train (2.00) for a boy

    }
}
