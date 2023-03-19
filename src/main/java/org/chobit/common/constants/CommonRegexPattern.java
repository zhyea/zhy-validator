package org.chobit.common.constants;

import java.util.regex.Pattern;

/**
 * 常用正则表达式
 * <p>
 * 配合 {@link org.chobit.common.validation.CommonPattern} 注解一起使用
 *
 * @author robin
 */
public enum CommonRegexPattern {

    /**
     * 邮箱地址
     */
    EMAIL("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"),

    /**
     * URL地址
     */
    URL("(ht|f)tp(s?)\\:\\/\\/[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*(:(0-9)*)*(\\/?)([a-zA-Z0-9\\-\\.\\?\\,\\'\\/\\\\&%\\+\\$#_=]*)?"),

    /**
     * 手机号
     */
    PHONE("^(0|86|17951)?(13[0-9]|15[012356789]|166|17[3678]|18[0-9]|14[57])[0-9]{8}$"),

    /**
     * 身份证号
     */
    ID_CARD("^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$"),

    /**
     * 日期
     */
    DATE("^\\d{4}-\\d{2}-\\d{2}$"),

    /**
     * 邮编
     */
    ZIP_CODE("^[0-9]\\d{5}(?!\\d)$"),

    /**
     * 中英文姓名
     */
    NAME_CN_EN("^[ \\w\\-\u4e00-\u9fa5\uFF21-\uFF3A\uFF41-\uFF5A]+$"),


    /**
     * 通用中文标点
     * <p>
     * 匹配这些中文标点符号: 。 ？ ！ ， 、 ； ： “ ” ‘ ' （ ） 《 》 〈 〉 【 】 『 』 「 」 ﹃ ﹄ 〔 〕 … — ～ ﹏ ￥
     */
    COMMON_CHINESE_PUNCTUATION("^[\\u3002|\\uff1f|\\uff01|\\uff0c|\\u3001|\\uff1b|\\uff1a|\\u201c|\\u201d|\\u2018|\\u2019|\\uff08|\\uff09|\\u300a|\\u300b|\\u3008|\\u3009|\\u3010|\\u3011|\\u300e|\\u300f|\\u300c|\\u300d|\\ufe43|\\ufe44|\\u3014|\\u3015|\\u2026|\\u2014|\\uff5e|\\ufe4f|\\uffe5]+$"),


    /**
     * 中文文书标题通用字符
     * <p>
     * 包括：中文、中文字符、英文、数字
     */
    COMMON_CHINESE_DOC_TITLE("^[\\w\\d\\-\u4e00-\u9fa5\uFF21-\uFF3A\uFF41-\uFF5A\\u3002|\\uff1f|\\uff01|\\uff0c|\\u3001|\\uff1b|\\uff1a|\\u201c|\\u201d|\\u2018|\\u2019|\\uff08|\\uff09|\\u300a|\\u300b|\\u3008|\\u3009|\\u3010|\\u3011|\\u300e|\\u300f|\\u300c|\\u300d|\\ufe43|\\ufe44|\\u3014|\\u3015|\\u2026|\\u2014|\\uff5e|\\ufe4f|\\uffe5]+$"),


    ;



    public final String regex;

    public final Pattern pattern;

    CommonRegexPattern(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }


}
