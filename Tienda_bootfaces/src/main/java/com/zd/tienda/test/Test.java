/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zd.tienda.test;

import com.zd.tienda.dao.ClienteDao;
import com.zd.tienda.entity.Cliente;
import com.zd.tienda.repository.ICliente;
import java.util.List;

/**
 *
 * @author jonat
 */
public class Test {

    public static void main(String[] args) {
        try {
            ICliente clienteDao = new ClienteDao();
//            Cliente c = new Cliente();
//            c.setIdCliente(5);
//            c.setNombres("Mario");
//            c.setApellidos("Hernandez");
//            c.setDui("06245003-3");
//            //c.setDireccion("Apopa, San Salvador");
//            c.setEstado(false);
//            clienteDao.edit(c);

//            List<Cliente> clientes = clienteDao.clientes();
//            for(Cliente c: clientes){
//                System.out.println(c);
//            }
//            if (clienteDao.findById(4) == null) {
//                System.out.println("no existe");
//            } else {
//                System.out.println("si existe");
//            }
            Cliente c = clienteDao.findById(4);
            if (c == null) {
                System.out.println("no existe la consulta");
            } else {
                System.out.println("si existe: " + c.toString());
            }
        } catch (Exception e) {
            System.err.println("error en guardar " + e.getMessage());
        }
    }
}
