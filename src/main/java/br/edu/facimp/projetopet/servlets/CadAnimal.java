/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.facimp.projetopet.servlets;

import br.edu.facimp.projetopet.models.Animal;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mikhaell
 */
@WebServlet(name = "CadAnimal", urlPatterns = {"/CadAnimal"})
public class CadAnimal extends HttpServlet {
    
    private EntityManagerFactory emf = null;
    
    public EntityManager getEntityManager() {
        
        emf = Persistence.createEntityManagerFactory("projetopet");
        return emf.createEntityManager();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        
        // criando uma conexão
        EntityManager em = null;
 
        try {
            
            // pegando informações do form
            String nome = request.getParameter("Nome");
            String idade  = request.getParameter("Idade");
            String dono = request.getParameter("Dono");
            
            Animal animal = new Animal();

            animal.setDono(dono);
            animal.setNome(nome);
            animal.setIdade(Integer.parseInt(idade));

            if (nome != null && idade != null && dono != null) {

                em = getEntityManager();
                em.getTransaction().begin();
                em.persist(animal);
                em.getTransaction().commit();
            }
            
                RequestDispatcher rd = request.getRequestDispatcher("/msgcadastro.jsp");
                rd.forward(request, response);
            
        } finally {
           
            //fecha conexões
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            
            em.close();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
