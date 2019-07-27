class LongestSubstring {
    public int lengthOfLongestSubstring(String source) {
        if (source == null || source.length() == 0) {
            return 0;
        }

        int[] lens = new int[source.length()];
        lens[0] = 1;
        for (int i=1; i<source.length(); i++) {
            int cur = 1;
            for (int j=i-1; j>=0 && j>=i-lens[i-1]; j--) {
                if (source.charAt(i) == source.charAt(j)) {
                    break;
                } else {
                    cur++;
                }
            }

            lens[i] = cur;
        }

        int ret = 1;
        for (int i=1; i<source.length(); i++) {
            System.out.print(String.format("%d, ", lens[i]));
            System.out.println();
            ret = ret > lens[i] ? ret : lens[i];
        }

        return ret;
    }

    public static void main(String args[]) {
        LongestSubstring l = new LongestSubstring();
        int r = l.lengthOfLongestSubstring("abcdbefedbacgcece");
        System.out.println(r);
    }
}