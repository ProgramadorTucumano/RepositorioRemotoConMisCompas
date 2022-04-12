/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.tareas.controladores;

import com.egg.tareas.entidades.Tarea;
import com.egg.tareas.servicios.TareaServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nahue
 */
@Controller
@RequestMapping("/tarea")
public class TareaController {
    
    @Autowired
    private TareaServicio tareaServicio;
    
    // localhost:8080/tarea/form
    @GetMapping("/form")
    public String form(Model modelo, @RequestParam(name="tareaId", required = false) String id) {
        Tarea tarea = new Tarea();
        if (id != null) {
            tarea = tareaServicio.buscarTareaPorId(id);
        }
        modelo.addAttribute("tarea", tarea);
        return "tarea-form";
    }
    
    // /tarea/save  -> localhost:8080/tarea/save
    @PostMapping("/save")
    public String save(@ModelAttribute("tarea") Tarea tarea, Model modelo) {
        try {
            tareaServicio.guardarTarea(tarea);
            modelo.addAttribute("success", "Tarea guardada con exito");
        } catch (Exception ex) {
            modelo.addAttribute("error", ex.getMessage());
        }
        return "tarea-form";
    }
    
    // /tarea/list -> localhost:8080/tarea/list
    @GetMapping("/list")
    public String lista(Model modelo) {
        modelo.addAttribute("tareas", tareaServicio.listarTodasLasTareas());
        return "tarea-list";
    }
}
