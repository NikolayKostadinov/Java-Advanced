package L99ExamPreparation.E08JavaAdvancedExam22Feb2020.guild;

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this(name, clazz, "Trial", "n/a");
    }

    private Player(String name, String clazz, String rank, String description) {
        this.name = name;
        this.clazz = clazz;
        this.rank = rank;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Player %s: %s%n" +
                "Rank: %s%n" +
                "Description: %s", this.name, this.clazz, this.rank, this.description);
    }
}
