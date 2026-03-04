
package JVera.ProgramacionNCapasNoviembre25.Interfaces;

import JVera.ProgramacionNCapasNoviembre25.JPA.Usuario;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface IUsuarioJPARepository extends JpaRepository<Usuario, Integer>{

}
