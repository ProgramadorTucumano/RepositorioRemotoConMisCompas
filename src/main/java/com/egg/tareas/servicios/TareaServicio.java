/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.tareas.servicios;

import com.egg.tareas.entidades.Tarea;
import com.egg.tareas.repositorios.TareaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nahue
 */
@Service
public class TareaServicio {
    
    @Autowired
    private TareaRepository tareaRepository;
    
    public Tarea guardarTarea(Tarea tarea) throws Exception {
        if (tarea.getContenido().isEmpty()) {
            throw new Exception("El campo contenido no puede estar vacío");
        }
        return tareaRepository.save(tarea);
    }
    
    public List<Tarea> listarTodasLasTareas() {
        return tareaRepository.findAll();
    }
    
    public Tarea buscarTareaPorId(String id) {
        return tareaRepository.findById(id).orElse(new Tarea());
    }
}
