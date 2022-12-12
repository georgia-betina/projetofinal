package br.univille.projetofinal.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetofinal.entity.Fornecedor;
import br.univille.projetofinal.entity.Produto;
import br.univille.projetofinal.service.ProdutoService;
import br.univille.projetofinal.util.ImageUtility;

@Controller
@RequestMapping("/produtos")
public class ProdutoController{
    @Autowired
    private ProdutoService service;
    @GetMapping
    public ModelAndView index(){
        var listaProdutos = service.getAll();
        return new ModelAndView("produto/index","listaProdutos", listaProdutos); 
    }
    @GetMapping("/novo")
    public ModelAndView novo(HttpSession session){
        var produto = new Produto();
        List<Produto> listaProdutos = service.findByFornecedorId((long) session.getAttribute("id"));
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("produto",produto);
        dados.put("produtos",listaProdutos);
        return new ModelAndView("produto/form",dados);
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umProduto = service.findById(id);
        return new ModelAndView("produtos/form", "produto", umProduto);
    }
    @PutMapping()
    public ModelAndView alteraProduto(@PathVariable("id") long id, Produto produto){
        service.save(produto);
        return new ModelAndView("redirect:/produtos/novo");
    }
    @PostMapping("/form")
    public ModelAndView save(Produto produto, @RequestParam MultipartFile imagemfile, HttpSession session){
        try {
            produto.setImagem(ImageUtility.compressImage(imagemfile.getBytes()));
            produto.setImagemTipo(imagemfile.getContentType());
        } catch (IOException e) {
            System.out.println(e);
            return new ModelAndView("redirect:/produtos/novo");
        }
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId((long)session.getAttribute("id"));
        produto.setFornecedor(fornecedor);
        service.save(produto);
        return new ModelAndView("redirect:/produtos/novo");
    }
    
    @GetMapping("/imagem/{id}")
    public ResponseEntity<byte[]> imagem(@PathVariable("id") long id){
        Produto produto = service.findById(id);
        return ResponseEntity
            .ok()
            .contentType(MediaType.valueOf(produto.getImagemTipo()))
            .body(ImageUtility.decompressImage(produto.getImagem()));
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/produtos/novo");
    }
}