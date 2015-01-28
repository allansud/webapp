package allanfreitas.webapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import allanfreitas.webapp.dao.DAOPermissaoUsuario;
import allanfreitas.webapp.dao.UsuarioDAO;
import allanfreitas.webapp.model.Usuario;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	@Qualifier(value = "permissaoDao")
	private DAOPermissaoUsuario daoPermissaoUsuario;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		List<Usuario> listarUsuaro = usuarioDAO.listar();
		ModelAndView model = new ModelAndView("home");
		model.addObject("listaUsuario", listarUsuaro);
		return model;
	}
	
	@RequestMapping(value = "/registro")
	public String registro(Map<String, Object> model){
		if(model.get("usuario") == null){
			Usuario usuario = new Usuario();
			model.put("usuario", usuario);
		}
		return "registro";
	}
	
	@RequestMapping(value = "/executarRegistro", method = RequestMethod.POST)
	public String executarRegistro(@Valid Usuario usuario, BindingResult bindingResult, HttpSession session){
		
		if(bindingResult.hasErrors()){
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("usuario", usuario);
			return registro(model);
		}
		
		if(usuarioDAO.verificaUsuario(usuario.getEmail())){
			usuarioDAO.salvar(usuario);
			daoPermissaoUsuario.addRole("ROLE_MEMBRO", usuario);
			session.setAttribute("usuario", usuario);
		}
		return "redirect:/";
	} 
}
