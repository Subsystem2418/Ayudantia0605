package com.EjercicioAyudantia.ISoft.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.EjercicioAyudantia.ISoft.Model.TareaModel;

@Repository
public class TareaRepository {

    private final Map<Long, TareaModel> tareas = new ConcurrentHashMap<>();

    public List<TareaModel> listar() {
        return new ArrayList<>(tareas.values());
    }
}