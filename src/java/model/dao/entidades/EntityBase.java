/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.entidades;

import model.dao.entidades.EntityBase;
import java.io.Serializable;

/**
 *
 * @author Gabriel
 */
public interface EntityBase extends Serializable {
    
    public Long getId();
    
}