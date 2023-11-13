package com.example.helloService.services;

import com.example.helloService.entities.Prodotto;
import com.example.helloService.entities.Utente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {

    List<Prodotto> products = new ArrayList<>();

    // create
    public void addProduct(Prodotto p) {
        Optional<Prodotto> optionalProdotto = products.stream().filter(prodotto -> p.getId() == prodotto.getId()).findAny();
        if (optionalProdotto.isEmpty()) products.add(p);
        else throw new IllegalArgumentException("un prodotto con id " + p.getId() + " già esiste");
    }

    public Prodotto getProductById(int id) {
        Optional<Prodotto> optionalProdotto =  products.stream().filter(p -> p.getId() == id).findAny();
        if (optionalProdotto.isPresent()) return optionalProdotto.get();
        else throw new NullPointerException("Prodotto non presente");
    }

    public List<Prodotto> getProducts() {
        return products;
    }

    public void updatePriceProduct(int id, double new_price) {
        if (new_price < 0) throw new IllegalArgumentException("prezzo non può essere negativo");
        Optional<Prodotto> optionalProdotto =  products.stream().filter(p -> p.getId() == id).findAny();
        if (optionalProdotto.isPresent()) {
            optionalProdotto.get().setPrice(new_price);
        }
        else throw new NullPointerException("Prodotto non presente");
    }

    public void deleteProductById(int id) {
        Optional<Prodotto> optionalProdotto =  products.stream().filter(p -> p.getId() == id).findAny();
        if (optionalProdotto.isPresent()) {
            products.remove(optionalProdotto.get());
        }
        else throw new IllegalArgumentException("un prodotto con id " + id + " non esiste. Come lo cancello?");
    }

}
