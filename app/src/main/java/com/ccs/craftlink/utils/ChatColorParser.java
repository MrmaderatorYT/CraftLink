package com.ccs.craftlink.utils;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

import java.util.HashMap;
import java.util.Map;

public class ChatColorParser {

    private static final Map<Character, Integer> COLOR_MAP = new HashMap<>();

    static {
        COLOR_MAP.put('0', Color.parseColor("#000000")); // Black
        COLOR_MAP.put('1', Color.parseColor("#0000AA")); // Dark Blue
        COLOR_MAP.put('2', Color.parseColor("#00AA00")); // Dark Green
        COLOR_MAP.put('3', Color.parseColor("#00AAAA")); // Dark Aqua
        COLOR_MAP.put('4', Color.parseColor("#AA0000")); // Dark Red
        COLOR_MAP.put('5', Color.parseColor("#AA00AA")); // Dark Purple
        COLOR_MAP.put('6', Color.parseColor("#FFAA00")); // Gold
        COLOR_MAP.put('7', Color.parseColor("#AAAAAA")); // Gray
        COLOR_MAP.put('8', Color.parseColor("#555555")); // Dark Gray
        COLOR_MAP.put('9', Color.parseColor("#5555FF")); // Blue
        COLOR_MAP.put('a', Color.parseColor("#55FF55")); // Green
        COLOR_MAP.put('b', Color.parseColor("#55FFFF")); // Aqua
        COLOR_MAP.put('c', Color.parseColor("#FF5555")); // Red
        COLOR_MAP.put('d', Color.parseColor("#FF55FF")); // Light Purple
        COLOR_MAP.put('e', Color.parseColor("#FFFF55")); // Yellow
        COLOR_MAP.put('f', Color.parseColor("#FFFFFF")); // White
    }

    public static CharSequence parseLegacy(String text) {
        if (text == null) return "";

        SpannableStringBuilder builder = new SpannableStringBuilder();
        int length = text.length();

        Integer currentColor = null;
        boolean bold = false;
        boolean italic = false;
        boolean underline = false;
        boolean strikethrough = false;

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (c == '§' && i + 1 < length) {
                char code = Character.toLowerCase(text.charAt(i + 1));
                if (COLOR_MAP.containsKey(code)) {
                    currentColor = COLOR_MAP.get(code);
                    bold = false;
                    italic = false;
                    underline = false;
                    strikethrough = false;
                } else {
                    switch (code) {
                        case 'l': bold = true; break;
                        case 'o': italic = true; break;
                        case 'n': underline = true; break;
                        case 'm': strikethrough = true; break;
                        case 'r':
                            currentColor = null;
                            bold = false;
                            italic = false;
                            underline = false;
                            strikethrough = false;
                            break;
                    }
                }
                i++; // Skip the code character
            } else {
                int start = builder.length();
                builder.append(c);

                if (currentColor != null) {
                    builder.setSpan(new ForegroundColorSpan(currentColor), start, start + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                if (bold && italic) {
                    builder.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), start, start + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else if (bold) {
                    builder.setSpan(new StyleSpan(Typeface.BOLD), start, start + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else if (italic) {
                    builder.setSpan(new StyleSpan(Typeface.ITALIC), start, start + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                if (underline) {
                    builder.setSpan(new UnderlineSpan(), start, start + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                if (strikethrough) {
                    builder.setSpan(new StrikethroughSpan(), start, start + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }

        return builder;
    }
}
