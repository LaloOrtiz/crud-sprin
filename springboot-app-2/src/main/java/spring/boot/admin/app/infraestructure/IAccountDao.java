package spring.boot.admin.app.infraestructure;

import java.util.List;

import spring.boot.admin.app.model.LoginAccount;
import spring.boot.admin.app.model.ProductRegister;
import spring.boot.admin.app.model.RegistrerAccount;

public interface IAccountDao 
{
	public void save(LoginAccount account);
	public boolean AccountValidate(LoginAccount account);
	public void saveRegister(RegistrerAccount register);
	public List<RegistrerAccount> findAll();
	public RegistrerAccount findById(Long id);
	
	
	public void saveRegisterPro(ProductRegister register);
	public List<ProductRegister> findAllPro();
	public ProductRegister findByIdPro(Long id);
	public void delete(Long id);
}
