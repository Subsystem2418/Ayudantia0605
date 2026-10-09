package com.EjercicioAyudantia.ISoft.Controller;

import com.EjercicioAyudantia.ISoft.Model.TareaModel;
import com.EjercicioAyudantia.ISoft.Service.TareaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public ResponseEntity<TareaModel> crearTarea(@RequestBody TareaModel tarea) {
        TareaModel creada = tareaService.crearTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }
}
