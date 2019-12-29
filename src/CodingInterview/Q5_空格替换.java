package CodingInterview;

public class Q5_空格替换 {
    /**
     * @param str
     * @return
     * @author sw
     * @see 问题描述：
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.
     * 则经过替换之后的字符串为We%20Are%20Happy。
     * <p>
     * 注意一个隐含的问题：
     * 替换之后字符串会变长，如果在原字符串上进行操作，就有可能覆盖修改在该字符串后面的内存
     * 如果不在原有的字符串上进行操作，可以自己创建一个字符串，并在该字符串上进行操作
     * <p>
     * 优化：
     * 从前往后检查空格，替换时需要把后面的字符都往后移动，当检查到第二个空格时，发生替换又要将后面的字符进行移动，
     * 这里的多次移动是可以优化的，如果采用从后往前的策略（首先得计算出替换后需要的长度），可以避免多次移动的问题。
     * 类似的问题还有：
     * 有两个已排序的数组，A有足够的空间存放B，实现将B插入A。
     * 从尾到头比较A和B中的数字，并把较大的数字赋值到A中合适的位置。
     */
    public static String replaceSpace(StringBuffer str) {

        for (int i = 0; i <= str.length() - 1; i++) { //注意边界条件,<=str.length()才能保证字符串被遍历结束
            if (str.charAt(i) == ' ') { //判断字符是不是空格
                str = str.replace(i, i + 1, "%20"); //进行替换
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str1 = new StringBuffer("hello word ");
        StringBuffer str2 = new StringBuffer("We Are Happy");


        System.out.println(replaceSpace(str1));
        System.out.println(replaceSpace(str2));
    }
}
