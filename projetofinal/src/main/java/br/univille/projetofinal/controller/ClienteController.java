 package br.univille.projetofinal.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetofinal.entity.Cliente;
import br.univille.projetofinal.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){
        var listaClientes = service.getAll();
        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente",cliente);
        return new ModelAndView("cliente/form", dados);
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id ){
        var umCliente = service.findById(id);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("cliente", umCliente); 
        return new ModelAndView("cliente/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Cliente cliente){
        service.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }
    
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String login, @RequestParam String senha, HttpSession session){
        List<Cliente> clientes = service.findByLoginAndSenha(login, senha);
        System.out.println(clientes);
        if (clientes.isEmpty()){
            return new ModelAndView("redirect:/login");
        }
        session.setMaxInactiveInterval(60*60*24);
        session.setAttribute("tipo", "cliente");
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("CPF") long id){
        service.delete(id);
        return new ModelAndView("redirect:/clientes");
    }
}

