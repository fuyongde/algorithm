package com.fuyd.other;

import java.util.*;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://dev.lingkou.xyz/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/1/15 22:40
 */
public class Solution217 {

    /**
     * 哈希表法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                Integer count = countMap.get(num) + 1;
                countMap.put(num, count);
            } else {
                countMap.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希表法，其实完全不用像上面那种方式，来统计元素的 count
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * 排序法，排序之后，相等的元素必定相邻
     * 时间复杂度：O(n*log(n))，排序的时间复杂度是 O(n*log(n))，扫描的复杂度是 O(n)。整个算法主要由排序过程决定，故为 O(n*log(n))
     * 空间复杂度：O(1)
     */
    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
