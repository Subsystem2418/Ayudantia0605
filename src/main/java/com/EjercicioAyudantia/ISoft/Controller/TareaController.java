package com.EjercicioAyudantia.ISoft.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EjercicioAyudantia.ISoft.Model.TareaModel;
import com.EjercicioAyudantia.ISoft.Service.TareaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tasks")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<TareaModel> listar(
            @RequestParam(name = "prioridad", required = false) String prioridad,

            @RequestParam(name = "titulo", required = false) String titulo,

            @RequestParam(name = "fechaLimite", required = false) String fechaLimite) {
        return tareaService.listar(prioridad, titulo, fechaLimite);
    }

    @PostMapping
    public ResponseEntity<TareaModel> crearTarea(@RequestBody TareaModel tarea) {
        TareaModel creada = tareaService.crearTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TareaModel> completarTarea(
            @PathVariable("id") Long id) {
        TareaModel tarea = tareaService.completarTarea(id);

        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tarea);
    }
}
