package spring.boot.admin.app.infraestructure;

import org.springframework.data.repository.CrudRepository;

import spring.boot.admin.app.model.ProductRegister;

public interface IProducto extends CrudRepository<ProductRegister, Long>{

}
