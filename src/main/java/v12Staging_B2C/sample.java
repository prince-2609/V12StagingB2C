package v12Staging_B2C;

public class sample 
{
	public static String data(int z,int h)
	{
		int a = z;
		int b = h;
		int c = a+b;
		System.out.println(c);
		String zz = "Shubham";
		System.out.println(zz);
		return zz;
	}
	
	public static void main(String[] args) 
	{
		String s1="welcome";
		String s2=" quadlabs family ";
		System.out.println(s1.charAt(3));;
		System.out.println(s1.concat(s2));;
		System.out.println(s1.contains("wel"));
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.indexOf("l"));
		System.out.println(s1.lastIndexOf(s1));
		System.out.println(s1.length());
		System.out.println(s1.replace('e', 'c'));
		System.out.println(s1.startsWith(s2, 'w'));
		System.out.println(s1.substring(0, 3));
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		System.out.println(s2.toString());
		System.out.println(s2.trim());
		System.out.println(s2.split(""));
		
		
		
	//	data(30,40);
	}
}


