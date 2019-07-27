class ReverseInt {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int r = x % 10;
            x /= 10;

            // TBD: check overflow

            rev = rev * 10 + r;
        }

        return rev;
    }

    public static void main(String args[]) {
        ReverseInt r = new ReverseInt();

        int ret = r.reverse(-123);
        System.out.println(ret);
    }
}