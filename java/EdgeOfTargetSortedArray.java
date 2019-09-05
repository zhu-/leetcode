class EdgeOfTargetSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ret;
        }

        ret[0] = lowBound(nums, target, 0, nums.length - 1);
        ret[1] = upBound(nums, target, 0, nums.length - 1);

        return ret;
    }

    private int lowBound(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        if (nums[l] == target) {
            return l;
        }

        int m = (l + r) / 2;
        if (nums[m] == target) {
            if (nums[m - 1] < target)
                return m;
            else
                return lowBound(nums, target, l, m - 1);
        } else if (nums[m] < target) {
            return lowBound(nums, target, m + 1, r);
        } else {
            return lowBound(nums, target, l, m - 1);
        }
    }

    private int upBound(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        if (nums[r] == target) {
            return r;
        }

        int m = (l + r) / 2;
        if (nums[m] == target) {
            if (nums[m + 1] > target)
                return m;
            else
                return upBound(nums, target, m + 1, r);
        } else if (nums[m] < target) {
            return upBound(nums, target, m + 1, r);
        } else {
            return upBound(nums, target, l, m - 1);
        }
    }

    public static void main(String[] args) {
        EdgeOfTargetSortedArray edge = new EdgeOfTargetSortedArray();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] ret = edge.searchRange(nums, target);

        System.out.println(String.format("%d, %d", ret[0], ret[1]));
    }
}