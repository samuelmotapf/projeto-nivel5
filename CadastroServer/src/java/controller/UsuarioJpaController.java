/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Usuario;

/**
 *
 * @author muangala Jr
 */
public class UsuarioJpaController {
    public Usuario findUsuario(String login, String senha) {
        EntityManager em = getEntityManager();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class); // Retorna null se não encontrar usuário com as credenciais
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        return query.getSingleResult();
        
    }

    private EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
