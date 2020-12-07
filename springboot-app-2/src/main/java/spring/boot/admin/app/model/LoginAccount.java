package spring.boot.admin.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Usuarios")
public class LoginAccount implements Serializable 
{
	private static final long seriaVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String password;
	
	@NotNull
	@Column(name = "dteAcceso_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date accesoAt;
	
	@PrePersist
	public void prePersist()
	{
		accesoAt = new Date();
	}
	
	public LoginAccount()
	{
		
	}
	
	public LoginAccount(String email, String password)
	{
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getAccesoAt() {
		return accesoAt;
	}

	public void setAccesoAt(Date accesoAt) {
		this.accesoAt = accesoAt;
	}

	public static long getSeriaversionuid() {
		return seriaVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
