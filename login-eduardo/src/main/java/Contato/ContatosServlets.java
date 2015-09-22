package Contato;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.StartDocument;

@WebServlet(urlPatterns = "/contatos")
public class ContatosServlets extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String contato = req.getParameter("Contato");
		String telefone = req.getParameter("Telefone");
		String x = leitura(contato,telefone);
		PrintWriter writer = resp.getWriter();
		
		
		if (contato  != null && telefone != null ) {
			
			writer.write(x);
		} else {
			writer.write("Erro, falta de parametros");
		}
	}
	
	
	private  String leitura(String contato,String telefone) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css'>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class='container'>");
		sb.append("<div class='panel panel-default'>");
		sb.append("<div class='panel-heading'>");
		sb.append("<h3 class='panel-title'>Novo Contato</h3>");
		sb.append("</div>");
		sb.append("<div class='panel-body'>");
		
		
	
		Path path = Paths.get("C:/Users/Delfino/Documents/Texto/contatos.txt");//Escreve as linha na pasta especificada
		List<String>Lista = new ArrayList<>();
		
		sb.append("Contato:"+contato);sb.append("<br>");
		sb.append("Telefone:"+telefone);sb.append("<br>");	
		
		                Lista.add(""  +contato+  ";"  +telefone+  "");	                
		
		              
		
		Files.write(path,Lista,Charset.defaultCharset(), StandardOpenOption.APPEND);
		
		
		sb.append("<h1>Lista de Contatos</h1>");sb.append("<br>");	
		
		
		
		
		Path pat = Paths.get("C:/Users/Delfino/Documents/Texto/contatos.txt");//Abre o caminho especificado
		List<String> readAllLines = Files.readAllLines(pat,Charset.defaultCharset());
		
		
		for(String linha:readAllLines){
			
			System.out.println(linha);
			
			sb.append(linha);
			sb.append("<br>");
		}
		
		
		sb.append("<br>");		
		sb.append("");
		sb.append("</div>");
		sb.append("<div class='panel-footer'>");
		sb.append("<a class='btn btn-default' href='index2.html' role='button'>Adicionar contatos</a>");
		sb.append("<a class='btn btn-default' href='index3.html' role='button'>Excluir Contatos</a>");
		sb.append("<a class='btn btn-default' href='index.html' role='button'>Inicio</a>");

		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
		
	
	}

	
}
