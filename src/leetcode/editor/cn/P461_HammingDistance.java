//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算 
// 👍 353 👎 0

package leetcode.editor.cn;

public class P461_HammingDistance {
    public static void main(String[] args) {
        Solution solution = new P461_HammingDistance().new Solution();
        System.out.println(solution.hammingDistance(1, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 即求x、y异或得到的二进制数中含 1 的个数 count
         * 怎么求一个数2进制形式下 1 的个数？
         *  把该数当作被除数对2取整和取余，直到
         *  再把商作为被除数重复上一步；同时若余数为1，则 count 加 1；
         *
         * while(num!=0)
         *  q = num/2;
         *  r = num%2;
         *  r=1 则 count加 1
         *  num = q;
         *
         * @param x
         * @param y
         * @return
         */
        public int hammingDistance(int x, int y) {
            int dis = count(x ^ y);
            return dis;
        }

        /**
         * num & (num-1) 时，最后边的 1 被消除为 0;
         * @param num
         * @return
         */
        public int count(int num) {
            int count = 0;
            while (num != 0) {
                count += 1;
                num = num & (num - 1);
            }
            return count;
        }

        /**
         * Integer的bitCount函数
         * @param num
         * @return
         */
        /*public int count(int num) {
            return Integer.bitCount(num);
        }*/

        /**
         * 优化 对2取整改为右移，对2取余改为 &1
         * @param num
         * @return
         */
        /*public int count(int num) {
            int count = 0;
            while (num != 0) {
                count += num & 1;
                num = num >> 1;
            }
            return count;
        }*/

        /**
         * 1、4
         * 0001
         * 0100
         * 0101 = 5
         * 5/2=2...1
         * 2/2=1...0
         *
         * 1111 = 15
         * 15/2=7...1
         * 7/2=3...1
         * 3/2=1...1
         * 1/2 =0...1
         * @param num
         * @return
         */
       /* public int count(int num) {
            int count = 0;
            while (num != 0) {
                int q = num / 2;
                int r = num % 2;
                count += r;
                num = q;
            }
            return count;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

