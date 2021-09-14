package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        return libroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libro> crear(@Valid @RequestBody Libro libro) {
        Libro nuevoLibro = libroService.guardar(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @Valid @RequestBody Libro libro) {
        return libroService.obtenerPorId(id)
                .map(libroExistente -> {
                    libro.setId(id);
                    return ResponseEntity.ok(libroService.guardar(libro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return libroService.obtenerPorId(id)
                .map(libro -> {
                    libroService.eliminar(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
