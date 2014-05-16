/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.Categorie;
import models.CritereBs;
import models.Grille;
import models.Lignegrille;
import models.QuestionBs;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import services.CategorieService;
import services.CritereService;
import services.GrilleService;
import services.LigneGrilleService;
import services.QuestionService;

/**
 *
 * @author Anis
 */
@ManagedBean
@ViewScoped
public class CreationGrilleBean implements Serializable {

    private TreeNode root;
    private TreeNode[] selectedNodes;

    String selectednode = "vide";


    CategorieService categorie_s = new CategorieService();
    CritereService critere_s = new CritereService();
    QuestionService question_s = new QuestionService();
    GrilleService grille_s = new GrilleService();
    LigneGrilleService lignegrille_s = new LigneGrilleService();

    private Grille grille;

    public CreationGrilleBean() {

  
        grille = new Grille();
        grille.setType(2);
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

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode[] getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedNodes(TreeNode[] selectedNodes) {
        this.selectedNodes = selectedNodes;
    }

    public String getSelectednode() {
       
        return selectednode;
    }

    public void setSelectednode(String selectednode) {
      
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
        //System.out.println("Grille" + grille.getNomgrille());
        grille_s.save(grille);
        System.out.println("selectedNodes " + selectedNodes.length);
        for (TreeNode sNode : selectedNodes) {
            System.out.println("CLASS " + sNode.getData().getClass());
            if (sNode.getData().getClass().equals(QuestionBs.class)) {
                System.out.println("hy a queston here");
                Lignegrille lg = new Lignegrille();
                lg.setQuestionBs((QuestionBs) sNode.getData());
                lg.setGrille(grille);
                grille.getLignegrilles().add(lg);
                lignegrille_s.save(lg);
            }
        }
       // grille_s.save(grille);
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes", "Grille d'évaluation creée avec succes");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("grilleid", true);

       // return "listeGrille.xhtml?faces-redirect=true";
         return "editGrille.xhtml?id="+grille.getIdgrille()+"&faces-redirect=true";
        
    }

    public String description() {

        return selectednode;

    }


    public boolean notquestion(String des) {
      
        return !des.equals("-");

    }


}
