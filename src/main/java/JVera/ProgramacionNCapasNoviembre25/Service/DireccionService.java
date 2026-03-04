/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.Service;

import JVera.ProgramacionNCapasNoviembre25.Interfaces.IDireccionJPARepository;
import JVera.ProgramacionNCapasNoviembre25.Interfaces.IUsuarioJPARepository;
import JVera.ProgramacionNCapasNoviembre25.JPA.Direccion;
import JVera.ProgramacionNCapasNoviembre25.JPA.Usuario;
import JVera.ProgramacionNCapasNoviembre25.ML.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alien 3 P9
 */

@Service
public class DireccionService {
    
    @Autowired
    private IDireccionJPARepository direccionJPARepository;
    
    @Autowired
    private IUsuarioJPARepository usuarioJPARepository;
    
     public Result Add(Direccion direccion) {
        Result result = new Result();
        try {

            direccionJPARepository.save(direccion);

            result.Correct = true;
            result.statuscode = 201;
        
        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
        }
        return result;
    }
     
     public Result Delete(int IsDireccion) {
        Result result = new Result();
        try {
            if (direccionJPARepository.existsById(IsDireccion)) {
                direccionJPARepository.deleteById(IsDireccion);

                result.Correct = true;
                result.Errormessage="Se elimino el registro correctamente";
                result.statuscode = 204;
            } else {
                result.Correct = false;
                result.Errormessage = "No se encontró la direccion con el ID proporcionado.";
                result.statuscode = 404;
            }
        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
            result.statuscode = 500;
        }
        return result;
        
    }
    
}
