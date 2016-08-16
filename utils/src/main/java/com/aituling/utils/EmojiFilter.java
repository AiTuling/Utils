package com.aituling.utils;

/**
 * 用于表情筛选
 */
public class EmojiFilter {

    /**
     * 过滤emoji 或者 其他非文字类型的字符
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        source=string2Unicode(source);
        source=unicode2String(source);
        return source;
    }

    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));

        }

        return unicode.toString();
    }


    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {
            LogUtil.d("s", "" + hex[i]);
            if (!(hex[i].startsWith("e"))){
              // 转换出每一个代码点
                int data = Integer.parseInt(hex[i], 16);
                // 把对应的字符转成string
                string.append((char) data);
            }
        }
        return string.toString();
    }
}
