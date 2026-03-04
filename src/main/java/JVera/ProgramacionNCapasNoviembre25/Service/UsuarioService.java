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
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioJPARepository usuarioJPARepository;
    @Autowired
    private IDireccionJPARepository direccionJPARepository;

    public Result GetAll() {
        Result result = new Result();
        try {

            List<JVera.ProgramacionNCapasNoviembre25.JPA.Usuario> usuarios = usuarioJPARepository.findAll();
            result.Objects = new ArrayList<Object>(usuarios);
            result.Correct = true;
            

        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
            
        }

        return result;
    }

    public Result GetById(Integer IdUsuario) {
        Result result = new Result();
        try {

            JVera.ProgramacionNCapasNoviembre25.JPA.Usuario usuario = usuarioJPARepository.findById(IdUsuario).orElse(null);
            if(usuario!=null){
            result.Object = usuario;
            result.Correct = true;
            }
            else{
                result.Correct=false;
            }

        } catch (Exception ex) {
           result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;

        }
        return result;
    }

    public Result Delete(int IsUsuario) {
        Result result = new Result();
        try {
            if (usuarioJPARepository.existsById(IsUsuario)) {
                usuarioJPARepository.deleteById(IsUsuario);

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

    public Result Add(Usuario usuario) {
        Result result = new Result();
        try {
            usuarioJPARepository.save(usuario);
            usuario.direcciones.get(0).usuario = new Usuario();
            usuario.direcciones.get(0).usuario = usuario;
            direccionJPARepository.save(usuario.direcciones.get(0));

            result.Correct = true;
            result.statuscode = 201;
        
        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
        }
        return result;
    }

    public Result Update(Integer IsUsuario, Usuario usuario) {
        Result result = new Result();
        try {
            JVera.ProgramacionNCapasNoviembre25.JPA.Usuario usuarioDB = usuarioJPARepository.findById(IsUsuario).orElse(null);
            if (usuarioDB!=null) {
                
                if (usuario.getNombre() != null) usuarioDB.setNombre(usuario.getNombre());
            if (usuario.getApellidoPaterno() != null) usuarioDB.setApellidoPaterno(usuario.getApellidoPaterno());
            if (usuario.getApellidoMaterno() != null) usuarioDB.setApellidoMaterno(usuario.getApellidoMaterno());
            if (usuario.getEdad() > 0) usuarioDB.setEdad(usuario.getEdad());

            usuarioJPARepository.save(usuarioDB);
                

                result.Correct = true;
              
            } else {
                result.Correct = false;
                
            }
        } catch (Exception ex) {

            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
        
        }
        return result;
    }

}
