package com.assessment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.assessment.model.Product;

public class ProductDao {

	private EntityManagerFactory entityManagerFactory;

	public void create(Product p) {

		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();

		em.persist(p);

		em.getTransaction().commit();
	}

	public List<Product> findAll() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		List<Product> products = em.createQuery("select p from Product p", Product.class).getResultList();

		return products;
	}

	public Product find(long id) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Product p = em.find(Product.class, id);
		
		return p;
	}
	
	public Product update(long id, String name,int price,int quantity) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Product p = em.find(Product.class, id);
		p.setName(name);
		p.setPrice(price);
		p.setQuantity(quantity);
		em.getTransaction().commit();
		return p;
	}
	
	public void delete(long id) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(em.find(Product.class, id));
		
		em.getTransaction().commit();
	}
}