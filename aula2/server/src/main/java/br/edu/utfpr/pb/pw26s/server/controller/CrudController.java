package br.edu.utfpr.pb.pw26s.server.controller;

import br.edu.utfpr.pb.pw26s.server.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public abstract class CrudController<T, ID extends Serializable> {

    protected abstract CrudService<T, ID> getService();

    @GetMapping
    protected List<T> findAll() {
        return getService().findAll();
    }

    @GetMapping("page") // localhost:8026/model/page?page=1&size=5&order=nome&asc=true
    private Page<T> findAll(@RequestParam int page,
                            @RequestParam int size,
                            @RequestParam(required = false) String order,
                            @RequestParam(required = false) Boolean asc) {
        PageRequest pageRequest = PageRequest.of(page, size);
        if (order != null && asc != null) {
            pageRequest = PageRequest.of(page, size, asc ? Sort.Direction.ASC : Sort.Direction.DESC, order);
        }
        return getService().findAll(pageRequest);
    }

    @GetMapping("{id}")
    private T findOne(@PathVariable("id") ID id) {
        return getService().findOne(id);
    }

    @PostMapping
    private T save(@RequestBody @Valid T entity) {
        return getService().save(entity);
    }

    @GetMapping("exists/{id}")
    private boolean exists(@PathVariable("id") ID id) {
        return getService().exists(id);
    }

    @GetMapping("count")
    private long count() {
        return getService().count();
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable("id") ID id) {
        getService().delete(id);
    }

}
