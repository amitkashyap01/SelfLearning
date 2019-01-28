package com.demo.demos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;

public class DateTimeFormatterDemo {
	public static void main(String[] args) {
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
		System.out.println(df.format(currentDate));

		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ISO_TIME;
		System.out.println(dt.format(currentTime));

		
		LocalDateTime currentDT = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println(dtf.format(currentDT));
		
		DateTimeFormatter f_long = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		System.out.println(f_long.format(currentDT));

		DateTimeFormatter s_long = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(s_long.format(currentDT));
		
		
//		String fr_long = f_long.withLocale(Locale.FRENCH).format(currentDT);
//		System.out.println(fr_long);
		
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
				.appendValue(ChronoField.MONTH_OF_YEAR)
				.appendLiteral("-")
				.appendValue(ChronoField.DAY_OF_MONTH)
				.appendLiteral("-")
				.appendValue(ChronoField.YEAR);
		
		DateTimeFormatter d = builder.toFormatter();
		System.out.println(d.format(currentDT));
	}
}
