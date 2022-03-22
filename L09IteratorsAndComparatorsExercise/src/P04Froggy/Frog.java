package P04Froggy;

import java.util.Iterator;
import java.util.List;

public class Frog implements Iterator<Integer> {
    private final List<Integer> steps;
    private static int numberOfSteps;
    private static int currentIndex;
    public Frog(List<Integer> steps) {
        this.steps = steps;
    }

    @Override
    public boolean hasNext() {
        return this.steps.size() > this.numberOfSteps;
    }

    @Override
    public Integer next() {
        numberOfSteps++;
        Integer record = this.steps.get(currentIndex);;
        currentIndex+=2;
        if (currentIndex >= this.steps.size()){
            currentIndex = 1;
        }
        return record;
    }
}
