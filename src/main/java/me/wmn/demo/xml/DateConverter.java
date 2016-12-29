package me.wmn.demo.xml;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter{
	
	private Locale locale;
	
	public DateConverter(Locale locale){
		this.locale = locale;
	}

	@Override
	public boolean canConvert(Class arg0) {
		return Date.class.isAssignableFrom(arg0);
	}

	@Override
	public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.DATE_FIELD, this.locale);
		arg1.setValue(formatter.format(arg0));
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
		GregorianCalendar calendar = new GregorianCalendar();
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.DATE_FIELD, this.locale);
		
		try {
			calendar.setTime(formatter.parse(arg0.getValue()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar.getGregorianChange();
		
	}

}
