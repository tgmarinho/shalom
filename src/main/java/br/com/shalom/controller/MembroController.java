package br.com.shalom.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.shalom.controller.validator.MembroValidator;
import br.com.shalom.model.Membro;
import br.com.shalom.model.Meses;
import br.com.shalom.model.Situacao;
import br.com.shalom.page.PageWrapper;
import br.com.shalom.repository.Membros;
import br.com.shalom.repository.filter.MembroAniversarianteFilter;
import br.com.shalom.repository.filter.MembroFilter;
import br.com.shalom.service.MembroService;
import br.com.shalom.service.StatusMembro;

@Controller
@RequestMapping("/membros")
public class MembroController {

	private static String MEMBRO_CADASTRAR = "membros/CadastrarMembro";
	private static String MEMBRO_PESQUISAR = "membros/PesquisarMembro";
	private static String MEMBRO_ANIVERSARIANTE = "membros/Aniversariantes";
	private static String REDIRECT_MEMBRO_VIEW = "redirect:/membros/novo";
	
	@Autowired
	private MembroService membroService;
	
	@Autowired
	private Membros membros;
	
	@Autowired
	private MembroValidator membroValidator;

	@InitBinder("membro")
	public void inicializarValidador(WebDataBinder binder) {
		binder.setValidator(membroValidator);
	}
	
	
	@RequestMapping("/novo")
	public ModelAndView novo(Membro membro){
		ModelAndView mv = new ModelAndView(MEMBRO_CADASTRAR);
		mv.addObject("situacao", Situacao.values());
		return mv;
	}
	
	
	@PostMapping(value="/novo")
	public ModelAndView salvar(Membro membro, BindingResult result, RedirectAttributes attributes) {
		membroValidator.validate(membro, result);
		if (result.hasErrors()) {
			return novo(membro);
		}
		membroService.salvar(membro);
		attributes.addFlashAttribute("mensagem", "Dados salvos com sucesso");
		return new ModelAndView(REDIRECT_MEMBRO_VIEW);
	}
	

	@GetMapping
	public ModelAndView pesquisar(MembroFilter membroFilter, BindingResult result, @PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView(MEMBRO_PESQUISAR);
		
		mv.addObject("situacao", Situacao.values());
		mv.addObject("meses", Meses.values());
		
		PageWrapper<Membro> paginaWrapper = new PageWrapper<>(membros.filtrar(membroFilter, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable("id") Membro membro) {
		ModelAndView mv = novo(membro);
		mv.addObject(membro);
		return mv;
	}
	
	
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		try {
			membroService.excluir(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping("/status")
	@ResponseStatus(HttpStatus.OK)
	public void atualizarStatus(@RequestParam("ids[]") Long[] codigos, @RequestParam("status") StatusMembro statusMembro) {
		membroService.alterarStatus(codigos, statusMembro);
	}
	
	
	
	@GetMapping("/aniversariantes")
	public ModelAndView aniversariantes(MembroFilter membroFilter, BindingResult result, @PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView(MEMBRO_ANIVERSARIANTE);
		
		mv.addObject("situacao", Situacao.values());
		mv.addObject("meses", Meses.values());
		
		PageWrapper<Membro> paginaWrapper = new PageWrapper<>(membros.filtrarAniversariantes(membroFilter, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
	
}
