package br.com.shalom.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import br.com.shalom.service.ImportacaoService;

@Controller
@RequestMapping("/importacao")
public class ImportacaoController {

	private static String IMPORTACAO = "importacao/Importacao";
	
	private static String REDIRECT_IMPORTACAO_VIEW = "redirect:/importacao/nova";
	
	
	@Autowired
	ImportacaoService importacaoService;
	
	@RequestMapping("/nova")
	public String nova() {
		return IMPORTACAO;
	}
	
	@RequestMapping("/importar")
    public ResponseEntity importar(MultipartFile file) {
    	
		
//		try {
//            Iterator<String> itr = request.getFileNames();
//
//            while (itr.hasNext()) {
//                String uploadedFile = itr.next();
//                MultipartFile file = request.getFile(uploadedFile);
//                String mimeType = file.getContentType();
//                String filename = file.getOriginalFilename();
//                System.out.println(file.getOriginalFilename());
//                byte[] bytes = file.getBytes();
//                System.out.println("Passando por aqui");
//                importacaoService.importar(bytes);
//                
                

//                FileUpload newFile = new FileUpload(filename, bytes, mimeType);

//                fileUploadService.uploadFile(newFile);
//            }
//        }
//        catch (Exception e) {
//            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    	
		
		 	InputStream in;
			try {
				in = file.getInputStream();
				importacaoService.importar(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    	 return new ResponseEntity<>("{}", HttpStatus.OK);
    
    }

}


class Importacao {

	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
}
