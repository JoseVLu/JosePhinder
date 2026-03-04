package JVera.ProgramacionNCapasNoviembre25.RestController;

import JVera.ProgramacionNCapasNoviembre25.JPA.Direccion;
import JVera.ProgramacionNCapasNoviembre25.ML.Result;
import JVera.ProgramacionNCapasNoviembre25.Service.DireccionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Direccion")
public class DireccionRestController {

    @Autowired
    DireccionService direccionjpadaoimplementation;

    @DeleteMapping("/{IdDireccion}")
    @Operation(summary = "Eliminar una Direccion", description = "Metodo que elimina una direccion de la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Exito en eliminar la direccion"),
        @ApiResponse(responseCode = "400", description = "No se encontro la direccion que se quiere eliminar"),
        @ApiResponse(responseCode = "500", description = "Hubo un error del lado del servidor")
    })
    public ResponseEntity DireccionDelete(@PathVariable("IdDireccion") int idDireccion) {

        Result result = new Result();

        try {
            result = direccionjpadaoimplementation.Delete(idDireccion);
            if (result.Correct) {
                result.statuscode = 204;
                return ResponseEntity.status(HttpStatusCode.valueOf(result.statuscode)).build();
            } else {
                result.statuscode = 400;
                return ResponseEntity.status(result.statuscode).body("No se encontro un direccion con ese ID");
            }

        } catch (Exception e) {
            result.statuscode = 500;
            return ResponseEntity.status(result.statuscode).body("Error inesperado en el servidor");
        }

    }

    @PostMapping
    @Operation(summary = "Añadir una direccion", description = "Metodo que añade una direccion a la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Exito en añadir una direccion"),
        @ApiResponse(responseCode = "400", description = "Hubo un error al llenar la solicitud"),
        @ApiResponse(responseCode = "500", description = "Hubo un error del lado del servidor")
    })
    public ResponseEntity DireccionAdd(@RequestBody Direccion direccion) {

        Result result = new Result();
        try {
            result = direccionjpadaoimplementation.Add(direccion);
            if (result.Correct) {
                result.statuscode = 201;
            } else {
                return ResponseEntity.status(400).body("Datos invalidos, favor de asegurar de enviar todos los campos");
            }
        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
            result.statuscode = 500;
        }
        return ResponseEntity.status(result.statuscode).body(result);
    }

    @PutMapping
    @Operation(summary = "Actualizar una Direccion", description = "Metodo que actualiza una direccion de la base de datos")

    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Exito en actualizar la direccion"),
        @ApiResponse(responseCode = "400", description = "No se encontro la direccion que se quiere actualizar"),
        @ApiResponse(responseCode = "500", description = "Hubo un error del lado del servidor")
    })
    public ResponseEntity Update(@RequestBody Direccion direccion) {

        Result result = new Result();
        try {
            result = direccionjpadaoimplementation.Update(direccion);
            if(result.Correct)
            {
            result.statuscode = 200;
            return ResponseEntity.status(result.statuscode).body("El recurso fue actualizado correctamente");
            }
             else
            {
            result.statuscode = 400;
            return ResponseEntity.status(result.statuscode).body("No se encontro una direccion con ese id");
            }
        } catch (Exception ex) {
            result.Correct = false;
            result.Errormessage = ex.getLocalizedMessage();
            result.Ex = ex;
            result.statuscode = 500;
            return ResponseEntity.status(result.statuscode).body("Hubo un error en el servidor");
        }

    }

}
