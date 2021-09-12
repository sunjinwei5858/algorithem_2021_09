package com.sunjinwei.string;

import java.util.Stack;

/**
 * 151. 翻转字符串里的单词 【腾讯面试题】
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 * <p>
 * 说明：
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 * <p>
 * ps：
 * 1.碰到这种反转的 要想到栈
 * 2.左右指针
 */
public class ReverseWords {

    /**
     * 方法1：使用栈 时间复杂度O（n）空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        Stack<String> stack = new Stack<String>();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                ans += s.charAt(i);
                if (i == s.length() - 1 || s.charAt(i + 1) == ' ') {
                    stack.push(ans);
                    ans = "";
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
            if (!stack.isEmpty()) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 方法2：双指针
     * 思路：
     * 1.去空格 首尾+中间
     * 2.反转
     * 3.找出单词来反转
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        // 1去除首位和中间空格
        StringBuilder builder = removeEmpty(s);
        // 2反转字符串
        reverse(builder, 0, builder.length() - 1);
        // 3将里面的每个单词进行反转
        reverseStr(builder);
        return builder.toString();
    }

    private void reverseStr(StringBuilder builder) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < builder.length(); i++) {
            if (i == builder.length() - 1) {
                reverse(builder, left, right);
            }
            if (builder.charAt(i) != ' ') {
                right++;
                continue;
            }
            reverse(builder, left, right - 1);
            left = right + 1;
            right++;
        }
    }

    private void reverse(StringBuilder builder, int left, int right) {
        while (left <= right) {
            char tem = builder.charAt(left);
            builder.setCharAt(left, builder.charAt(right));
            builder.setCharAt(right, tem);
            left++;
            right--;
        }
    }

    private StringBuilder removeEmpty(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 1 去除两边空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= left && s.charAt(right) == ' ') {
            right--;
        }
        // 2去除中间空格
        StringBuilder builder = new StringBuilder();
        Boolean flag = false;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) != ' ') {
                builder.append(s.charAt(i));
                flag = false;
                continue;
            }
            if (!flag) {
                builder.append(' ');
                flag = true;
            }
        }
        return builder;
    }

    public static void main(String[] args) {
        String s = new String(" sky is blue");
        ReverseWords reverseWords = new ReverseWords();

        String words2 = reverseWords.reverseWords2(s);

        System.out.println(words2);

    }
}
