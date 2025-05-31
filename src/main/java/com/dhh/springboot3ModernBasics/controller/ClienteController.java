package com.dhh.springboot3ModernBasics.controller;

import com.dhh.springboot3ModernBasics.model.Cliente;
import com.dhh.springboot3ModernBasics.service.ClienteService;
import com.dhh.springboot3ModernBasics.service.ClienteServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAll() { return clienteService.findAll(); }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) { return clienteService.save(cliente); }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { clienteService.delete(id); }

}
