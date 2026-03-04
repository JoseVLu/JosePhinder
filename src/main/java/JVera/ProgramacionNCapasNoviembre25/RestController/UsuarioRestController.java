/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.RestController;

import JVera.ProgramacionNCapasNoviembre25.JPA.Usuario;
import JVera.ProgramacionNCapasNoviembre25.ML.Result;
import JVera.ProgramacionNCapasNoviembre25.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/swagger-ui/index.html
/**
 *
 * @author Alien 3 P9
 */
@RestController
@RequestMapping("/Usuario")
@Tag(name = "Usuario", description = "Controlador relacionado al Usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioService usuariojpadaoimplementation;

    @GetMapping
    @Operation(summary = "Obtener Usuarios", description = "Metodo que obtiene todos los usuarios de la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Exito en la busqueda"),
        @ApiResponse(responseCode = "204", description = "No existen usuarios en la BD")
    })
    public ResponseEntity GetAll() {

        Result result = usuariojpadaoimplementation.GetAll();
        
        if(result.Correct){
            result.statuscode = 200;
            return ResponseEntity.status(result.statuscode).body(result.Objects);
        }else{
            result.statuscode = 204;
            return ResponseEntity.status(result.statuscode).build();
        }

        

    }

    @Operation(summary = "Obtener un Usuario por su Id", description = "Metodo que obtiene un usuario en concreto mediante su ID")

    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Exito en la busqueda"),
        @ApiResponse(responseCode = "400", description = "No existe usuario con ese ID"),
    })
    @GetMapping("/{IdUsuario}")
    public ResponseEntity GetById(@PathVariable("IdUsuario") int idUsuario) {

        Result result = usuariojpadaoimplementation.GetById(idUsuario);
        
        if(result.Correct){
            result.statuscode = 200;
            return ResponseEntity.status(result.statuscode).body(result.Object);
        }
        else{
            result.statuscode = 400;
            return ResponseEntity.status(result.statuscode).body("No existe un registro con ese id");
        }

    }
    

    @DeleteMapping("/{IdUsuario}")
    @Operation(summary = "Eliminar un Usuario", description = "Metodo que elimina un usuario a la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Exito en eliminar un usuario"),
        @ApiResponse(responseCode = "400", description = "No se encontro el usuario que se quiere eliminar"),
    })

    public ResponseEntity Delete(@PathVariable("IdUsuario") int idUsuario) {

        Result result = usuariojpadaoimplementation.Delete(idUsuario);

        if(result.Correct){
            result.statuscode = 204;
            return ResponseEntity.status(result.statuscode).build();
        }
        else{
            result.statuscode = 400;
            return ResponseEntity.status(result.statuscode).body("No existe un registro con ese id");
        }

    }

    @PostMapping
    @Operation(summary = "Añadir un Usuario", description = "Metodo que añade un usuario a la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Exito en añadir un usuario"),
        @ApiResponse(responseCode = "400", description = "Hubo un error al llenar la solicitud"),
        @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor")
    })
    public ResponseEntity Add(@RequestBody Usuario usuario) {
        Result result = new Result();
        try {
            result = usuariojpadaoimplementation.Add(usuario);
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

    @PutMapping("/{IdUsuario}")
    @Operation(summary = "Actualizar un Usuario", description = "Metodo que actualiza un usuario a la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Exito al actualizar un usuario"),
        @ApiResponse(responseCode = "404", description = "No se encontro un usuario con ese id")
    })
    public ResponseEntity Update(@RequestBody Usuario usuario, @PathVariable("IdUsuario") Integer idUsuario) {

        Result result = usuariojpadaoimplementation.Update(idUsuario, usuario);
        
        if(result.Correct){
            result.statuscode = 200;
            return ResponseEntity.status(result.statuscode).body("Registro actualizado");
        }
        else if(!result.Correct){
            result.statuscode = 404;
            return ResponseEntity.status(result.statuscode).body("No existe un registro con ese id");
        }else{
             return ResponseEntity.status(500).body("Error inesperado del servidor");
        }

    }

}
