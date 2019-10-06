import sun.misc.BASE64Decoder;

public class decode{
	public static void main(String args[]) throws Exception{
		BASE64Decoder decoder = new BASE64Decoder();
		String userInfo = "UGVuZyBaaGFvOjEyMzQ1";
		String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
		System.out.println(nameAndPassword);
	}
}