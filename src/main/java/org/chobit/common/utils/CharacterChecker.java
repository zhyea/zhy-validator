package org.chobit.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/**
 * 字符校验检查类
 *
 * @author robin
 */
public final class CharacterChecker {


    /**
     * 使用UnicodeBlock方法判断是否存在汉字， 标点符号不做判断
     *
     * @param str 待校验字符串
     * @return true 包含中文， false 不包含中文
     */
    public static boolean containsChineseByGbkCharset(String str) throws UnsupportedEncodingException {
        if (null == str || str.length() == 0) {
            return false;
        }
        return str.length() != str.getBytes("GBK").length;
    }

    /**
     * 中文字符区间
     */
    private static final Pattern PATTERN_CHINESE_RANGE = Pattern.compile("[\\u4e00-\\u9fa5]+");

    /**
     * 使用Unicode编码范围来判断是否存在汉字， 标点符号不做判断
     *
     * @param str 字符串
     * @return true 包含中文， false 不包含中文
     */
    public static boolean containsChineseByUnicodeRange(String str) {
        if (null == str || str.length() == 0) {
            return false;
        }
        return PATTERN_CHINESE_RANGE.matcher(str.trim()).find();
    }


    /**
     * 根据UnicodeBlock方法判断中文标点符号
     *
     * @param unicodeCodePoint Unicode codePoint 值
     * @return true 是中文符号，false 不是中文符号
     */
    private static boolean isChinesePunctuation(int unicodeCodePoint) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(unicodeCodePoint);
        return ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS;
    }


    /**
     * 使用UnicodeScript方法判断是否存在中文字符， 标点符号不做判断
     *
     * @param unicodeCodePoint Unicode codePoint 值
     * @return true 是中文， false 不是中文
     */
    private static boolean isChineseByScript(int unicodeCodePoint) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(unicodeCodePoint);
        return sc == Character.UnicodeScript.HAN;
    }


    /**
     * 是否包含汉字字符
     *
     * @param str 待校验字符串
     * @return true 包含， false 不包含
     */
    public static boolean containsChinese(final String str) {
        return containsChinese(str, false);
    }


    /**
     * 是否包含汉字字符
     *
     * @param str              待校验字符串
     * @param checkPunctuation 是否检查标点符号
     * @return true 包含， false 不包含
     */
    public static boolean containsChinese(final String str, boolean checkPunctuation) {
        if (null == str || str.length() == 0) {
            return false;
        }

        for (int i = 0; i < str.length(); ) {
            final int codepoint = str.codePointAt(i);
            i += Character.charCount(codepoint);
            if (isChineseByScript(codepoint)) {
                return true;
            }

            if (checkPunctuation && isChinesePunctuation(codepoint)) {
                return true;
            }
        }

        return false;
    }


    /**
     * 判断字符串中是不是只有中文，不包含标点符号
     *
     * @param str 要校验的字符串
     * @return true 全部都是中文， false 含有非中文字符
     */
    public static boolean isChineseOnly(final String str) {
        return isChineseOnly(str, false);
    }


    /**
     * 判断字符串中是不是只有中文
     * <p>
     * 当允许有标点符号时，要求标点符号也是中文
     *
     * @param str              要校验的字符串
     * @param allowPunctuation 是否允许有标点符号
     * @return true 全部都是中文， false 含有非中文字符
     */
    public static boolean isChineseOnly(final String str, boolean allowPunctuation) {
        if (null == str || str.length() == 0) {
            return false;
        }

        for (int i = 0; i < str.length(); ) {
            final int codepoint = str.codePointAt(i);
            i += Character.charCount(codepoint);

            // 是中文字符，继续迭代判断
            if (isChineseByScript(codepoint)) {
                continue;
            }
            // 允许有中文标点，且是中文标点，继续迭代判断
            if (allowPunctuation && isChinesePunctuation(codepoint)) {
                continue;
            }
            // 都不是，返回结果
            return false;
        }

        return true;
    }


    /**
     * 是否包含emoji字符
     *
     * @param str 待校验字符串
     * @return true 包含emoji字符， false 不包含emoji字符
     */
    public static boolean containsEmoji(String str) {
        if (null == str || str.length() == 1) {
            return false;
        }

        int len = str.length();

        for (int i = 0; i < len; ) {
            final int codePoint = str.codePointAt(i);
            i += Character.charCount(codePoint);
            boolean contains = isEmojiCharacter(codePoint);
            if (contains) {
                return true;
            }
        }

        return false;
    }


    /**
     * 判断是否是emoji字符
     *
     * @param codePoint Unicode codePoint 值
     * @return true 是， false 不是
     */
    private static boolean isEmojiCharacter(int codePoint) {
        return (0x0080 <= codePoint && codePoint <= 0x02AF) ||
                (0x0300 <= codePoint && codePoint <= 0x03FF) ||
                (0x0600 <= codePoint && codePoint <= 0x06FF) ||
                (0x0C00 <= codePoint && codePoint <= 0x0C7F) ||
                (0x1DC0 <= codePoint && codePoint <= 0x1DFF) ||
                (0x1E00 <= codePoint && codePoint <= 0x1EFF) ||
                (0x2000 <= codePoint && codePoint <= 0x209F) ||
                (0x20D0 <= codePoint && codePoint <= 0x214F) ||
                (0x2190 <= codePoint && codePoint <= 0x23FF) ||
                (0x2460 <= codePoint && codePoint <= 0x25FF) ||
                (0x2600 <= codePoint && codePoint <= 0x27EF) ||
                (0x2900 <= codePoint && codePoint <= 0x29FF) ||
                (0x2B00 <= codePoint && codePoint <= 0x2BFF) ||
                (0x2C60 <= codePoint && codePoint <= 0x2C7F) ||
                (0x2E00 <= codePoint && codePoint <= 0x2E7F) ||
                (0xA490 <= codePoint && codePoint <= 0xA4CF) ||
                (0xE000 <= codePoint && codePoint <= 0xF8FF) ||
                (0xFE00 <= codePoint && codePoint <= 0xFE0F) ||
                (0xFE30 <= codePoint && codePoint <= 0xFE4F) ||
                (0x1F000 <= codePoint && codePoint <= 0x1F02F) ||
                (0x1F0A0 <= codePoint && codePoint <= 0x1F0FF) ||
                (0x1F100 <= codePoint && codePoint <= 0x1F64F) ||
                (0x1F680 <= codePoint && codePoint <= 0x1F6FF) ||
                (0x1F910 <= codePoint && codePoint <= 0x1F96B) ||
                (0x1F980 <= codePoint && codePoint <= 0x1F9E0);
    }


    private CharacterChecker() {
    }

}
