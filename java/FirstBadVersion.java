class FirstBadVersion {
    private final int VER = 2;

//    public int firstBadVersion(int n) {
//        if (n == 1) return 1;
//        return firstBad(0, n);
//    }
//
//    public int firstBad(int leftGood, int rightBad) {
//        if (leftGood + 1 == rightBad) return rightBad;
//        int guess = ((rightBad - leftGood) / 2) + leftGood;
//        if (isBadVersion(guess)) {
//            return firstBad(leftGood, guess);
//        } else {
//            return firstBad(guess, rightBad);
//        }
//    }

    public int firstBadVersion(int n) {
        if (isBadVersion(1))
            return 1;

        if (!isBadVersion(n))
            return -1;

        return lowBoundary(1, n);
    }

    private int lowBoundary(int l, int r) {
        if (isBadVersion(l))
            return l;

        if (l + 1 == r)
            return r;

        if (l >= r)
            return -1;

        int m = (r - l) / 2 + l;
        if (isBadVersion(m))
            if (!isBadVersion(m - 1))
                return m;
            else
                return lowBoundary(l, m - 1);
        else
            return lowBoundary(m + 1, r);
    }

    private boolean isBadVersion(int version) {
        return version >= VER;
    }

    public static void main(String[] args) {
        int version = 2;
        FirstBadVersion firstBadVersion = new FirstBadVersion();

        int v = firstBadVersion.firstBadVersion(version);
        System.out.println(String.format("the first bad version is %d", v));
    }
}