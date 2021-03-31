/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.facimp.projetopet.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mikhaell
 */
public class JPAUtil {
    
    private static EntityManager em = null;
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetopet");
    
    static {
        pegarConexao();
    }
    
    public static EntityManager pegarConexao() {
        
    if(em == null) {
        
        em = emf.createEntityManager();
    }
        return em;
    }
    
}
