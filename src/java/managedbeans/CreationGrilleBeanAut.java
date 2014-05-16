/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.ArrayList;
import java.io.Serializable;
import static java.util.Collections.list;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import models.Categorie;
import models.CritereBs;
import models.Grille;
import models.Lignegrille;
import models.PopulationCible;
import models.QuestionBs;
import models.Terminal;
import models.TypeApplication;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import services.CategorieService;
import services.CritereService;
import services.GrilleService;
import services.LigneGrilleService;
import services.PopulationService;
import services.QuestionService;
import services.TerminalService;
import services.TypeApplicationService;

/**
 *
 * @author Anis
 */
@ManagedBean
@RequestScoped
public class CreationGrilleBeanAut implements Serializable {

    private TreeNode root;
    private TreeNode[] selectedNodes;
    Object selectednode;
    List<models.TypeApplication> typeliste;
    TypeApplication selectedtype;
    List<models.Terminal> terminalliste;
    Terminal selectterminal;
    List<models.PopulationCible> populationlliste;
    PopulationCible selectpopulation;

    CategorieService categorie_s = new CategorieService();
    CritereService critere_s = new CritereService();
    QuestionService question_s = new QuestionService();
    GrilleService grille_s = new GrilleService();
    LigneGrilleService lignegrille_s = new LigneGrilleService();

    TypeApplicationService type_s = new TypeApplicationService();
    TerminalService term_s = new TerminalService();
    PopulationService population_s = new PopulationService();

    private Grille grille;

    public CreationGrilleBeanAut() {

        grille = new Grille();
        grille.setType(1);
        grille.setNote(-1);

        root = new DefaultTreeNode("Root", null);

        for (Categorie cat : categorie_s.getAll()) {
            TreeNode node0 = new DefaultTreeNode(cat, root);
            for (CritereBs cr : critere_s.getAllByCategorie(cat)) {
                TreeNode node1 = new DefaultTreeNode(cr, node0);

                for (QuestionBs q : question_s.getAllByCritere(cr)) {
                    TreeNode node2 = new DefaultTreeNode(q, node1);

                }
            }
        }
    }

    @PostConstruct
    public void initFiltre() {
        typeliste = type_s.getAll();
        populationlliste = population_s.getAll();
        terminalliste = term_s.getAll();
    }

    public void generateQuestion() {
        System.out.println("TEST");
    }

    public TreeNode getRoot() {

        /*       for (Categorie cat : categorie_s.getAll()) {
         TreeNode node0 = new DefaultTreeNode(cat, root);
         for (CritereBs cr : critere_s.getAllByCategorie(cat)) {
         TreeNode node1 = new DefaultTreeNode(cr, node0);

         for (QuestionBs q : question_s.getAllByCritere(cr)) {
         TreeNode node2 = new DefaultTreeNode(q, node1);

         }
         }
         }
         */
   /*    for (QuestionBs q : question_s.getAllFiltre(selectedtype, selectterminal, selectpopulation)) {
            TreeNode node2 = new DefaultTreeNode(q, root);
        }
*/
        return root;
    }

    public TreeNode[] getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedNodes(TreeNode[] selectedNodes) {
        this.selectedNodes = selectedNodes;
    }

    public Object getSelectednode() {
        return selectednode;
    }

    public void setSelectednode(Object selectednode) {
        this.selectednode = selectednode;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public String creerGrille() {

        System.out.println("# Creation de Grille");

        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext context1 = FacesContext.getCurrentInstance();
        context1.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage msg = null;
        System.out.println("Grille" + grille.getNomgrille());
        grille_s.save(grille);
        for (TreeNode selectedNode : selectedNodes) {
            if (selectedNode.getData().getClass().equals(QuestionBs.class)) {
                Lignegrille lg = new Lignegrille();
                lg.setQuestionBs((QuestionBs) selectedNode.getData());
                lg.setGrille(grille);
                lignegrille_s.save(lg);
            }
        }
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes", "Grille d'évaluation creé avec succes");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("grilleid", true);

        return "listeGrille.xhtml?faces-redirect=true";
    }

    public String description() {

        return ((Categorie) selectednode).des();
    }

    public List<TypeApplication> getTypeliste() {
        return typeliste;
    }

    public void setTypeliste(List<TypeApplication> typeliste) {
        this.typeliste = typeliste;
    }

   

    public List<Terminal> getTerminalliste() {
        return terminalliste;
    }

    public void setTerminalliste(List<Terminal> terminalliste) {
        this.terminalliste = terminalliste;
    }

   

    public List<PopulationCible> getPopulationlliste() {
        return populationlliste;
    }

    public void setPopulationlliste(List<PopulationCible> populationlliste) {
        this.populationlliste = populationlliste;
    }

    public TypeApplication getSelectedtype() {
        return selectedtype;
    }

    public void setSelectedtype(TypeApplication selectedtype) {
        this.selectedtype = selectedtype;
    }

    public Terminal getSelectterminal() {
        return selectterminal;
    }

    public void setSelectterminal(Terminal selectterminal) {
        this.selectterminal = selectterminal;
    }

    public PopulationCible getSelectpopulation() {
        return selectpopulation;
    }

    public void setSelectpopulation(PopulationCible selectpopulation) {
        this.selectpopulation = selectpopulation;
    }

   

}
