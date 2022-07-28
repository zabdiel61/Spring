/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zd.tienda.db;

import javax.persistence.*;

/**
 *
 * @author jonat
 */
public class ConexionJPA {

    private static EntityManagerFactory emf = null;

    public static EntityManager createEntityManager() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("tiendaPU");
            }
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e.getMessage());

        }
        return emf.createEntityManager();
    }

    public static void desconexion(EntityManager em) {
        if (em != null) {
            em.close();
            emf.close();
        }
    }
}
