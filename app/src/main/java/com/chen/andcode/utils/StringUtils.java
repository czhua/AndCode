package com.chen.andcode.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Utils
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2011-7-22
 */
public class StringUtils {

	/**
	 * 是否是空 is null or its length is 0 or it is made by space
	 * <p>
	 * 
	 * <pre>
	 * isBlank(null) = true;
	 * isBlank(&quot;&quot;) = true;
	 * isBlank(&quot;  &quot;) = true;
	 * isBlank(&quot;a&quot;) = false;
	 * isBlank(&quot;a &quot;) = false;
	 * isBlank(&quot; a&quot;) = false;
	 * isBlank(&quot;a b&quot;) = false;
	 * </pre>
	 * 
	 * @param str
	 * @return if string is null or its size is 0 or it is made by space, return
	 *         true, else return false.
	 */
	public static boolean isBlank(String str) {
		return (str == null || str.trim().length() == 0);
	}
	
	/**
	 *  去掉空格
	 * @Title: trimSpace
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param str
	 * @return    设定文件
	 * @return String    返回类型
	 * @author 陈泽华
	 * @throws
	 */
	public static String trimSpace(String str) {
		if(!isEmpty(str)) {
			return str.replaceAll(" ", "");
		}
		return "";
	}

	public static String hideMidString(String str) {
		if (!isEmpty(str)) {
			if (str.length() >= 3) {
				String pre_string = str.substring(0, 3);
				String end_string = str.substring(str.length() - 3,
						str.length());
				return pre_string + "***" + end_string;
			} else {
				return str + "***" + str;
			}
		} else {
			return "";
		}
	}

	/**
	 * 隐藏手机号码
	 * @author zehua_chen
	 * create at 2016/11/18 11:53
	 */
	public static String hidePhoneMidString(String str) {
		if (!isEmpty(str)) {
			if (str.length() >= 4) {
				String pre_string = str.substring(0, 3);
				String end_string = str.substring(str.length() - 4);
				return pre_string + "****" + end_string;
			} else {
				return str + "****" + str;
			}
		} else {
			return "";
		}
	}

	/**
	 * 身份证的隐藏
	 * 
	 * @Title: hideIdCardMidString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param str
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String hideIdCardMidString(String str) {
		if (!isEmpty(str)) {
			String pre_string = str.substring(0, 3);
			String end_string = str.substring(str.length() - 3, str.length());
			StringBuffer sBuffer = new StringBuffer();
			for (int i = 0; i < str.length() - 6; i++) {
				sBuffer.append("*");
			}
			return pre_string + sBuffer + end_string;
		} else {
			return "";
		}
	}

	/**
	 * 银行卡号的隐藏
	 * 
	 * @Title: hidecardMidString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param str
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String hidecardMidString(String str) {
		if (!isEmpty(str)) {
			String pre_string = str.substring(0, 4);
			String end_string = str.substring(str.length() - 4, str.length());
			return pre_string + " **** **** " + end_string;
		} else {
			return "";
		}
	}

	/**
	 * is null or its length is 0
	 * <p>
	 * 
	 * <pre>
	 * isEmpty(null) = true;
	 * isEmpty(&quot;&quot;) = true;
	 * isEmpty(&quot;  &quot;) = false;
	 * </pre>
	 * 
	 * @param str
	 * @return if string is null or its size is 0, return true, else return
	 *         false.
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.length() == 0);
	}

	/**
	 * compare two string
	 * 
	 * @param actual
	 * @param expected
	 * @return
	 * @see ObjectUtils#isEquals(Object, Object)
	 */
	public static boolean isEquals(String actual, String expected) {
		return ObjectUtils.isEquals(actual, expected);
	}

	/**
	 * null string to empty string
	 * <p>
	 * 
	 * <pre>
	 * nullStrToEmpty(null) = &quot;&quot;;
	 * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
	 * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
	 * </pre>
	 * 
	 * @param str
	 * @return
	 */
	public static String nullStrToEmpty(String str) {
		return (str == null ? "" : str);
	}

