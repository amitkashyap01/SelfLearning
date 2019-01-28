package com.demo.demos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;
import java.util.function.Predicate;

public class ZonedDateTimeDemo {
	public static void main(String[] args) {
		DateTimeFormatter formatter= DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		
		//Default is current time zone
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println(formatter.format(currentTime));
		
		//GMT+0 timezone
		ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT+0"));
		System.out.println(formatter.format(gmt));
		
		//To find our all the available ZoneIds
		Set<String> listOfTimeZones = ZoneId.getAvailableZoneIds();
		
		Predicate<String> pred = tz -> tz.contains("Kol");
		
		listOfTimeZones
			.stream()
			.filter(pred)
			.forEach(z -> System.out.println(z));
		
		
		//To get the specific timezone time
		ZonedDateTime kolkata = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(formatter.format(kolkata));
	}
}
