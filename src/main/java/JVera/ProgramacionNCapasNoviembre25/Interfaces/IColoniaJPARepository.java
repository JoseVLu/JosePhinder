/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.Interfaces;

/**
 *
 * @author Alien 3 P9
 */
import JVera.ProgramacionNCapasNoviembre25.JPA.Colonia;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;



public interface IColoniaJPARepository extends JpaRepository<Colonia, Integer>{
    
  @Query("SELECT idcolonia, nombre FROM Colonia WHERE Colonia.Municipio.idmunicipio = :idmunicipio")  
  List<Colonia>findAllByMunicipio_IdMunicipio(@Param("idmunicipio") Integer municipio);
     
}