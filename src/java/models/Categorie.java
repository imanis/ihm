package models;
// Generated 11 f�vr. 2014 21:52:45 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categorie generated by hbm2java
 */
@Entity
@Table(name="categorie"
    ,catalog="ihm_db"
)
public class Categorie  implements java.io.Serializable {


     private Integer idCategorie;
     private String libCategorie;
     private String description;
     private Set<CritereNielsen> critereNielsens = new HashSet<CritereNielsen>(0);
     private Set<CritereBs> critereBses = new HashSet<CritereBs>(0);

    public Categorie() {
    }

	
    public Categorie(String description) {
        this.description = description;
    }
    public Categorie(String libCategorie, String description, Set<CritereNielsen> critereNielsens, Set<CritereBs> critereBses) {
       this.libCategorie = libCategorie;
       this.description = description;
       this.critereNielsens = critereNielsens;
       this.critereBses = critereBses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCategorie", unique=true, nullable=false)
    public Integer getIdCategorie() {
        return this.idCategorie;
    }
    
    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    
    @Column(name="libCategorie", length=45)
    public String getLibCategorie() {
        return this.libCategorie;
    }
    
    public void setLibCategorie(String libCategorie) {
        this.libCategorie = libCategorie;
    }

    
    @Column(name="description", nullable=false, length=200)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categorie")
    public Set<CritereNielsen> getCritereNielsens() {
        return this.critereNielsens;
    }
    
    public void setCritereNielsens(Set<CritereNielsen> critereNielsens) {
        this.critereNielsens = critereNielsens;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categorie")
    public Set<CritereBs> getCritereBses() {
        return this.critereBses;
    }
    
    public void setCritereBses(Set<CritereBs> critereBses) {
        this.critereBses = critereBses;
    }

    @Override
    public String toString() {
        return  libCategorie ;
    }
    
    public String des(){
        return description;
    }



}

