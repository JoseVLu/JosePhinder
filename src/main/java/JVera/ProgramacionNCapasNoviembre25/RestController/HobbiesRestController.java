/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.RestController;


import JVera.ProgramacionNCapasNoviembre25.JPA.HobbieUsuario;
import JVera.ProgramacionNCapasNoviembre25.JPA.Usuario;
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

/**
 *
 * @author Alien 3 P9
 */
@RestController
@RequestMapping("Hobbies")
public class HobbiesRestController {
    
    @Autowired
    HobbieService hobbiejpadaoimplementation;
    
    @GetMapping
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Exito en la busqueda"),
        @ApiResponse(responseCode = "500", description = "Fallo al cargar los usuarios")
    })
    public ResponseEntity GetAll() {

        Result result = hobbiejpadaoimplementation.GetAll();

        return ResponseEntity.status(result.statuscode).body(result);

    }
    
    @DeleteMapping("/{IdHobbieUsuario}")
    @Operation(summary = "Eliminar una Direccion", description = "Metodo que elimina una direccion de la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Exito en eliminar la direccion"),
        @ApiResponse(responseCode = "404", description = "No se encontro la direccion que se quiere eliminar"),
        @ApiResponse(responseCode = "500", description = "Hubo un error del lado del servidor")
    })
    public ResponseEntity HobbieDelete(@PathVariable("IdHobbieUsuario") int idHobbieUsuario) {

        Result result = hobbiejpadaoimplementation.Delete(idHobbieUsuario);

        return ResponseEntity.status(result.statuscode).body(result);
    }
    
     @PostMapping
    @Operation(summary = "Añadir un Usuario", description = "Metodo que añade un usuario a la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Exito en añadir un usuario"),
        @ApiResponse(responseCode = "400", description = "Hubo un error al llenar la solicitud")
    })
    public ResponseEntity Add(@RequestBody HobbieUsuario hobbieusuario) {
        Result result = new Result();
        try {
            result = hobbiejpadaoimplementation.Add(hobbieusuario);
            if(result.Correct){
            result.statuscode = 201;
        }
            else{
                result.statuscode = 400;
                result.Errormessage = "Error en los datos";
            }
        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
            result.statuscode = 500;
        }
        
        return ResponseEntity.status(result.statuscode).body(result);

    }
    
}
