package com.EjercicioAyudantia.ISoft.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.EjercicioAyudantia.ISoft.Model.TareaModel;
import com.EjercicioAyudantia.ISoft.Repository.TareaRepository;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<TareaModel> listar(
            String prioridad,
            String titulo,
            String fechaLimite) {
        String texto = titulo == null
                ? null
                : titulo.toLowerCase(Locale.ROOT);

        return tareaRepository.listar().stream()
                .filter(tarea -> prioridad == null
                        || prioridad.equals(tarea.getPrioridad()))

                .filter(tarea -> texto == null
                        || tarea.getTitulo().toLowerCase(Locale.ROOT)
                                .contains(texto))

                .filter(tarea -> fechaLimite == null
                        || fechaLimite.equals(tarea.getFechaLimite()))

                .sorted(Comparator.comparing(TareaModel::getId))
                .toList();
    }
}