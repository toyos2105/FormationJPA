/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Formation
 */
@Entity
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int annee;
    private int duree;
    
    @Column(name="nom_titre", length=50)
    private String titre;
    
    @Column(name="nom_realisateur", length=50)
    private String realisateur;
    
    @Column(name="annee_de_sortie")
    private int anneeSortie;

    @JoinColumn(name="film_evenement")
    @OneToOne
    private EvenementDeSortie evenementDeSortie ;
    
    @OneToMany(mappedBy="film")
    private List<Lien> liens_film = new ArrayList<>();

    @JoinTable(name="films_realisateurs")
    @ManyToMany
    private List<Personne> realisateurs = new ArrayList<>();
    
    @JoinTable(name="films_acteurs")
    @ManyToMany
    private List<Personne> acteurs = new ArrayList<>();
    
    @JoinTable(name="films_pays")
    @ManyToMany
    private List<Pays> pays = new ArrayList<>();
    
    @JoinTable(name="films_genres")
    @ManyToMany
    private List<Genre> genres = new ArrayList<>();
    

    public Film(String titre, int duree, int annee) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
    }
    public Film(){}
    
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atelierjpa.Film[ id=" + id + " ]";
    }
    
}
