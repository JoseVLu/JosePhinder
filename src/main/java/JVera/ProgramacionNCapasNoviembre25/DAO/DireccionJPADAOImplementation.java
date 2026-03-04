///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package JVera.ProgramacionNCapasNoviembre25.DAO;
//
//import JVera.ProgramacionNCapasNoviembre25.Interfaces.IDireccionJPA;
//import JVera.ProgramacionNCapasNoviembre25.JPA.Direccion;
//import JVera.ProgramacionNCapasNoviembre25.JPA.Usuario;
//import JVera.ProgramacionNCapasNoviembre25.JPA.Result;
//import jakarta.persistence.EntityManager;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author Alien 3 P9
// */
//@Repository
//public class DireccionJPADAOImplementation implements IDireccionJPA {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    @Override
//    public Result GetById(int IsDireccion) {
//        Result result = new Result();
//        try {
//            Direccion direccionDb = entityManager.find(Direccion.class, IsDireccion);
//
//            if (direccionDb != null) {
//                result.Object = direccionDb;
//                result.Correct = true;
//                result.statuscode = 200;
//            } else {
//                result.Errormessage = "No se encontro la direccion";
//                result.statuscode = 404;
//            }
//        } catch (Exception ex) {
//            result.Correct = false;
//            result.Errormessage = ex.getLocalizedMessage();
//            result.Ex = ex;
//            result.statuscode = 400;
//        }
//        return result;
//    }
//
//    @Override
//    @Transactional
//    public Result Delete(int IsDireccion) {
//        Result result = new Result();
//        try {
//
//            Direccion direccionDb = entityManager.find(Direccion.class, IsDireccion);
//            if (direccionDb != null) {
//                // 2. Eliminas directamente el objeto que devolvió el EntityManager
//                entityManager.remove(direccionDb);
//
//                result.Correct = true;
//                result.statuscode = 200;
//            } else {
//                result.Correct = false;
//                result.Errormessage = "No se encontró la dirección con el ID proporcionado.";
//                result.statuscode = 404;
//            }
//        } catch (Exception ex) {
//            result.Correct = false;
//            result.Errormessage = ex.getLocalizedMessage();
//            result.Ex = ex;
//            result.statuscode = 400;
//        }
//        return result;
//    }
//
//    @Transactional
//    @Override
//    public Result Add(Direccion direccion, int IsUsuario) {
//        Result result = new Result();
//
//            direccion.Usuario = new Usuario();
//            Usuario usuarioDb = entityManager.find(Usuario.class, IsUsuario);
//            if(usuarioDb != null)
//            {
//            direccion.Usuario = usuarioDb;
//            entityManager.persist(direccion);
//            result.statuscode = 200;
//            result.Correct = true;
//            }
//            else{
//                 result.Correct = false;
//                result.statuscode = 404;
//                result.Errormessage = "No se encontro el usuario que se quiere añadir direccion";
//            }
//        
//
//        return result;
//    }
//
//    @Transactional
//    @Override
//    public Result Update(Direccion direccion) {
//        Result result = new Result();
//
//        try {
//            Direccion direccionDb = entityManager.find(Direccion.class, direccion.getIdDireccion());
//            if (direccionDb != null) {
//                direccion.Usuario = direccionDb.Usuario;
//                entityManager.merge(direccion);
//                result.statuscode = 200;
//                result.Correct = true;
//            } else {
//                result.Correct = false;
//                result.statuscode = 404;
//                result.Errormessage = "No se encontro la direccion";
//            }
//
//        } catch (Exception ex) {
//            result.Correct = false;
//            result.Errormessage = ex.getLocalizedMessage();
//            result.Ex = ex;
//            result.statuscode = 400;
//        }
//        return result;
//    }
//
//}
