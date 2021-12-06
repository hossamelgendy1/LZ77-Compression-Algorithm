import java.util.ArrayList;

public class Main {

	public static ArrayList<Tag> encode(String s) {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		boolean isRepeated;
		String sub, pSub;
		int startK; // the start index of the repeated substring in search window, used to get position of the tag.
		for (int i = 0; i < s.length(); i++) {// i -> start index of sub
			startK = i;
			for (int j = i + 1; j <= s.length(); j++) {// j -> end index of sub
				//create substring to search for.
				sub = s.substring(i, j);
				isRepeated = false;
				//loop over the search window
				for (int k = i - sub.length(); k >= 0; k--) {// k -> start index of pSub
					pSub = s.substring(k, k + sub.length());
					if (sub.equals(pSub)) {
						isRepeated = true;
						startK = k;
						break;
					}
				}
				//create a tag in case the substring is not repeated, else continue and increment j
				//unless we reached the end of the string, create a tag with nextChar = null.
				if (!isRepeated) {
					tags.add(new Tag(i - startK, sub.length() - 1, s.charAt(i + sub.length() - 1)));
					i += sub.length() - 1;
					break;
				} else if (j == s.length()) {
					tags.add(new Tag(i - startK, sub.length(), '0'));
					i += sub.length() - 1;
					break;
				}
			}

		}
		return tags;

	}

	public static String decode(ArrayList<Tag> tags) {
		String s = new String();
		for (int i = 0; i < tags.size(); i++) {
			int tagp = tags.get(i).getPosition();
			int tagl = tags.get(i).getLength();
			char tagchar = tags.get(i).getNextChar();
			if (tagp == 0 && tagl == 0) {
				s += tagchar;
			} else {
				s += s.substring(s.length() - tagp, s.length() - tagp + tagl);
				if (tagchar != '0') {
					s += tagchar;
				}
			}

		}
		return s;
	}

	public static void main(String[] args) {
		String s = "ABAABABAABBBB";
		System.out.println(encode(s));
		System.out.println(decode(encode(s)));

	}

}
