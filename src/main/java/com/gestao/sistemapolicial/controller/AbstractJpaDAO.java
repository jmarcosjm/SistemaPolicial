package com.gestao.sistemapolicial.controller;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDAO< T extends Serializable> {

    private Class< T > clazz;

    protected EntityManager entityManager;

    public final void setClazz( Class< T > clazzToSet, EntityManager entityManager){
        this.clazz = clazzToSet;
        this.entityManager = entityManager;
    }

    public T findOne( Integer id ){
        return entityManager.find( clazz, id );
    }
    public List< T > findAll(){
        String className = clazz.getName();
        return entityManager.createQuery( "from " + clazz.getName())
                .getResultList();
    }

    public T findByCpf(String cpf){
        String classname = clazz.getName();
        try{
            return (T) entityManager.createQuery("from " + clazz.getName() + " where cpf = :cpf")
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }

    }

    public void create( T entity ){
        entityManager.getTransaction().begin();
        entityManager.persist( entity );
        entityManager.getTransaction().commit();
    }

    public T update( T entity ){
        return entityManager.merge( entity );
    }

    public void delete( T entity ){
        entityManager.remove( entity );
    }
    
    public void deleteById( Integer entityId ){
        T entity = findOne( entityId );
        entityManager.getTransaction().begin();
        delete( entity );
        entityManager.getTransaction().commit();
    }
}