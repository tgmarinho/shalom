package br.com.shalom.controller.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class StringToLocalDateConverter implements Converter<String, LocalDate> {
	
	@Override
	public LocalDate convert(String data) {
		if(!StringUtils.isEmpty(data) && data.length() == 10){
			final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return LocalDate.parse(data, formatter);
		}
		
		return null;
	
	}
}
