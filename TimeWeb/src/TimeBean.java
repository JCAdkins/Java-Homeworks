

import java.text.DateFormat;
import java.util.*;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped

public class TimeBean
{

	private DateFormat timeFormatter;

	// Initializes the formatter
	public TimeBean()
	{
		timeFormatter = DateFormat.getTimeInstance();
	}

	/* Read-only time property
	 @return the formatted line
	*/
	public String getTime()
	{
		Date time = new Date();
		String timeString = timeFormatter.format(time);
		return timeString;
	}

}
