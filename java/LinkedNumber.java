class LinkedNumber {
    int value;
    LinkedNumber next;

    LinkedNumber(int x) {
        value = x % 10;
        x /= 10;
        if (x != 0) {
            next = new LinkedNumber(x);
        }
    }

    void print() {
        int number = 0;
        int times = 1;
        LinkedNumber cur = this;
        while (cur != null) {
            number += cur.value * times;
            times *= 10;
            cur = cur.next;
        }

        System.out.println(number);
    }
}