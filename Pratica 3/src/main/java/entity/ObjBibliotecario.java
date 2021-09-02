package entity;

import interfaces.ObjBiblioInterface;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

public abstract class ObjBibliotecario implements ObjBiblioInterface {

    ObjBibliotecario(){

    }

    public abstract void incluir(EntityManager entityManager);

}
