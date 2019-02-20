class AddLinkedNumbers {
    public LinkedNumber add(LinkedNumber n1, LinkedNumber n2) {
        LinkedNumber ret = null;
        LinkedNumber tail = null;
        int overflow  = 0;
        while (n1 != null || n2 != null || overflow != 0) {
            int cur = overflow;
            if (n1 != null) {
                cur += n1.value;
                n1 = n1.next;
            }
            if (n2 != null) {
                cur += n2.value;
                n2 = n2.next;
            }
            overflow = cur / 10;
            cur = cur % 10;

            LinkedNumber latest = new LinkedNumber(cur);
            if (tail == null) {
                tail = latest;
                ret = latest;
            } else {
                tail.next = latest;
                tail = latest;
            }
        }

        return ret;
    }

    public static void main(String args[]) {
        LinkedNumber n1 = new LinkedNumber(125);
        n1.print();
        LinkedNumber n2 = new LinkedNumber(999876);
        n2.print();

        AddLinkedNumbers a = new AddLinkedNumbers();
        LinkedNumber n3 = a.add(n1, n2);
        n3.print();
    }
}