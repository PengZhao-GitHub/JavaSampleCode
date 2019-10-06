
public class MyTestEvent extends java.util.EventObject {
	protected String str;

	MyTestEvent(String s)  {
		super("Hello");
		str = s;
	}

	public String getStr() {
		return( str);
	}

}