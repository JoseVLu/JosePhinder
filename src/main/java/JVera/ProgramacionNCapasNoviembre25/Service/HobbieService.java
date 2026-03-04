/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.Service;


import JVera.ProgramacionNCapasNoviembre25.Interfaces.IHobbieUsuarioJPARepository;
import JVera.ProgramacionNCapasNoviembre25.JPA.HobbieUsuario;

import JVera.ProgramacionNCapasNoviembre25.ML.Result;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HobbieService {
    
    @Autowired
    private IHobbieUsuarioJPARepository hobbieUsuarioJPARepository;
    
    public Result GetAll() {
        Result result = new Result();
        try {

            List<JVera.ProgramacionNCapasNoviembre25.JPA.HobbieUsuario> hobbies = hobbieUsuarioJPARepository.findAll();
            
            if(hobbies.isEmpty()){
                return result;
            }
            
            result.Objects = new ArrayList<Object>(hobbies);
            result.Correct = true;
         

        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
            
        }

        return result;
    }
    
    public Result Delete(int IsHobbieUsuario) {
        Result result = new Result();
        try {
            if (hobbieUsuarioJPARepository.existsById(IsHobbieUsuario)) {
                hobbieUsuarioJPARepository.deleteById(IsHobbieUsuario);

                result.Correct = true;
                
            } else {
                result.Correct = false;
                
            }
        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
            result.statuscode = 500;
        }
        return result;
        
    }
    
    public Result Add(HobbieUsuario hobbieusuario) {
        Result result = new Result();
        try {

            hobbieUsuarioJPARepository.save(hobbieusuario);

            result.Correct = true;
           
        
        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
        }
        return result;
    }
    
}
