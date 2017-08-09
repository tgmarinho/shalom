package br.com.shalom.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

@Service
public class ImportacaoService {

	public void importar(InputStream file) {

		
		try {
			Workbook workbook = new HSSFWorkbook(file);
			
			//http://www.baeldung.com/spring-mvc-excel-files
			
			//http://www.baeldung.com/java-microsoft-excel
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
