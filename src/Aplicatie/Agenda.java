package Aplicatie;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Agenda {
private String nume;
private String email;
private String numartelefon;
private LocalDate ziuanasterii;

    public Agenda(String nume, String email, String numartelefon, LocalDate ziuanasterii) {
        this.nume = nume;
        this.email = email;
        this.numartelefon = numartelefon;
        this.ziuanasterii = ziuanasterii;
    }
    public Agenda(String nume, String email, String numartelefon, String ziuanasterii) {
        this.nume = nume;
        this.email = email;
        this.numartelefon = numartelefon;
        this.setziuanasterii(ziuanasterii);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumartelefon() {
        return numartelefon;
    }

    public void setNumartelefon(String numartelefon) {
        this.numartelefon = numartelefon;
    }

    public LocalDate getZiuanasterii() {
        return ziuanasterii;
    }

    public void setZiuanasterii(LocalDate ziuanasterii) {
        this.ziuanasterii = ziuanasterii;
    }
    public void setziuanasterii(String ziuanasterii){
        this.ziuanasterii = LocalDate.parse(ziuanasterii, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public int getAge(){
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.ziuanasterii,today);
        return period.getYears();
    }
}
