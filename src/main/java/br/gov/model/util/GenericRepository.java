package br.gov.model.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericRepository<PK, T> {
	
    @PersistenceContext
	protected EntityManager entity;
 
    @SuppressWarnings("unchecked")
	public T obterPorID(PK pk) {
        return (T) entity.find(getTypeClass(), pk);
    }
 
    public void salvar(T object) {
        entity.persist(object);
    }
 
    public void atualizar(T object) {
        entity.merge(object);
    }
 
    public void excluir(PK pk) {
        entity.remove(obterPorID(pk));
    }
 
    @SuppressWarnings("unchecked")
	public List<T> obterLista() {
        return entity.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}