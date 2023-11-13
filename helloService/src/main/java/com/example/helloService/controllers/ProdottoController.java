package com.example.helloService.controllers;

import com.example.helloService.entities.Prodotto;
import com.example.helloService.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    @PostMapping("/create")
    public void addProduct(@RequestBody Prodotto p) {
        prodottoService.addProduct(p);
    }

    @GetMapping("/{id}")
    public Prodotto getProductById(@PathVariable int id) {
        return prodottoService.getProductById(id);
    }

    @GetMapping("/all")
    public List<Prodotto> getAllProducts() {
        return prodottoService.getProducts();
    }

    @PutMapping("/update")
    public void updateProduct(@RequestParam int id, @RequestParam double new_price) {
        prodottoService.updatePriceProduct(id, new_price);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        prodottoService.deleteProductById(id);
    }

}
