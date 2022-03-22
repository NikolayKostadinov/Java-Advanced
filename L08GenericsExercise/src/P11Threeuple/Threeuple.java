package P11Threeuple;

public class Threeuple<Ti1,Ti2, Ti3> {
    private Ti1 item1;
    private Ti2 item2;
    private Ti3 item3;

    public Threeuple() {
    }

    public Threeuple(Ti1 item1, Ti2 item2, Ti3 item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
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

    public Ti3 getItem3() {
        return item3;
    }

    public void setItem3(Ti3 item3) {
        this.item3 = item3;
    }
}
