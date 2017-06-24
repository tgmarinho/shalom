package br.com.shalom.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.shalom.model.Membro;

@Component
public class MembroValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Membro.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "", "O Nome é obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "situacao", "", "A Situação é Obrigatório");
		ValidationUtils.rejectIfEmpty(errors, "sexo", "", "O Sexo é Obrigatório");
	}
	
}