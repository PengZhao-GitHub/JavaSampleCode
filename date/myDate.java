
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class myDate{
    public static void main(String args[]){
	Calendar rightNow = Calendar.getInstance();
	rightNow.add(Calendar.DATE, 7);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dt = sdf.format(rightNow.getTime());
	System.out.println(dt);

    }
}