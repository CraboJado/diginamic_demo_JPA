package fr.diginamic.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "LIVRE")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "TITRE")
    private String title;

    @Column(name = "AUTEUR")
    private String authord;
    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns = @JoinColumn(name="ID_LIV",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_EMP",referencedColumnName = "ID"))
    private Set<Emprunt> emprunts;

    public Livre() {
    }

    public Livre(String title, String authord, Set<Emprunt> emprunts) {
        this.title = title;
        this.authord = authord;
        this.emprunts = emprunts;
    }

    public Livre(Integer id, String title, String authord, Set<Emprunt> emprunts) {
        this.id = id;
        this.title = title;
        this.authord = authord;
        this.emprunts = emprunts;
    }

    public Livre(String title, String authord) {
        this.title = title;
        this.authord = authord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthord() {
        return authord;
    }

    public void setAuthord(String authord) {
        this.authord = authord;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authord='" + authord + '\'' +
                '}';
    }
}
