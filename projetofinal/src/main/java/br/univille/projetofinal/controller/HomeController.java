package br.univille.projetofinal.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import br.univille.projetofinal.service.ProdutoService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProdutoService service;
    @GetMapping({"/home",""})
    public ModelAndView index(){
        HashMap<String,Object> dados = new HashMap<>();
        var listaProdutos = service.findTop5ByOrderByDataInclusaoAsc();
        var listaTodosProdutos = service.getAll();
        dados.put("produtosNovidades", listaProdutos);
        dados.put("produtos", listaTodosProdutos);
        return new ModelAndView("home/index", dados);
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("home/login");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session){
        session.removeAttribute("tipo");
        return new ModelAndView("redirect:/");
    }
}

