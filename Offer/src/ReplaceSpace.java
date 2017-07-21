
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
    	String aString = str.toString();
    	aString = aString.replaceAll(" ", "%20");
		return aString;
    }
	
	public String replaceSpace2(StringBuffer str) {
		int length = str.length();
		for (int i = 0; i < length; i++) {
			if (' ' == str.charAt(i)) {
				str.deleteCharAt(i);
				str.insert(i, "%20");
				i += 2;
				length += 2;
			}
		}
		return str.toString();
	}
}
