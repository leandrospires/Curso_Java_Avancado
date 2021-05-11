package br.com.projetogestao.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import br.com.projetogestao.models.Usuario;
import br.com.projetogestao.utilities.Utils;

@WebListener
public class AplicacaoListener implements 
				ServletContextListener,
				HttpSessionListener,
				HttpSessionAttributeListener,
				ServletRequestAttributeListener {


    public AplicacaoListener() { }

    public void sessionCreated(HttpSessionEvent se)  {
    	Utils.gerarLog("Sessão Criada: " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    	Utils.gerarLog("Sessão Encerrada: "  + se.getSession().getId());
    }    
    
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	
    	if (srae.getServletRequest().getAttributeNames().hasMoreElements()) {
    		String atr = (String)srae.getServletRequest().getAttributeNames().nextElement();
    		Utils.gerarLog("Atributo removido ao request: " + atr);
    	} else {
    		Utils.gerarLog("Atributo removido request");
    	}    	
    	
    }

    public void contextDestroyed(ServletContextEvent sce)  {
    	Utils.gerarLog("Aplicação Finalizada");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	if (srae.getServletRequest().getAttributeNames().hasMoreElements()) {
    		String atr = (String)srae.getServletRequest().getAttributeNames().nextElement();
    		Utils.gerarLog("Atributo adicionado ao request: " + atr);
    	} else {
    		Utils.gerarLog("Atributo adicionado request");
    	}
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    }

    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	if (event.getSession().getAttributeNames().hasMoreElements()) {
        	String atr = (String)event.getSession().getAttributeNames().nextElement();
        	Usuario usu = (Usuario) event.getSession().getAttribute(atr);
        	
        	Utils.gerarLog("Atributo adicionado à sessão: " + atr
        			+ ", valor: " + usu.getNome() );    		
    	} else {
    		Utils.gerarLog("Atributo adicionado sessão");
    	}
    	

    }

    public void attributeRemoved(HttpSessionBindingEvent event)  {
    	if (event.getSession().getAttributeNames().hasMoreElements()) {
        	String atr = (String)event.getSession().getAttributeNames().nextElement();
        	Utils.gerarLog("Atributo removido à sessão: " + atr);    		
    	} else {
    		Utils.gerarLog("Atributo removido sessão");
    	}   	
    	
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	String atr = (String)event.getSession().getAttributeNames().nextElement();
    	
    	Utils.gerarLog("Atributo substituído da sessão: " + atr);     	
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	Utils.gerarLog("Aplicação iniciada");
    }
	
}
