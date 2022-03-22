package L99ExamPreparation.E08JavaAdvancedExam22Feb2020.guild;

import java.util.*;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private final Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.put(player.getName(), player);
        }
    }

    public boolean removePlayer(String name) {
        if (this.roster.containsKey(name)) {
            this.roster.remove(name);
            return true;
        }

        return false;
    }

    public void promotePlayer(String name) {
        this.changePlayerRank(name, "Member");
    }

    public void demotePlayer(String name) {
        this.changePlayerRank(name, "Trial");
    }

    private void changePlayerRank(String name, String rank) {
        for (Map.Entry<String, Player> playerEntry : this.roster.entrySet()) {
            if (playerEntry.getValue().getName().equals(name)){
                this.roster.get(name).setRank(rank);
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<String> forRemove = this.roster
                .entrySet()
                .stream()
                .filter(p->p.getValue().getClazz().equals(clazz))
                .map(p->p.getValue().getName())
                .collect(Collectors.toList());

        Player[] removerArray = new Player[forRemove.size()];
        for (int i = 0; i < removerArray.length; i++) {
            removerArray[i] = this.roster.remove(forRemove.get(i));
        }
        return removerArray;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        return String.format("Players in the L99ExamPreparation.E08JavaAdvancedExam22Feb2020.guild: %s:", this.name) +
                (this.roster.isEmpty() ? "" :
                        String.format("%n%s", this.roster.entrySet()
                                .stream()
                                .map(p->p.getValue().toString())
                                .collect(Collectors.joining(System.lineSeparator()))));
    }
}
