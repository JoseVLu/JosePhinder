/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/**
 *
 * @author Alien 3 P9
 */
@Entity
@Table(name = "HOBBIE")
public class Hobbie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hobbie")
    private int idhobbie;
    
    @Column(name = "nombre")
    private String Nombre;

    public int getIdhobbie() {
        return idhobbie;
    }

    public void setIdhobbie(int idhobbie) {
        this.idhobbie = idhobbie;
    }


    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
}