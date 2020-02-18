package com.fuyd.other;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/2/18
 */
public class Solution121 {

    /**
     * 暴力穷举
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > 0) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    /**
     * 一次遍历，动态规划的思想
     * 先找到一个最小谷底的然后继续找最大的峰值，这期间如果找到比之前找到的谷底更小的值，那么就更换谷底的值，
     * 然后再找最高的峰值，然后比较差值是否比之前的大，如果大就替换不然就找类似的进行判断
     *
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public int maxProfit2(int[] prices) {
        int max = 0, minprice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > max) {
                max = prices[i] - minprice;
            }
        }
        return max;
    }
}
