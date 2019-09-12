class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int foldLen = numRows * 2 - 2;
        for (int i=0; i<numRows; i++) {
            int j = 0;
            while ( j * foldLen + i < len) {
                sb.append(s.charAt(j * foldLen + i));
                if (i != 0 && i != numRows - 1
                        && (j + 1) * foldLen - i < len) {
                    sb.append(s.charAt((j + 1) * foldLen - i));
                }
                j++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
//        String s = "PAYPALISHIRING";
//        int numRows = 4;
        String s = "PAYPALISHIRING";
        int numRows = 1;
//        String s = "P";
//        int numRows = 4;
        System.out.println(zigZagConversion.convert(s, numRows));
    }
}