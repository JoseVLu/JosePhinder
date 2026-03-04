/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.Interfaces;

import JVera.ProgramacionNCapasNoviembre25.JPA.Municipio;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;



public interface IMunicipioJPARepository extends JpaRepository<Municipio, Integer>{
    
  @Query("SELECT idmunicipio, nombre FROM Municipio WHERE Municipio.Estado.idestado = :idestado")  
  List<Municipio>findAllByEstado_IdEstado(@Param("idestado") Integer estado);
     
}