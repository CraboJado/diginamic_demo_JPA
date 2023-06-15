package fr.diginamic.entities;

import jakarta.persistence.*;

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

    public Livre() {
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

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authord='" + authord + '\'' +
                '}';
    }
}
