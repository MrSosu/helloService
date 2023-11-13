package com.example.helloService.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utente {

    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private List<Prodotto> carrello = new ArrayList<>();

    public Utente(int id, String name, String surname, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Prodotto> getCarrello() {
        return carrello;
    }

    public void setCarrello(List<Prodotto> carrello) {
        this.carrello = carrello;
    }
}
