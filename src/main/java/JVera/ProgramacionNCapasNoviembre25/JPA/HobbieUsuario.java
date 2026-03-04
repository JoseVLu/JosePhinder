/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.JPA;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alien 3 P9
 */

@Entity
@Table(name = "HOBBIEUSUARIO")
public class HobbieUsuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hobbieusuario")
    private int idhobbieusuario;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    public Usuario usuario = new Usuario();
    
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "id_hobbie")
    public Hobbie hobbie = new Hobbie();

    public int getIdhobbieusuario() {
        return idhobbieusuario;
    }

    public void setIdhobbieusuario(int idhobbieusuario) {
        this.idhobbieusuario = idhobbieusuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Hobbie getHobbie() {
        return hobbie;
    }

    public void setHobbie(Hobbie hobbie) {
        this.hobbie = hobbie;
    }

    
    
    
    
}
