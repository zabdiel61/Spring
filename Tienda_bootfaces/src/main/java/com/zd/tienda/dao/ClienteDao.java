/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zd.tienda.dao;

import com.zd.tienda.db.ConexionJPA;
import com.zd.tienda.entity.Cliente;
import com.zd.tienda.repository.ICliente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jonat
 */
public class ClienteDao implements ICliente {

    private EntityManager em = null;

    public ClienteDao() {
        em = ConexionJPA.createEntityManager();

    }

    @Override
    public Cliente save(Cliente c) {
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            System.out.println("Cliente se guardo exitosamente");
        } finally {
            ConexionJPA.desconexion(em);
        }

        return c;
    }

    @Override
    public Cliente edit(Cliente c) {
        try {
            Cliente c1 = em.find(Cliente.class, c.getIdCliente());
            em.getTransaction().begin();
            if (em.contains(c1)) {
                em.merge(c);
                em.getTransaction().commit();
                System.out.println("Cliente se edito exitosamente");
            } else {
                System.out.println("No existe");
            }

        } finally {
            ConexionJPA.desconexion(em);
        }

        return c;
    }

    @Override
    public List<Cliente> clientes() {
        List<Cliente> clientes = null;
        try {
            clientes = em.createNamedQuery("Cliente.findAll").getResultList();
            System.out.println("lista clientes");
        } finally {
            ConexionJPA.desconexion(em);
        }

        return clientes;
    }

    @Override
    public Cliente findById(int id) {
        try {
            return em.find(Cliente.class, id);
        } finally {
            ConexionJPA.desconexion(em);
        }

    }

}
