class ExecDemo {
	public static void main (String args[]) {
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		try {
			p = r.exec("notepad");
			p.waitFor();
			System.out.println("Exit value: " + p.exitValue());
		} catch (Exception e) {
			System.out.println("Error executing notepad");
		}
	}
}
		