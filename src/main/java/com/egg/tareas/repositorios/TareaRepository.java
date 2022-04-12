/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.tareas.repositorios;

import com.egg.tareas.entidades.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nahue
 */
@Repository
public interface TareaRepository extends JpaRepository<Tarea, String>{
    
}
