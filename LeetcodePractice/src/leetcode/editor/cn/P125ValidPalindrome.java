//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串

package leetcode.editor.cn;
//java:验证回文串
public class P125ValidPalindrome{
    public static void main(String[] args){
        Solution solution = new P125ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        //TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        //高层次（主干）
        //1.filter out number or char 2.reverse and compare

        String filer = _filterNumberAndChar(s);
        String reversedStr = _reverseString(filer);
        return filer.equalsIgnoreCase(reversedStr);
        
    }

    private String _reverseString(String filer) {
        return new StringBuilder(filer).reverse().toString();
    }

    private String _filterNumberAndChar(String s) {
        return s.replaceAll("[^A-Za-z0-9]","");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}