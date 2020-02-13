package com.fuyd.other;

import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *  
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/2/13 19:57
 */
public class Solution387 {

    /**
     * 采用 Hash 表，实现线性时间复杂度解法。
     * 时间复杂度： O(N)，只遍历了两遍字符串，同时散列表中查找操作是常数时间复杂度的。
     * 空间复杂度： O(N)，用到了散列表来存储字符串中每个元素出现的次数。
     * 思考：题目中注意事项可以假定改字符串只包含小写字母，如果字符串长度大于26的话，计数数组不用整个字符串的长度那么长，
     * 只要26个和小写字母个数一样就行了，第二次遍历的时候，最多遍历26个
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>(32);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
