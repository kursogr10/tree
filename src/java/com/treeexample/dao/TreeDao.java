package com.treeexample.dao;

import com.treeexample.util.HibernateUtil;
import com.treeexample.entity.Kategori;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class TreeDao {

    @SuppressWarnings("null")
    public List<Kategori> getirKategoriListesi() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Kategori> kategoriListesi = null;

        try {

            tx = session.beginTransaction();

            kategoriListesi = session.createCriteria(Kategori.class).list();

            tx.rollback();
            return kategoriListesi;

        } catch (Exception e) {

            tx.rollback();
            e.getMessage();
            return kategoriListesi;

        } finally {
            session.close();
        }
    }

    @SuppressWarnings("null")
    public List<Kategori> getirKategoriListesi(int katUstId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Kategori> kategoriListesi = null;

        try {

            tx = session.beginTransaction();

            kategoriListesi = session.createCriteria(Kategori.class).add(Restrictions.eq("katUstId", katUstId)).list();

            tx.rollback();
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
