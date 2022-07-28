/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zd.tienda.repository;

import com.zd.tienda.entity.Cliente;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface ICliente {

    Cliente save(Cliente c);

    Cliente edit(Cliente c);

    List<Cliente> clientes();

    Cliente findById(int id);
}
