package com.sky.algorithm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: GeneralUtils
 * @Author Administrator
 * @Date 2020/5/1
 * @Version 1.0
 */
public class GeneralUtils {
    private static String[] alphabetAndInteger = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    public GeneralUtils() {
    }

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 100; ++i) {
            System.out.println(getRandomString());
        }

    }

    public static String getRandomString() {
        Random random = new Random();

        int length;
        for(length = random.nextInt(alphabetAndInteger.length); length == 0; length = random.nextInt(alphabetAndInteger.length)) {
        }

        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            stringBuffer.append(alphabetAndInteger[random.nextInt(alphabetAndInteger.length)]);
        }

        return stringBuffer.toString();
    }

    public static Date string2Date(String dateStr, String format) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateStr);
    }

    public static String mapToStringByKey(Map<String, Object> resultMap, String mapKey) {
        if (resultMap == null) {
            return null;
        } else {
            Object obj = resultMap.get(mapKey);
            return null != obj ? obj.toString() : null;
        }
    }

    public static String ifNullString(String str) {
        return str != null && str.trim().length() != 0 && !str.equals("null") && !str.equals("NULL") ? str : null;
    }

    public static double string2Int(String msg) {
        boolean var1 = false;

        int result;
        try {
            result = Integer.parseInt(msg);
        } catch (Exception var3) {
            result = 0;
            return (double)result;
        }

        return (double)result;
    }

    public static double string2double(String msg) {
        double result = 0.0D;

        try {
            result = Double.parseDouble(msg);
            return result;
        } catch (Exception var4) {
            result = 0.0D;
            return result;
        }
    }

    public static double ifNullDouble(Double d) {
        return d == null ? 0.0D : d;
    }

    public static int ifNullInteger(Integer i) {
        return i == null ? 0 : i;
    }

    public static long ifNullLong(Long l) {
        return l == null ? 0L : l;
    }

    public static boolean isNotEmpty(Object obj) {
        if (obj instanceof String) {
            String str = (String)obj;
            return str != null && str.trim().length() > 0;
        } else if (!(obj instanceof List)) {
            return obj != null;
        } else {
            List listTmp = (List)obj;
            return listTmp != null && listTmp.size() > 0;
        }
    }

    public static boolean isNotEmpty(List listTmp) {
        return listTmp != null && listTmp.size() > 0;
    }

    public static boolean isEmpty(List listTmp) {
        return listTmp == null || listTmp.size() == 0;
    }

    public static boolean isNotEmptyOr(Object... objects) {
        if (objects == null) {
            return false;
        } else {
            Object[] var1 = objects;
            int var2 = objects.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Object objectTmp = var1[var3];
                if (isNotEmpty(objectTmp)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isNotEmptyAnd(Object... objs) {
        if (objs != null && objs.length >= 1) {
            for(int i = 0; i < objs.length; ++i) {
                if (isEmpty(objs[i])) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public static boolean isSame(String str1, String str2) {
        if (!isEmptyOr(str1, str2)) {
            return str1.equals(str2);
        } else {
            return str1 == null && str2 == null;
        }
    }

    public static boolean isSame(Object o1, Object o2) {
        if (!isEmptyOr(o1, o2)) {
            return Objects.equals(o1, o2);
        } else {
            return o1 == null && o2 == null;
        }
    }

    public static boolean isBlank(Object obj) {
        return isEmpty(obj);
    }

    public static boolean isNotBlank(Object obj) {
        return isNotEmpty(obj);
    }

    public static boolean isEmpty(Object obj) {
        if (obj instanceof String) {
            String str = (String)obj;
            return str == null || str.trim().length() == 0;
        } else if (!(obj instanceof List)) {
            return obj == null;
        } else {
            List listTmp = (List)obj;
            return listTmp == null || listTmp.size() == 0;
        }
    }

    public static boolean isEmptyAnd(Object... objs) {
        if (objs != null && objs.length >= 1) {
            int emptyCount = 0;

            for(int i = 0; i < objs.length; ++i) {
                if (isEmpty(objs[i])) {
                    ++emptyCount;
                }
            }

            return emptyCount == objs.length;
        } else {
            return true;
        }
    }

    public static boolean isEmptyOr(Object... objs) {
        if (objs != null && objs.length >= 1) {
            for(int i = 0; i < objs.length; ++i) {
                if (isEmpty(objs[i])) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }

    public static boolean isNumber(String str) {
        if (isEmpty((Object)str)) {
            return false;
        } else {
            char[] chars = str.toCharArray();
            int sz = chars.length;
            boolean hasExp = false;
            boolean hasDecPoint = false;
            boolean allowSigns = false;
            boolean foundDigit = false;
            int start = chars[0] == '-' ? 1 : 0;
            int i;
            if (sz > start + 1 && chars[start] == '0') {
                if (chars[start + 1] == 'x' || chars[start + 1] == 'X') {
                    i = start + 2;
                    if (i == sz) {
                        return false;
                    }

                    while(i < chars.length) {
                        if ((chars[i] < '0' || chars[i] > '9') && (chars[i] < 'a' || chars[i] > 'f') && (chars[i] < 'A' || chars[i] > 'F')) {
                            return false;
                        }

                        ++i;
                    }

                    return true;
                }

                if (Character.isDigit(chars[start + 1])) {
                    for(i = start + 1; i < chars.length; ++i) {
                        if (chars[i] < '0' || chars[i] > '7') {
                            return false;
                        }
                    }

                    return true;
                }
            }

            --sz;

            for(i = start; i < sz || i < sz + 1 && allowSigns && !foundDigit; ++i) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    foundDigit = true;
                    allowSigns = false;
                } else if (chars[i] == '.') {
                    if (hasDecPoint || hasExp) {
                        return false;
                    }

                    hasDecPoint = true;
                } else if (chars[i] != 'e' && chars[i] != 'E') {
                    if (chars[i] != '+' && chars[i] != '-') {
                        return false;
                    }

                    if (!allowSigns) {
                        return false;
                    }

                    allowSigns = false;
                    foundDigit = false;
                } else {
                    if (hasExp) {
                        return false;
                    }

                    if (!foundDigit) {
                        return false;
                    }

                    hasExp = true;
                    allowSigns = true;
                }
            }

            if (i < chars.length) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    return true;
                } else if (chars[i] != 'e' && chars[i] != 'E') {
                    if (chars[i] == '.') {
                        return !hasDecPoint && !hasExp ? foundDigit : false;
                    } else if (!allowSigns && (chars[i] == 'd' || chars[i] == 'D' || chars[i] == 'f' || chars[i] == 'F')) {
                        return foundDigit;
                    } else if (chars[i] != 'l' && chars[i] != 'L') {
                        return false;
                    } else {
                        return foundDigit && !hasExp && !hasDecPoint;
                    }
                } else {
                    return false;
                }
            } else {
                return !allowSigns && foundDigit;
            }
        }
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        return m.matches();
    }
}
