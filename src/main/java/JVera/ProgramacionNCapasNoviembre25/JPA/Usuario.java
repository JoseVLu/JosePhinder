/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.JPA;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int IdUsuario;

    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "apellido_p")
    private String ApellidoPaterno;

    @Column(name = "apellido_m")
    private String ApellidoMaterno;

    @Column(name = "edad")
    private int Edad;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Direccion> direcciones = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "hobbieusuario", 
            joinColumns = @JoinColumn(name = "id_usuario"), 
            inverseJoinColumns = @JoinColumn(name = "id_hobbie") 
    )
    private List<Hobbie> hobbies = new ArrayList<>();


    public List<Hobbie> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobbie> hobbies) {
        this.hobbies = hobbies;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }
    
    

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

}
