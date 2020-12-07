package spring.boot.admin.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.boot.admin.app.infraestructure.IAccountDao;
import spring.boot.admin.app.model.LoginAccount;
import spring.boot.admin.app.model.ProductRegister;
import spring.boot.admin.app.model.RegistrerAccount;

@Controller
public class AccountController 
{
@Autowired
	
	IAccountDao accountDao;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String account(Model model) {
		
		LoginAccount usuario = new LoginAccount();
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Login de Acceso");
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("usuario") LoginAccount usuario, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("titulo", "Login de Acceso");
			return "Login";
		}
		//if(accountDao.AccountValidate(usuario)) 
		//{
			return "redirect:listar";
		//}
		//else 
		//{
		//	return"login";
		//}
	}
	
	
	@RequestMapping(value="/registro", method=RequestMethod.GET)
	public String registro(Map<String, Object> model) {
		
		RegistrerAccount register = new RegistrerAccount();
		model.put("registro", register);
		model.put("titulo", "Registrar datos");
		
		return "registro";
	}
	
	@RequestMapping(value="/registro", method=RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("registro") RegistrerAccount register, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("titulo", "Formulario cliente");
			return "registro";
		}
		 accountDao.saveRegister(register);
		return "redirect:login";
	}
	
	@RequestMapping(value="/registrar/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model)
	{
		RegistrerAccount register = null;
		if(id > 0)
		{
			register = accountDao.findById(id);
		}
		else 
		{ 
			return "redirect:/listar";
		}
		model.addAttribute("registro", register);
		model.addAttribute("Titulo", "Editar cuenta de usuario");
		
		return "registro";
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {

		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", accountDao.findAll());
		
		return "listar";
	}
	
	
	//Producto
		
	@RequestMapping(value="/listarPro", method=RequestMethod.GET)
	public String listarPro(Model model) 
	{
		model.addAttribute("titulo", "Listado de Articulos");
		model.addAttribute("Productos", accountDao.findAllPro());
		return "listarPro";
	}
	
	@RequestMapping(value="/registrarP/{id}")
	public String editarPro(@PathVariable(value="id") Long id, Model model)
	{
		ProductRegister register = null;
		if(id > 0)
		{
			register = accountDao.findByIdPro(id);
		}
		else 
		{ 
			return "redirect:/listarPro";
		}
		model.addAttribute("registroP", register);
		model.addAttribute("Titulo", "Editar cuenta de usuario");
		
		return "registroP";
	}
	
	@RequestMapping(value="/registroP", method=RequestMethod.POST)
	public String guardarP(@Valid @ModelAttribute("registroP") ProductRegister register, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("titulo", "Formulario Producto");
			return "registroP";
		}
		 accountDao.saveRegisterPro(register);
		 return "redirect:listarPro";
	}
	
	@RequestMapping(value="/registroP", method=RequestMethod.GET)
	public String registroP(Map<String, Object> model) {
		
		ProductRegister register = new ProductRegister();
		model.put("registroP", register);
		model.put("titulo", "Registrar datos");
		
		return "registroP";
	}
	
	@GetMapping("/eliminarP/{id}")
	public String delete(Model model, @PathVariable Long id) {
		accountDao.delete(id);
		return "redirect:/listarPro";
	}
}
