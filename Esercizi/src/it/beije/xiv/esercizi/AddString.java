
public class AddString {
	public static String[] addString(String s, String[]a) {
		String[]b = new String[a.length+1];
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];
		}
		for(int i=a.length;i<b.length;i++) {
			b[i]=s;
		}
		return b;
	}
	public static void main(String[]args) {
		String[]a = {"lupo","gatto","topo","leone"};
		String s = "cane";
		String[]b = addString(s,a);
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i]);
		}
		}
		
}
