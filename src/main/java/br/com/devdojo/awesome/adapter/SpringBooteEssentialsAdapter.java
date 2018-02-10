package br.com.devdojo.awesome.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class SpringBooteEssentialsAdapter extends WebMvcConfigurerAdapter{

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
        //Quando não passamos argumentos para difinir a paginação no Lado Client,
        //Essa é o metodo que defini quantas páginas devemos enviar ao cliente, o padrão do Spring é de 20 Páginas
        phmar.setFallbackPageable(new PageRequest(0,5)); //Páginação de 5 Elementos por Página
        argumentResolvers.add(phmar);
    }


}
