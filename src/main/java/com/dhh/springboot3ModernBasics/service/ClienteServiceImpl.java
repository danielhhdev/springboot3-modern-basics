package com.dhh.springboot3ModernBasics.service;

import com.dhh.springboot3ModernBasics.model.Cliente;
import com.dhh.springboot3ModernBasics.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> findAll() { return repository.findAll(); }

    public Cliente save(Cliente cliente) { return repository.save(cliente); }

    public Cliente update(Long id, Cliente cliente) {
        cliente.setId(id);
        return repository.save(cliente);
    }

    public void delete(Long id) { repository.deleteById(id); }
}