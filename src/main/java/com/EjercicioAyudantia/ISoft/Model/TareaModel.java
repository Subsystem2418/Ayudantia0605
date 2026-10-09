package com.EjercicioAyudantia.ISoft.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TareaModel {

    private Long id;
    private String titulo;
    private String prioridad;
    private String fechaLimite;
    private boolean completada = false;
}