package JVera.ProgramacionNCapasNoviembre25.RestController;


import JVera.ProgramacionNCapasNoviembre25.JPA.HobbieUsuario;
import JVera.ProgramacionNCapasNoviembre25.ML.Result;
import JVera.ProgramacionNCapasNoviembre25.Service.HobbieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Hobbies")
public class HobbiesRestController {
    
    @Autowired
    HobbieService hobbiejpadaoimplementation;
    
    @GetMapping
    @Operation(summary = "Obtener los hobbies", description = "Metodo que obtiene las relaciones usuario-hobbie de la BD")

    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Exito en la busqueda"),
        @ApiResponse(responseCode = "204", description = "No existen relaciones entre hobbies y usuarios")
    })
    public ResponseEntity GetAll() {

        Result result = hobbiejpadaoimplementation.GetAll();

        if(result.Correct){
            result.statuscode = 200;
            return ResponseEntity.status(result.statuscode).body(result.Objects);
        }else{
            result.statuscode = 204;
            return ResponseEntity.status(result.statuscode).build();
        }

    }
    
    @DeleteMapping("/{IdHobbieUsuario}")
    @Operation(summary = "Eliminar un hobbie", description = "Metodo que elimina la relacion de usuario-hobbie en la BD")

    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Exito en eliminar el hobbie"),
        @ApiResponse(responseCode = "404", description = "No se encontro el hobbie que se quiere eliminar")
    })
    public ResponseEntity HobbieDelete(@PathVariable("IdHobbieUsuario") int idHobbieUsuario) {

        Result result = hobbiejpadaoimplementation.Delete(idHobbieUsuario);
        
        if(result.Correct){
            result.statuscode = 204;
            
        }else if(!result.Correct){
            result.statuscode = 400;
           
        }

        return ResponseEntity.status(result.statuscode).body("No pudo realizarse la eliminacion del registro");
    }
    
     @PostMapping
    @Operation(summary = "Añadir un Usuario", description = "Metodo que relaciona un hobbie y un usuario en la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Exito en añadir un hobbie"),
        @ApiResponse(responseCode = "400", description = "Hubo un error al llenar la solicitud")
    })
    public ResponseEntity Add(@RequestBody HobbieUsuario hobbieusuario) {
        Result result = new Result();
        try {
            result = hobbiejpadaoimplementation.Add(hobbieusuario);
            if(result.Correct){
            result.statuscode = 201;
            return ResponseEntity.status(result.statuscode).body(result);
        }
            else{
                result.statuscode = 400;
                result.Errormessage = "Error en los datos";
                
        return ResponseEntity.status(result.statuscode).body(result.Errormessage);
            }
        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
            result.statuscode = 500;
            return ResponseEntity.status(result.statuscode).body(result);
        }
        
        

    }
    
}
