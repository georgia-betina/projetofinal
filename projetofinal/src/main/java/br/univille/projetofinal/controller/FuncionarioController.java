package br.univille.projetofinal.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetofinal.entity.Funcionario;
import br.univille.projetofinal.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping()
    public ModelAndView index(){
        return new ModelAndView("funcionario/index");
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var funcionario = new Funcionario();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("funcionario",funcionario);
        return new ModelAndView("funcionario/form", dados);
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id ){
        var umFuncionario = service.findById(id);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("funcionario", umFuncionario); 
        return new ModelAndView("funcionario/form", dados);
    }

    @PostMapping("/form")
    public ModelAndView save(Funcionario funcionario){
        service.save(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("CPF") long id){
        service.delete(id);
        return new ModelAndView("redirect:/funcionarios");
    }
}