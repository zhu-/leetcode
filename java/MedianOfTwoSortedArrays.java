class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return nums1.length == 0 ?
                    medianOfSortedArray(nums2)
                    : medianOfSortedArray(nums1);
        }

        int p1 = 0;
        int p2 = 0;
        while (p1 + p2 < (nums1.length + nums2.length - 1) / 2) {
            if (p1 + 1 >= nums1.length) {
                p2++;
            } else if (p2 + 1 >= nums2.length) {
                p1++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                if (nums1[p1 + 1] < nums2[p2 + 1]) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }

        if (isEven(nums1.length + nums2.length)) {
            return averageMediansOfTwoArray(nums1, nums2, p1, p2);
        } else {
            return theMedianOfTwoArray(nums1, nums2, p1, p2);
        }
    }

    private double averageMediansOfTwoArray(int[] nums1, int[] nums2, int p1, int p2) {
        if (nums1[p1] < nums2[p2]) {
            if (p1 + 1 < nums1.length && nums1[p1 + 1] < nums2[p2]) {
                return (nums1[p1] + nums1[p1 + 1]) / 2.0;
            } else if (p2 - 1 >= 0 && nums2[p2 - 1] > nums1[p1]) {
                return (nums2[p2 - 1] + nums2[p2]) / 2.0;
            }
        } else if (nums1[p1] > nums2[p2]) {
            if (p2 + 1 < nums2.length && nums2[p2 + 1] < nums1[p1]) {
                return (nums2[p2] + nums2[p2 + 1]) / 2.0;
            } else if (p1 - 1 >= 0 && nums1[p1 - 1] > nums2[p2]) {
                return (nums1[p1 - 1] + nums1[p1]) / 2.0;
            }
        }

        return (nums1[p1] + nums2[p2]) / 2.0;
    }

    private int theMedianOfTwoArray(int[] nums1, int[] nums2, int p1, int p2) {
        int m1 = nums1[p1];
        int m2 = nums2[p2];
        if (m1 < m2) {
            if (p2 - 1 >= 0 && nums2[p2 - 1] > m1) {
                return nums2[p2 - 1];
            }
        } else if (m1 > m2) {
            if (p1 - 1 >= 0 && nums1[p1 - 1] > m2) {
                return nums1[p1 - 1];
            }
        }

        return m1 < m2 ? m1 : m2;
    }

    private double medianOfSortedArray(int[] nums) {
        int half = nums.length / 2;
        if (isEven(nums.length)) {
            return (nums[half - 1] + nums[half]) / 2.0;
        } else {
            return nums[half];
        }
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};
//        int[] nums1 = {};
//        int[] nums2 = {1};
//        int[] nums1 = {1};
//        int[] nums2 = {2, 3};

//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};
//        int[] nums1 = {2, 3};
//        int[] nums2 = {1, 4};
//        int[] nums1 = {1};
//        int[] nums2 = {2, 3, 4};
        int[] nums1 = {2, 3, 4};
        int[] nums2 = {1};
        double median = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(String.format("median is %f", median));
    }
}