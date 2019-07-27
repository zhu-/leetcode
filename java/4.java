class Solution {
    public static boolean isOdd(int t) {
        return t != t/2 * 2;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return -1;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int mergedLen = len1 + len2;
        if (nums1[0] >= nums2[len2 - 1]) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;

            len1 = nums1.length;
            len2 = nums2.length;
        }

        if (nums1[len1-1] <= nums2[0]) {
            if (isOdd(mergedLen)) {
                return len1 <= mergedLen/2 ? nums2[mergedLen/2 - len1] : nums1[mergedLen/2];
            } else {
                if (len1 == len2) {
                    return (nums1[len1-1] + nums2[0]) / 2.0;
                } else if (len1 > len2) {
                    return (nums1[mergedLen/2 - 1] + nums1[mergedLen/2]) / 2.0;
                } else {
                    return (nums2[mergedLen/2 - len1 - 1] + nums2[mergedLen/2 - len1]) / 2.0;
                }
            }
        }

        int t1 = len1/2;
        int t2 = len2/2;
        if (!isOdd(len1) || !isOdd(len2)) {
            if (isOdd(len2)) {
                if (nums1[t1] == nums2[t2]) {
                    return nums1[t1];
                } else if (nums1[t1] < nums2[t2]) {
                    if (nums1[t1 + 1] > nums2[t2]) {
                        return nums2[t2];
                    } else {
                        // Nothing
                    }
                } else {
                    t1--;
                }
            } else if (isOdd(len1)) {
                if (nums1[t1] == nums2[t2]) {
                    return nums1[t1];
                } else if (nums1[t1] < nums2[t2]) {
                    t2++;
                }
            } else {
                if (nums1[t1] <= nums2[t2]) {
                    t1++;
                } else {
                    t2++;
                }
            }
        }

        boolean t1Bigger = nums1[t1] > nums2[t2];
        while (true) {
            if (nums1[t1] == nums2[t2]) {
                return nums1[t1];
            } else if (nums1[t1] < nums2[t2]) {
                if (t1Bigger) {
                    return (nums1[t1] + nums2[t2]) / 2;
                }
                t1++;
                t2--;
            } else {
                if (!t1Bigger) {
                    return (nums1[t1] + nums2[t2]) / 2;
                }
                t1--;
                t2++;
            }
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();

        int[] nums1 = {3, 4};
        int[] nums2 = {1, 2};
        double median = s.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}