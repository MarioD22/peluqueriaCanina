
package com.concesionario.peluqueriacanina.persistencia;

import com.concesionario.peluqueriacanina.logica.Duenio;
import com.concesionario.peluqueriacanina.logica.Mascota;
import com.concesionario.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    DuenioJpaController duenioJPA = new DuenioJpaController();
    MascotaJpaController mascoJPA = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
    //creo duenio
    duenioJPA.create(duenio);
    //creo mascota
    mascoJPA.create(masco);
    
    }

    public List<Mascota> traerMascotas() {
      return mascoJPA.findMascotaEntities();
    }

    public void borrarMascota(int idMasco) {
        try {
            mascoJPA.destroy(idMasco);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Mascota traerMascota(int idMascota) {
    return mascoJPA.findMascota(idMascota);
    }

    public void modificarMascota(Mascota masco) {
     
        try {
            mascoJPA.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
