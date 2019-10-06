import java.io.*;

class fileread {
	public static void main(String args[]) throws IOException
	{
		int i;
		FileInputStream fin;

		try {
			fin = new FileInputStream(args[0]);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			return;
		}

		do {
			i = fin.read();
			System.out.println(i);
		} while (i != -1);
	

		fin.close();
	}
}