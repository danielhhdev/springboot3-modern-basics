package com.dhh.springboot3ModernBasics.service;

import com.dhh.springboot3ModernBasics.model.Cliente;

import java.util.List;

public interface ClienteService {


    public List<Cliente> findAll();

    public Cliente save(Cliente cliente);

    public Cliente update(Long id, Cliente cliente);

    public void delete(Long id);
}

