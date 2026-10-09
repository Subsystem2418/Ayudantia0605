package com.EjercicioAyudantia.ISoft.Service;

import com.EjercicioAyudantia.ISoft.Model.TareaModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TareaService {

    private final List<TareaModel> tareas = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(0);

    public TareaModel crearTarea(TareaModel tarea) {
        tarea.setId(contadorId.incrementAndGet());
        tarea.setCompletada(false);
        tareas.add(tarea);
        return tarea;
    }
}
