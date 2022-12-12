package br.univille.projetofinal.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        var listaFornecedores = service.getAll();
        var fornecedor = new Fornecedor(); 
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("fornecedor", fornecedor);
        dados.put("fornecedores",listaFornecedores);
        return new ModelAndView("fornecedor/form", dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umFornecedor = service.findById(id);
        //var listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("fornecedor", umFornecedor);
        //dados.put("listaProdutos", listaProdutos); 
        return new ModelAndView("fornecedor/edit",dados);
    }

    @PutMapping("/form")
    public ModelAndView alteraFornecedor(@PathVariable("id") long id, Fornecedor fornecedor){
        service.save(fornecedor);
        return new ModelAndView("redirect:/fornecedores/novo");
    }

    @PostMapping("/form")
    public ModelAndView save(Fornecedor fornecedor){
        service.save(fornecedor);
        return new ModelAndView("redirect:/fornecedores/novo");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String login, @RequestParam String senha, HttpSession session){
        List<Fornecedor> fornecedores = service.findByLoginAndSenha(login, senha);
        if (fornecedores.isEmpty()){
            return new ModelAndView("redirect:/login");
        }
        session.setMaxInactiveInterval(60*60*24);
        session.setAttribute("tipo", "fornecedor");
        session.setAttribute("id",fornecedores.get(0).getId());
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/fornecedores/novo");
    }
}