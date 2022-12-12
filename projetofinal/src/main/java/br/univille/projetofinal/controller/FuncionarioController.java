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
        var listaFuncionarios = service.getAll();
        var funcionario = new Funcionario();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("funcionario",funcionario);
        dados.put("funcionarios",listaFuncionarios);
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
    public void save(Funcionario funcionario){
        service.save(funcionario);
        //return new ModelAndView("funcionario/form");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String login, @RequestParam String senha, HttpSession session){
        List<Funcionario> funcionarios = service.findByLoginAndSenha(login, senha);
        System.out.println(funcionarios);
        if (funcionarios.isEmpty()){
            return new ModelAndView("redirect:/login");
        }
        session.setMaxInactiveInterval(60);
        session.setAttribute("tipo", "funcionario");
        return new ModelAndView("redirect:/home");
    }        

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/funcionarios/novo");
    }
}