	/**
	 * capitalize first letter
	 * <p>
	 * 
	 * <pre>
	 * capitalizeFirstLetter(null)     =   null;
	 * capitalizeFirstLetter("")       =   "";
	 * capitalizeFirstLetter("2ab")    =   "2ab"
	 * capitalizeFirstLetter("a")      =   "A"
	 * capitalizeFirstLetter("ab")     =   "Ab"
	 * capitalizeFirstLetter("Abc")    =   "Abc"
	 * </pre>
	 * 
	 * @param str
	 * @return
	 */
	public static String capitalizeFirstLetter(String str) {
		if (isEmpty(str)) {
			return str;
		}

		char c = str.charAt(0);
		return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str
				: new StringBuilder(str.length())
						.append(Character.toUpperCase(c))
						.append(str.substring(1)).toString();
	}

	/**
	 * encoded in utf-8
	 * <p>
	 * 
	 * <pre>
	 * utf8Encode(null)        =   null
	 * utf8Encode("")          =   "";
	 * utf8Encode("aa")        =   "aa";
	 * utf8Encode("啊啊啊啊")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
	 * </pre>
	 * 
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 *             if an error occurs
	 */
	public static String utf8Encode(String str) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(
						"UnsupportedEncodingException occurred. ", e);
			}
		}
		return str;
	}

	/**
	 * encoded in utf-8, if exception, return defultReturn
	 * 
	 * @param str
	 * @param defultReturn
	 * @return
	 */
	public static String utf8Encode(String str, String defultReturn) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return defultReturn;
			}
		}
		return str;
	}

	/**
	 * get innerHtml from href
	 * <p>
	 * 
	 * <pre>
	 * getHrefInnerHtml(null)                                  = ""
	 * getHrefInnerHtml("")                                    = ""
	 * getHrefInnerHtml("mp3")                                 = "mp3";
	 * getHrefInnerHtml("&lt;a innerHtml&lt;/a&gt;")                    = "&lt;a innerHtml&lt;/a&gt;";
	 * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
	 * getHrefInnerHtml("&lt;a&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
	 * getHrefInnerHtml("&lt;a href="baidu.com"&gt;innerHtml&lt;/a&gt;")               = "innerHtml";
	 * getHrefInnerHtml("&lt;a href="baidu.com" title="baidu"&gt;innerHtml&lt;/a&gt;") = "innerHtml";
	 * getHrefInnerHtml("   &lt;a&gt;innerHtml&lt;/a&gt;  ")                           = "innerHtml";
	 * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                      = "innerHtml";
	 * getHrefInnerHtml("jack&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                  = "innerHtml";
	 * getHrefInnerHtml("&lt;a&gt;innerHtml1&lt;/a&gt;&lt;a&gt;innerHtml2&lt;/a&gt;")        = "innerHtml2";
	 * </pre>
	 * 
	 * @param href
	 * @return <ul>
	 *         <li>if href is null, return ""</li> <li>if not match regx, return
	 *         source</li> <li>return the last string that match regx</li>
	 *         </ul>
	 */
	public static String getHrefInnerHtml(String href) {
		if (isEmpty(href)) {
			return "";
		}

		String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
		Pattern hrefPattern = Pattern
				.compile(hrefReg, Pattern.CASE_INSENSITIVE);
		Matcher hrefMatcher = hrefPattern.matcher(href);
		if (hrefMatcher.matches()) {
			return hrefMatcher.group(1);
		}
		return href;
	}

