package com.fuyd.other;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/1/16 21:29
 */
public class Solution557 {

    /**
     * 时间复杂度：O(n)，n 为字符串长度
     * 空间复杂度：O(n)
     */
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        for (int i = 0; i < array.length; i++) {
            String tmp = array[i];
            array[i] = new StringBuilder(tmp).reverse().toString();
        }
        return String.join(" ", array);
    }
}
