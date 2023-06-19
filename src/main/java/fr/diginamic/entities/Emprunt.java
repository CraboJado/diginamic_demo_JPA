package fr.diginamic.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "DATE_DEBUT")
    private LocalDate dateDebut;

    private Integer delai;
    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    @ManyToMany(mappedBy = "emprunts")
    private Set<Livre> livres;

    public Emprunt() {
    }

    public Emprunt(LocalDate dateDebut, Integer delai, LocalDate dateFin) {
        this.dateDebut = dateDebut;
        this.delai = delai;
        this.dateFin = dateFin;
    }

    public Emprunt(LocalDate dateDebut, Integer delai, LocalDate dateFin, Client client, Set<Livre> livres) {
        this.dateDebut = dateDebut;
        this.delai = delai;
        this.dateFin = dateFin;
        this.client = client;
        this.livres = livres;
    }

    public Emprunt(Integer id, LocalDate dateDebut, Integer delai, LocalDate dateFin, Client client, Set<Livre> livres) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.delai = delai;
        this.dateFin = dateFin;
        this.client = client;
        this.livres = livres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }


    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", delai=" + delai +
                ", dateFin=" + dateFin +
                '}';
    }
}
