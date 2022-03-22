package P04Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> steps;

    public Lake(List<Integer> steps) {
        this.steps = steps;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Frog(steps);
    }
}
