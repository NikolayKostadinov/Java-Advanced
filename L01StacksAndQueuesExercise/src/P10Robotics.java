import java.util.*;

public class P10Robotics {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] tokens = scanner.nextLine().split(";");
        String[] robots = new String[tokens.length];
        int[] processTime = new int[tokens.length];
        int[] workTime = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String[] data = tokens[i].split("-");
            String name = data[0];
            int time = Integer.parseInt(data[1]);
            robots[i] = name;
            processTime[i] = time;
        }

        String startTime = scanner.nextLine();

        ArrayDeque<String> productsQueue = getProductsQueue();

        int startTimeInSeconds = getStartTimeInSeconds(startTime);

        while (!productsQueue.isEmpty()) {
            startTimeInSeconds++;
            String product = productsQueue.poll();

            boolean isWorking = false;
            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isWorking) {
                    workTime[i] = processTime[i];
                    isWorking = true;
                    printRobotData(robots[i], product, startTimeInSeconds);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }

            if (!isWorking) { //ako ima svoboden
                productsQueue.offer(product);
            }
        }

    }

    private static ArrayDeque<String> getProductsQueue() {
        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String inputProduct = scanner.nextLine();
        while (!inputProduct.equals("End")) {
            productsQueue.offer(inputProduct);
            inputProduct = scanner.nextLine();
        }

        return productsQueue;
    }

    private static int getStartTimeInSeconds(String startTime) {
        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;
        return startTimeInSeconds;
    }

    private static void printRobotData(String robot, String product, int startTimeInSeconds) {
        int s = startTimeInSeconds % 60;
        int m = (startTimeInSeconds / 60) % 60;
        int h = (startTimeInSeconds / (60 * 60)) % 24;
        System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot, product, h, m, s);
    }
}
