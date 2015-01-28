package allanfreitas.webapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
public class Usuario implements Serializable{
	
	@Id @Generated(GenerationTime.INSERT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@NotNull @NotEmpty
	@Column(name="nome", nullable=false, length=128)
	private String nome;
	
	@Email(message="Isto não é um e-mail") @NotNull @NotEmpty
	@Column(name="email", nullable=false, length=128, unique=true)
	private String email;
	
	@NotNull
	@Column(name="data_cadastro", nullable=false) @Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();
	
	@Size(min=8, max=32, message="Login muito curto ou muito longo") 
	@Column(name="login", nullable=false, unique=true, length=64)
	private String login;
	
	private transient String senha;
	@Column(name="ultimo_login", nullable=true) @Temporal(TemporalType.TIMESTAMP)
	private Date ultimoLogin;
	
	@Column(name="hash_senha", nullable=false, length=128)
	private String hashSenha;
	
	@OneToMany(mappedBy = "usuario", targetEntity = PermissaoUsuario.class,
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PermissaoUsuario> permissoes;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		setHashSenha(org.apache.commons.codec.digest.DigestUtils.sha256Hex(senha));
		this.senha = senha;
	}

	/**
	 * @return the ultimoLogin
	 */
	public Date getUltimoLogin() {
		return ultimoLogin;
	}

	/**
	 * @param ultimoLogin the ultimoLogin to set
	 */
	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

	/**
	 * @return the hashSenha
	 */
	public String getHashSenha() {
		return hashSenha;
	}

	/**
	 * @param hashSenha the hashSenha to set
	 */
	public void setHashSenha(String valor) {
		this.hashSenha = valor;
	}
	
	public List<PermissaoUsuario> getPermissoesUsuario(){
		return permissoes;
	}
	
	public void setListaPermissoesUsuario(List<PermissaoUsuario> permissoes){
		this.permissoes = permissoes;
	}
}
