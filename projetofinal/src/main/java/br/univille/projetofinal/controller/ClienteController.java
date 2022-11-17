 package br.univille.projetofinal.controller;


import java.util.HashMap;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
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
}