/**
     * process special char in html
     * <p>
     * <pre>
     * htmlEscapeCharsToString(null) = null;
     * htmlEscapeCharsToString("") = "";
     * htmlEscapeCharsToString("mp3") = "mp3";
     * htmlEscapeCharsToString("mp3&lt;") = "mp3<";
     * htmlEscapeCharsToString("mp3&gt;") = "mp3\>";
     * htmlEscapeCharsToString("mp3&amp;mp4") = "mp3&mp4";
     * htmlEscapeCharsToString("mp3&quot;mp4") = "mp3\"mp4";
     * htmlEscapeCharsToString("mp3&lt;&gt;&amp;&quot;mp4") = "mp3\<\>&\"mp4";
     * </pre>
     *
     * @param source
     * @return
     */
	public static String htmlEscapeCharsToString(String source) {
		return StringUtils.isEmpty(source) ? source : source
				.replaceAll("&lt;", "<").replaceAll("&gt;", ">")
				.replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
	}

	/**
	 * transform half width char to full width char
	 * <p>
	 * 
	 * <pre>
	 * fullWidthToHalfWidth(null) = null;
	 * fullWidthToHalfWidth("") = "";
	 * fullWidthToHalfWidth(new String(new char[] {12288})) = " ";
	 * fullWidthToHalfWidth("！＂＃＄％＆) = "!\"#$%&";
	 * </pre>
	 * 
	 * @param s
	 * @return
	 */
	public static String fullWidthToHalfWidth(String s) {
		if (isEmpty(s)) {
			return s;
		}

		char[] source = s.toCharArray();
		for (int i = 0; i < source.length; i++) {
			if (source[i] == 12288) {
				source[i] = ' ';
				// } else if (source[i] == 12290) {
				// source[i] = '.';
			} else if (source[i] >= 65281 && source[i] <= 65374) {
				source[i] = (char) (source[i] - 65248);
			} else {
				source[i] = source[i];
			}
		}
		return new String(source);
	}

	/**
	 * transform full width char to half width char
	 * <p>
	 * 
	 * <pre>
	 * halfWidthToFullWidth(null) = null;
	 * halfWidthToFullWidth("") = "";
	 * halfWidthToFullWidth(" ") = new String(new char[] {12288});
	 * halfWidthToFullWidth("!\"#$%&) = "！＂＃＄％＆";
	 * </pre>
	 * 
	 * @param s
	 * @return
	 */
	public static String halfWidthToFullWidth(String s) {
		if (isEmpty(s)) {
			return s;
		}

		char[] source = s.toCharArray();
		for (int i = 0; i < source.length; i++) {
			if (source[i] == ' ') {
				source[i] = (char) 12288;
				// } else if (source[i] == '.') {
				// source[i] = (char)12290;
			} else if (source[i] >= 33 && source[i] <= 126) {
				source[i] = (char) (source[i] + 65248);
			} else {
				source[i] = source[i];
			}
		}
		return new String(source);
	}

	/**
	 * 在傳進來的字符串中间加 "—"
	 * 
	 * @param s
	 * @return
	 */
	public static String formatString(String s) {
		if (isEmpty(s)) {
			return s;
		}
		StringBuffer str = new StringBuffer(s);
		if (s.length() == 6) {
			String strInsert = "-";
			str.insert(4, strInsert);
		} else if (s.length() == 8) {
			String strInsert = "-";
			str.insert(4, strInsert);
			str.insert(7, strInsert);
		}
		return str.toString();
	}

	/**
	 * 将字符串大于len长度的字符截掉
	 * 
	 * @param s
	 * @param len
	 * @return
	 */
	public static String subString(String s, int len) {
		if (isEmpty(s) || s.length() < len) {
			return s;
		}
		String str = s.substring(0, len - 1);

		return str + "...";
	}
	
	/**
	 *  显示效果为 陈**
	 * @Title: subNameString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param name
	 * @return    设定文件
	 * @return String    返回类型
	 * @author 陈泽华
	 * @throws
	 */
	public static String subNameString(String name) {
		return name !=null && name.length() > 0 ? name.charAt(0) + "**" : "";
	}
	
	/**
	 *  显示效果为  158****1234
	 * @Title: subPhoneString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param phone
	 * @return    设定文件
	 * @return String    返回类型
	 * @author 陈泽华
	 * @throws
	 */
	public static String subPhoneString(String phone) {
		return phone == null && phone.length() > 3 ? "" : phone.substring(0, 3) + "****" + phone.substring(phone.length()-4);
	}
}
