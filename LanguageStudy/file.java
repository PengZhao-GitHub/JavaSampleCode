import java.io.*;

class file {
	public static void main(String args[]) throws IOException
	{
		int i;
		FileOutputStream fout;

		try {
			fout= new FileOutputStream(args[0]);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error Opening Output File");
			return;
		}

		try {
		    i = -1;
		    fout.write(i);
		    i = -2;
		    fout.write(i);
		}
		catch (IOException e) {
			System.out.println("File error");
		}

		fout.close();
	}
}
		
			