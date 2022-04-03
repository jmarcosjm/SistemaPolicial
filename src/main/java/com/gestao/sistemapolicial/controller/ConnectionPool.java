package com.gestao.sistemapolicial.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionPool {
    public static CrimeDAO crimeDAO;
    public static CriminosoDAO criminosoDAO;
    public static VitimaDAO vitimaDAO;
    public static ArmaDAO armaDAO;
    public static CriminosoCrimeDAO criminosoCrimeDAO;
    public static ArmaCriminosoCrimeDAO armaCriminosoCrimeDAO;
    public static VitimaCriminosoCrimeDAO vitimaCriminosoCrimeDAO;

    public static EntityManager entityManager;

    public static void initPool(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpadao");
        ConnectionPool.entityManager = entityManagerFactory.createEntityManager();
        ConnectionPool.crimeDAO = new CrimeDAO(entityManager);
        ConnectionPool.criminosoDAO = new CriminosoDAO(entityManager);
        ConnectionPool.vitimaDAO = new VitimaDAO(entityManager);
        ConnectionPool.armaDAO = new ArmaDAO(entityManager);
        ConnectionPool.criminosoCrimeDAO = new CriminosoCrimeDAO(entityManager);
        ConnectionPool.armaCriminosoCrimeDAO = new ArmaCriminosoCrimeDAO(entityManager);
        ConnectionPool.vitimaCriminosoCrimeDAO = new VitimaCriminosoCrimeDAO(entityManager);
    }

}
