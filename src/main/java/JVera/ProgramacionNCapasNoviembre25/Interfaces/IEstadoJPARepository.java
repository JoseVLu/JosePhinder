/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.Interfaces;

import JVera.ProgramacionNCapasNoviembre25.JPA.Estado;
import JVera.ProgramacionNCapasNoviembre25.JPA.Pais;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Alien 3 P9
 */
public interface IEstadoJPARepository extends JpaRepository<Estado, Integer>{
    
  @Query("SELECT idestado, nombre FROM Estado WHERE Estado.Pais.idpais = :idpais")  
  List<Estado>findAllByPais_IdPais(@Param("idpais") Integer pais);
     
}
