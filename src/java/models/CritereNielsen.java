package models;
// Generated 11 r. 2014 21:52:45 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CritereNielsen generated by hbm2java
 */
@Entity
@Table(name="critere_nielsen"
    ,catalog="ihm_db"
)
public class CritereNielsen  implements java.io.Serializable {


     private Integer idcritaire;
     private Categorie categorie;
     private String libcritaire;
     private Set<QuestionNielsen> questionNielsens = new HashSet<QuestionNielsen>(0);

    public CritereNielsen() {
    }

    public CritereNielsen(Categorie categorie, String libcritaire, Set<QuestionNielsen> questionNielsens) {
       this.categorie = categorie;
       this.libcritaire = libcritaire;
       this.questionNielsens = questionNielsens;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idcritaire", unique=true, nullable=false)
    public Integer getIdcritaire() {
        return this.idcritaire;
    }
    
    public void setIdcritaire(Integer idcritaire) {
        this.idcritaire = idcritaire;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idcategorie")
    public Categorie getCategorie() {
        return this.categorie;
    }
    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    
    @Column(name="libcritaire", length=45)
    public String getLibcritaire() {
        return this.libcritaire;
    }
    
    public void setLibcritaire(String libcritaire) {
        this.libcritaire = libcritaire;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="critereNielsen")
    public Set<QuestionNielsen> getQuestionNielsens() {
        return this.questionNielsens;
    }
    
    public void setQuestionNielsens(Set<QuestionNielsen> questionNielsens) {
        this.questionNielsens = questionNielsens;
    }




}

