package P10Tuple;

public class Tuple<Ti1,Ti2> {
    private Ti1 item1;
    private Ti2 item2;

    public Tuple(Ti1 item1, Ti2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public Ti1 getItem1() {
        return item1;
    }

    public void setItem1(Ti1 item1) {
        this.item1 = item1;
    }

    public Ti2 getItem2() {
        return item2;
    }

    public void setItem2(Ti2 item2) {
        this.item2 = item2;
    }
}
