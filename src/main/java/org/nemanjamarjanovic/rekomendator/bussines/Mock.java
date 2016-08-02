//package org.nemanjamarjanovic.rekomendator.bussines;
//
//import java.util.HashSet;
//import java.util.Set;
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.ejb.Singleton;
//import javax.ejb.Startup;
//import javax.ejb.TransactionManagement;
//import javax.ejb.TransactionManagementType;
//import org.nemanjamarjanovic.rekomendator.bussines.movie.boundary.MoviesDao;
//import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Actor;
//import org.nemanjamarjanovic.rekomendator.bussines.movie.entity.Genre;
//import org.nemanjamarjanovic.rekomendator.bussines.security.boundary.SecurityDao;
//import org.nemanjamarjanovic.rekomendator.bussines.user.boundary.UserDao;
//import org.nemanjamarjanovic.rekomendator.bussines.user.entity.User;
//
///**
// *
// * @author nemanja.marjanovic
// */
//@Singleton
////@Startup
//@TransactionManagement(TransactionManagementType.BEAN)
//public class Mock
//{
//
//    @EJB
//    SecurityDao securityDao;
//
//    @EJB
//    UserDao userDao;
//
//    @EJB
//    MoviesDao moviesDao;
//
//    @PostConstruct
//
//    public void createMockData()
//    {
//        securityDao.createRole("GUEST");
//        securityDao.createRole("USER");
//        securityDao.createRole("SUPER");
//        securityDao.createRole("ADMIN");
//
//        securityDao.createPermission("MOVIES-LIST");
//        securityDao.createPermission("MOVIES-DETAILS");
//        securityDao.createPermission("ADMIN");
//    }
//
//    public void createMockData1()
//    {
//        securityDao.addPermissionToRole("GUEST", "MOVIES-LIST");
//        securityDao.addPermissionToRole("USER", "MOVIES-LIST");
//        securityDao.addPermissionToRole("USER", "MOVIES-DETAILS");
//        securityDao.addPermissionToRole("SUPER", "MOVIES-LIST");
//        securityDao.addPermissionToRole("SUPER", "MOVIES-DETAILS");
//        securityDao.addPermissionToRole("ADMIN", "ADMIN");
//
//    }
//
//    public void createMockData2()
//    {
//        User nemanja = userDao.create("nemanja");
//        User dane = userDao.create("dane");
//        User jelena = userDao.create("jelena");
//
//        securityDao.addRoleToUser("GUEST", nemanja.getId());
//        securityDao.addRoleToUser("USER", dane.getId());
//        securityDao.addRoleToUser("ADMIN", jelena.getId());
//    }
//
//    public void createMockData4()
//    {
//        Genre scifi = moviesDao.createGenre("SCI-FI");
//        Genre horor = moviesDao.createGenre("ACTION");
//
//        Actor actor1 = moviesDao.createActor("Kianu Rivs");
//        Actor actor2 = moviesDao.createActor("Monika Beluci");
//
//        Set<Genre> matrixGenres = new HashSet<>(10);
//        matrixGenres.add(scifi);
//        matrixGenres.add(horor);
//
//        Set<Actor> matrixActors = new HashSet<>(10);
//        matrixActors.add(actor1);
//        matrixActors.add(actor2);
//
//        moviesDao.createMovie("Matrix 2", matrixGenres, matrixActors);
//    }
//}
