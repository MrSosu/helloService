package com.example.helloService.controllers;

import com.example.helloService.entities.Prodotto;
import com.example.helloService.entities.Utente;
import com.example.helloService.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/create")
    public void addUtente(@RequestBody Utente u) {
        utenteService.addUser(u);
    }

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable int id) {
        return utenteService.getUserById(id);
    }

    @GetMapping("/all")
    public List<Utente> getAllUsers() {
        return utenteService.getAllUsers();
    }

    @PutMapping("/update")
    public void updateName(@RequestParam int id, @RequestParam String new_name) {
        utenteService.updateUser(id, new_name);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        utenteService.deleteUserById(id);
    }

    /**
     * Questo metodo richiama il service per aggiungere un prodotto
     * al carrello dell'utente
     */

    @PutMapping("/chart/{id_u}/{id_p}")
    public void addToCarrello(@PathVariable int id_u, @PathVariable int id_p) {
        utenteService.addToCarrello(id_u, id_p);
    }

    @DeleteMapping("/chart")
    public void removeFromCarrello(@RequestParam int id_u, @RequestParam int id_p) {
        utenteService.removeFromCarrello(id_u, id_p);
    }

    @GetMapping("/chart/{id}")
    public List<Prodotto> getCarrello(@PathVariable int id) {
        return utenteService.visualizza_carrello(id);
    }

    @GetMapping("/chart/price/{id}")
    public double getTotPriceCarrello(@PathVariable int id) {
        return utenteService.prezzoTotCarrello(id);
    }

}
