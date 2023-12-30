
package com.concesionario.peluqueriacanina.logica;

import com.concesionario.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String celDuenio, String color, String nombreDuenio, String nombreMascota, String observaciones, String raza, String alergia, String atEspecial) {
    
        //creo el duenio
        Duenio duenio = new Duenio();
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(nombreDuenio);
        
        //creo la mascota
        
        Mascota masco = new Mascota();
        masco.setAlergico(alergia);
        masco.setAtencion_especial(atEspecial);
        masco.setColor(color);
        masco.setNombre(nombreMascota);
        masco.setObservaciones(observaciones);
        masco.setRaza(raza);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio,masco);
               
    
    }

    public List<Mascota> traerMascotas() {
       
    return controlPersis.traerMascotas();
    }

    public void borrarMascota(int idMasco) {
    controlPersis.borrarMascota(idMasco);   
    
    }

    public Mascota traerMascota(int idMascota) {
     return controlPersis.traerMascota(idMascota);
    }

    public void modificarMascota(Mascota masco, String celDuenio, String color, String nombreDuenio, String nombreMascota, String observaciones, String raza, String alergia, String atEsp) {
     masco.setAlergico(alergia);
     masco.setAtencion_especial(atEsp);
     masco.setColor(color);
     masco.setNombre(nombreMascota);
     masco.setObservaciones(observaciones);
     masco.setRaza(raza);
     Duenio due = new Duenio();
     due.setNombre(nombreDuenio);
     due.setCelDuenio(celDuenio);
     masco.setUnDuenio(due);
     
     controlPersis.modificarMascota(masco);
     
     
    
    }

    

    
    
    
    
}
