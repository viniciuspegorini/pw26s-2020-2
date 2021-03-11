package br.edu.utfpr.pb.pw26s.server.controller;

import br.edu.utfpr.pb.pw26s.server.model.Categoria;
import br.edu.utfpr.pb.pw26s.server.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // localhost:8026/categoria/todos
    @GetMapping()
    private List<Categoria> getAll() {
        // "select * from categoria"
        return categoriaRepository.findAll();
    }

    @GetMapping("{id}") // localhost:8026/categoria/1  localhost:8026/categoria/exists/1
    private Categoria getOne(@PathVariable Integer id) {
        return categoriaRepository.findById(id).orElse(new Categoria());
    }

    @GetMapping("exists/{id}") // localhost:8026/categoria/1  localhost:8026/categoria/exists/1
    private boolean existis(@PathVariable Integer id) {
        return categoriaRepository.existsById(id);
    }

    @PostMapping
    private Categoria save(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("{id}") // localhost:8026/categoria/1 = HTTP DELETE
    private void delete(@PathVariable Integer id) {
        categoriaRepository.deleteById(id);
    }
}
