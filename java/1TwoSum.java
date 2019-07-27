class TwoSum {
    public int[] twoSum(int[] num, int target) {
        if (num == null || num.length < 2)
            return null;

        for (int i=0; i<num.length - 1; i++)
            for (int j=i+1; j<num.length; j++)
                if (num[i] + num[j] == target){
                    int[] ret = {i, j};
                    return ret;
                }

        return null;
    }

    public static void main(String args[]) {
        int[] num = {2, 7, 11, 15};

        TwoSum t = new TwoSum();
        int[] r = t.twoSum(num, 9);

        if (r != null) {
            System.out.print(String.format("%d", r[0]));

            for (int i = 1; i < r.length; i++)
                System.out.print(String.format(", %d", r[i]));

            System.out.println();
        } else {
            System.out.println("Not found.");
        }
    }
}
