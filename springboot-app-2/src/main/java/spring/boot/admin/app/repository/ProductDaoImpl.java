package spring.boot.admin.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import spring.boot.admin.app.model.ProductRegister;

public class ProductDaoImpl 
{
	@PersistenceContext
	private EntityManager em;
	
	public void delete(Long id) {
		
	}
	
	public String listarPro(Model model) {
		return null;
	}

	public int savePro(ProductRegister p) {
		return 0;
	}

	@Transactional
	public void saveRegisterPro(ProductRegister register) {
		if(register.getId() != null && register.getId()>0) 
		{
			em.merge(register);
		}
		else 
		{
			em.persist(register);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<ProductRegister> findAllPro() 
	{
		return em.createQuery("from ProductRegister").getResultList();
	}

	public ProductRegister findByIdPro(Long id) {
		return em.find(ProductRegister.class, id);
	}
}
