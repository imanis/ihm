/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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

@SessionScoped
@ManagedBean
public class TreeCheckboxBean implements Serializable {

    private Map<Integer, TreeNode[]> selectedNodes;
    int selectedNodesSize = 0;
    
    public TreeNode[] selectedNodes2;

    private TreeNode root2;
    private Grille grille;

    Categorie curCategorie;
    int currentCat;

    CategorieService categorie_s = new CategorieService();
    CritereService critere_s = new CritereService();
    QuestionService question_s = new QuestionService();
    GrilleService grille_s = new GrilleService();
    LigneGrilleService lignegrille_s = new LigneGrilleService();

    public TreeCheckboxBean() {

        grille = new Grille();
        grille.setType(2);
        grille.setNote(-1);
    }

    public TreeNode root2(Categorie categorie) {

        /*
         currentCat = categorie.getIdCategorie();
         TreeNode node0 = new DefaultTreeNode(categorie, root2);
         for (CritereBs cr : critere_s.getAllByCategorie(categorie)) {
         TreeNode node1 = new DefaultTreeNode(cr, node0);

         for (QuestionBs q : question_s.getAllByCritere(cr)) {
         TreeNode node2 = new DefaultTreeNode(q, node1);
         }
         }
        
         */
        if (categorie != null) {
        currentCat = categorie.getIdCategorie();
        
            root2 = new DefaultTreeNode("Root", null);
            for (CritereBs crit : categorie.getCritereBses()) {
                TreeNode node0 = new DefaultTreeNode(crit, root2);
                for (QuestionBs q : crit.getQuestionBses()) {

                    TreeNode node1 = new DefaultTreeNode(q, node0);
                }
            }
            return root2;
        }
        return null;
    }

    public TreeNode[] getSelectedNodes() {
        return selectedNodes.get(currentCat);
    }

    public int getSelectedNodesSize() {
        if (selectedNodes != null) {
            int totale = 0;
            for (Map.Entry<Integer, TreeNode[]> entry : selectedNodes.entrySet()) {
                Integer integer = entry.getKey();
                TreeNode[] treeNodes = entry.getValue();
                totale += treeNodes.length;

            }

            return totale;
        } else {
            return 0;
        }
    }

    public void setSelectedNodes(TreeNode[] sn) {
        this.selectedNodes.remove(sn);
        this.selectedNodes.put(currentCat, sn);
    }

    public void creerGrille(ActionEvent actionEvent) {
        System.out.println("# Creation de Grille");

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");

        System.out.println("Grille" + grille.getNomgrille());
        grille_s.save(grille);
        System.out.println("Size "+selectedNodes2.length);
        
    //    System.out.println("Size "+selectedNodes.size());
        
     //   for (Map.Entry<Integer, TreeNode[]> entry : selectedNodes.entrySet()) {
     //       Integer integer = entry.getKey();
     //       TreeNode[] treeNodes = entry.getValue();

    /*        for (int i = 0; i < treeNodes.length; i++) {

                if (treeNodes[i].getData().getClass().equals(QuestionBs.class)) {
                    Lignegrille lg = new Lignegrille();
                    lg.setQuestionBs((QuestionBs) treeNodes[i].getData());
                    lg.setGrille(grille);
                    lignegrille_s.save(lg);
                }
            }
        }
   */    
         for (int i = 0; i < selectedNodes2.length; i++) {

                if (selectedNodes2[i].getData().getClass().equals(QuestionBs.class)) {
                    Lignegrille lg = new Lignegrille();
                    lg.setQuestionBs((QuestionBs) selectedNodes2[i].getData());
                    lg.setGrille(grille);
                    lignegrille_s.save(lg);
                }
            }
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("grilleid", true);
        
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public void setRoot2(TreeNode root2) {
        this.root2 = root2;
    }

    public TreeNode getRoot2() {
        return root2;
    }

    public Categorie getCurCategorie() {
        return curCategorie;
    }

    public void setCurCategorie(Categorie curCategorie) {
        currentCat = curCategorie.getIdCategorie();
        this.curCategorie = curCategorie;
    }

    public TreeNode[] getSelectedNodes2() {
        return selectedNodes2;
    }

    public void setSelectedNodes2(TreeNode[] selectedNodes2) {
        this.selectedNodes2 = selectedNodes2;
    }


    
    

}
