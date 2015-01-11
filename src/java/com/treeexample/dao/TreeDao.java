package com.treeexample.dao;

import com.treeexample.util.HibernateUtil;
import com.treeexample.entity.Kategori;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@RequestScoped
public class TreeDao {

    @SuppressWarnings("null")
    public List<Kategori> getirKategoriListesi() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Kategori> kategoriListesi = null;

        try {

            tx = session.beginTransaction();

            kategoriListesi = session.createCriteria(Kategori.class).list();

            tx.commit();
            return kategoriListesi;

        } catch (Exception e) {

            tx.rollback();
            e.getMessage();
            return kategoriListesi;

        } finally {
            session.close();
        }
    }
}
