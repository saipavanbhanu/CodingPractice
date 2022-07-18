package leetcode.graph.dfs;

public class DecodeString394 {
	class Solution {
		static class Data {
			String str;
			int index;

			Data(String s, int i) {
				str = s;
				index = i;
			}
		}

		public String decodeString(String s) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == '[') {
					Data obj = dfs(i, s);
					sb.append(obj.str);
					i = obj.index;
				} else if (ch == ']') {
					// nothing to do
					continue;
				} else if (ch >= 97 && ch <= 122) {
					// lowercase alphabet
					sb.append(ch);
				} else {
					// number
					continue;
				}
			}
			return sb.toString();
		}

		Data dfs(int startIndex, String s) {
			StringBuilder sb = new StringBuilder();
			for (int i = startIndex + 1; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == '[') {
					Data obj = dfs(i, s);
					sb.append(obj.str);
					i = obj.index;
				} else if (ch == ']') {
					int times = 0;
					int ten = 1;
					int numIndex = startIndex - 1;
					while (numIndex >= 0 && s.charAt(numIndex) - '0' >= 0 && s.charAt(numIndex) - '0' <= 9) {
						times = times + ten * (s.charAt(numIndex) - '0');
						ten = ten * 10;
						numIndex--;
					}

					// read number
					String string = sb.toString();
					times--;
					while (times > 0) {
						sb.append(string);
						times--;
					}
					return new Data(sb.toString(), i);
				} else if (ch >= 97 && ch <= 122) {
					// lowercase alphabet
					sb.append(ch);
				} else {
					// number
					continue;
				}
			}
			return new Data("", s.length());
		}

	}
}
