/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JVera.ProgramacionNCapasNoviembre25.ML;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

/**
 *
 * @author Alien 3 P9
 */
public class Result<T> {
    public boolean Correct;
    public String Errormessage;
    public T Object;
    public List<Object> Objects;
    public Exception Ex;
    
        @JsonIgnore
    public int statuscode;
}
