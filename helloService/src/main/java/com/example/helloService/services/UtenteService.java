package com.example.helloService.services;

import com.example.helloService.entities.Prodotto;
import com.example.helloService.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private ProdottoService prodottoService;

    List<Utente> users = new ArrayList<>();

    // create
    public void addUser(Utente u) {
        Optional<Utente> optionalUtente = users.stream().filter(user -> u.getId() == user.getId()).findAny();
        if (optionalUtente.isEmpty()) users.add(u);
        else throw new IllegalArgumentException("un utente con id " + u.getId() + " già esiste");
    }

    // research per id
    public Utente getUserById(int id) {
        Optional<Utente> optionalUtente =  users.stream().filter(u -> u.getId() == id).findAny();
        if (optionalUtente.isPresent()) return optionalUtente.get();
        else throw new NullPointerException("Utente non presente");
    }

    public Utente getUserById(int id, String message) {
        Optional<Utente> optionalUtente =  users.stream().filter(u -> u.getId() == id).findAny();
        if (optionalUtente.isPresent()) return optionalUtente.get();
        else throw new NullPointerException(message);
    }

    // get di tutti gli utenti
    public List<Utente> getAllUsers() {
        return users;
    }

    // update del nome utente
    public void updateUser(int id, String new_name) {
        Optional<Utente> optionalUtente =  users.stream().filter(u -> u.getId() == id).findAny();
        if (optionalUtente.isPresent()) {
            optionalUtente.get().setName(new_name);
        }
        else throw new NullPointerException("Utente non presente per l'update");
    }

    // delete per id
    public void deleteUserById(int id) {
        Optional<Utente> optionalUtente =  users.stream().filter(u -> u.getId() == id).findAny();
        if (optionalUtente.isPresent()) {
            users.remove(optionalUtente.get());
        }
        else throw new IllegalArgumentException("un utente con id " + id + " non esiste. Come lo cancello?");
    }


    public void addToCarrello( int id,  int id_p) {
        Utente u = getUserById(id, "un utente con id " + id + " non esiste. Come aggiungo al carrello?");
        Prodotto p = prodottoService.getProductById(id_p);
        u.getCarrello().add(p);
    }

    public void removeFromCarrello(int id_utente, int id_prodotto) {
        Utente u = getUserById(id_utente, "un utente con id " + id_utente + " non esiste. Come aggiungo al carrello?");
        Optional<Prodotto> optionalProdotto = u.getCarrello().stream().filter(p -> p.getId() == id_prodotto).findAny();
        if (optionalProdotto.isPresent()) u.getCarrello().remove(optionalProdotto.get());
        else throw new IllegalArgumentException("Prodotto non presente nel carrello!");
    }

    public List<Prodotto> visualizza_carrello(int id) {
        Utente u = getUserById(id, "un utente con id " + id + " non esiste. Come visualizzo il carrello?");
        return u.getCarrello();
    }

    public double prezzoTotCarrello(int id) {
        Utente u = getUserById(id, "un utente con id " + id + " non esiste. Come posso fare il checkout?");
        return u.getCarrello().stream().map(Prodotto::getPrice).reduce(0.0, Double::sum);
    }

}
