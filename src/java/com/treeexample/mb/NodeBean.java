
package com.treeexample.mb;

import com.treeexample.dao.TreeDao;
import com.treeexample.entity.Kategori;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@RequestScoped
public class NodeBean {
    
    @ManagedProperty(value = "#{treeDao}")
    private TreeDao treeDao;
    
    private TreeNode root;
    private TreeNode donanim;
    private TreeNode selectedNode;
    private static  List<Kategori> liste;
    private static List<Kategori> araListe;    
    private List<Kategori> subList2;
    
    @PostConstruct
    private void init(){        
        
        liste=new ArrayList<>();
        root=new DefaultTreeNode("Root",null);
        liste = treeDao.getirKategoriListesi();       
        donanim=new DefaultTreeNode("Deneme", root);
        //Butun kategorileri tutan bir ana kategori olusturuyor.
        //Dynamic olarak sub kategori ekliyor. Recursive olarak hepsini kontrol edilmesi lazim.
        recursive(liste, 0,donanim);

    }
    //Dynamic tree viewi oluşturan method.
    public final  void recursive(List<Kategori> liste, int id,TreeNode node){
            subList2=new ArrayList<>();
            subList2=subKategori(id);
          for(Kategori k:subList2){
            TreeNode childNode=new DefaultTreeNode(k.getKategoriAdi(), node);
            //Veritabaninda kategori tablosunu tree view seklinde dynamic olarak olusturmayi saglar.
             recursive(subList2, k.getKategoriId(),childNode);
          }

    }
    
    //Herhangi bir tree nodenin childlarini buluyor.
    public static List<Kategori> subKategori(int i) 
    {
        araListe=new ArrayList<>();
        for(Kategori k:getListe()){
            if(k.getKatUstId()==i){
                araListe.add(k);
            }
        }
        return araListe;
    }
    
    public void secilenNode(NodeSelectEvent event){
        FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "selected", event.getTreeNode().getData().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public static List<Kategori> getListe() {
        return liste;
    }   
    public TreeNode getRoot() {
        return root;
    }
    public TreeNode getSelectedNode() {
        return selectedNode;
    }
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
    
    public TreeDao getTreeDao() {
        return treeDao;
    }

    public void setTreeDao(TreeDao treeDao) {
        this.treeDao = treeDao;
    }

    public static List<Kategori> getAraListe() {
        return araListe;
    }

    public static void setAraListe(List<Kategori> araListe) {
        NodeBean.araListe = araListe;
    }

    public List<Kategori> getSubList2() {
        return subList2;
    }

    public void setSubList2(List<Kategori> subList2) {
        this.subList2 = subList2;
    }    
}
