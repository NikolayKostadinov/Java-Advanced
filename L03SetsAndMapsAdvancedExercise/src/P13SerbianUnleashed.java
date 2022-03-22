import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Long>> dataTable = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!"End".equals(input)) {
            Concert concert = new Concert();
            if (tryParse(input, concert)) {
                insertConcert(dataTable, concert);
            }

            input = scan.nextLine();
        }

        dataTable.entrySet()
                .stream()
                .forEach(venue -> {
                    System.out.println(venue.getKey());
                    venue.getValue()
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .forEach(performer ->
                                    System.out.printf("#  %s -> %d%n", performer.getKey(), performer.getValue()));
                });
    }

    private static void insertConcert(Map<String, Map<String, Long>> dataTable, Concert concert) {
        dataTable.putIfAbsent(concert.getVenue(), new LinkedHashMap<>());
        Map<String, Long> venue = dataTable.get(concert.getVenue());
        venue.putIfAbsent(concert.getName(), 0L);
        venue.put(concert.getName(), venue.get(concert.getName()) + concert.getPrice());
    }

    private static boolean tryParse(String input, Concert concert) {
        String regex = "^(?<singer>(\\b\\w+\\b\\s){1,3})@(?<venue>(\\b\\w+\\b\\s){1,3})" +
                "(?<ticketsPrice>\\d+)\\s(?<ticketsCount>\\d+)$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            concert.setVenue(matcher.group("venue").trim());
            concert.setName(matcher.group("singer").trim());
            concert.setTicketsPrice(Integer.parseInt(matcher.group("ticketsPrice")));
            concert.setTicketsCount(Integer.parseInt(matcher.group("ticketsCount")));
            return true;
        }
        return false;
    }

    private static class Concert {
        private String venue;
        private String name;
        private int ticketsPrice;
        private int ticketsCount;

        public Concert() {
        }

        public Concert(String venue, String name, int ticketsPrice, int ticketsCount) {
            this.venue = venue;
            this.name = name;
            this.ticketsPrice = ticketsPrice;
            this.ticketsCount = ticketsCount;
        }

        public String getVenue() {
            return venue;
        }

        public void setVenue(String venue) {
            this.venue = venue;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTicketsPrice(int ticketsPrice) {
            this.ticketsPrice = ticketsPrice;
        }

        public void setTicketsCount(int ticketsCount) {
            this.ticketsCount = ticketsCount;
        }

        public long getPrice() {
            return ticketsPrice * ticketsCount;
        }
    }
}
