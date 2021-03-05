package br.edu.utfpr.pb.pw26s.server.controller;

import br.edu.utfpr.pb.pw26s.server.model.Marca;
import br.edu.utfpr.pb.pw26s.server.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("marca")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    // localhost:8026/marca/todos
    @GetMapping()
    private List<Marca> getAll() {
        // "select * from marca"
        return marcaRepository.findAll();
    }

    @GetMapping("{id}") // localhost:8026/marca/1  localhost:8026/marca/exists/1
    private Marca getOne(@PathVariable Integer id) {
        return marcaRepository.findById(id).orElse(new Marca());
    }

    @GetMapping("exists/{id}") // localhost:8026/marca/1  localhost:8026/marca/exists/1
    private boolean existis(@PathVariable Integer id) {
        return marcaRepository.existsById(id);
    }

    @PostMapping
    private Marca save(@RequestBody Marca marca) {
        return marcaRepository.save(marca);
    }

    @DeleteMapping("{id}") // localhost:8026/marca/1 = HTTP DELETE
    private void delete(@PathVariable Integer id) {
        marcaRepository.deleteById(id);
    }
}
