package br.univille.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetofinal.entity.Fornecedor;
import br.univille.projetofinal.service.FornecedorService;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController{
    @Autowired
    private FornecedorService service;

    @GetMapping
    public ModelAndView index(){
        var listaFornecedores = service.getAll();
        return new ModelAndView("fornecedor/index", "listaFornecedores", listaFornecedores);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var novoFornecedor = new Fornecedor(); 
        return new ModelAndView("fornecedor/form", "fornecedor", novoFornecedor);
    }

}