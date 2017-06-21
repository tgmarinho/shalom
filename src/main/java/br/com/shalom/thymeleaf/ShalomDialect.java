package br.com.shalom.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.com.shalom.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.com.shalom.thymeleaf.processor.MenuAttributeTagProcessor;
import br.com.shalom.thymeleaf.processor.MessageElementTagProcessor;
import br.com.shalom.thymeleaf.processor.OrderElementTagProcessor;
import br.com.shalom.thymeleaf.processor.PaginationElementTagProcessor;

public class ShalomDialect extends AbstractProcessorDialect {

	public ShalomDialect() {
		super("Avivamento Shalom", "shalom", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new OrderElementTagProcessor(dialectPrefix));
		processadores.add(new PaginationElementTagProcessor(dialectPrefix));
		processadores.add(new MenuAttributeTagProcessor(dialectPrefix));
		return processadores;
	}

}
