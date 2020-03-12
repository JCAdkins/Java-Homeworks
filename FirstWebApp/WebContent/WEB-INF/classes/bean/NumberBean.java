package bean;

import java.text.DateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class NumberBean{
	
	private DateFormat timeFormatter;
	
	public NumberBean()
	{
		timeFormatter = DateFormat.getTimeInstance();
	}
	
	public String getTime()
	{
		Date time = new Date();
		String timeString = timeFormatter.format(time);
		return timeString;
		
	}
	
}