package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.marcionielsen.cursomc.domain.enums.TipoCliente;

@Entity
@Table(name="CLIENTES", 
       indexes = { @Index(name = "UK_NM_CLIENTE", columnList = "NM_CLIENTE", unique = true),
		@Index(name = "UK_CD_CPF_CNPJ_CLIENTE", columnList = "CD_CPF_CNPJ_CLIENTE", unique = true),
		@Index(name = "IDX_NM_CLIENTE", columnList = "NM_CLIENTE", unique = false),
		@Index(name = "IDX_CD_CPF_CNPJ_CLIENTE", columnList = "CD_CPF_CNPJ_CLIENTE", unique = false) })
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CD_CLIENTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NM_CLIENTE", nullable = false)
	private String nome;
	
	@Column(name = "DS_EMAIL_CLIENTE", nullable = true)
	private String email;
	
	@Column(name = "CD_CPF_CNPJ_CLIENTE", nullable = false)
	private String cpfCnpj;

	@Column(name = "CD_TIPO_PESSOA", nullable = false)
	private Integer tipo;

	@JsonManagedReference
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name="TELEFONES_CLIENTE", joinColumns = @JoinColumn(name = "CD_CLIENTE", nullable = true, referencedColumnName="CD_CLIENTE", foreignKey = @ForeignKey(name = "FK_TELEFONES_CD_CLIENTE")), 
	           foreignKey = @ForeignKey(name = "FK_TELEFONES_CD_CLIENTE") )
	private Set<String> telefones = new HashSet<>();

	@JsonBackReference
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {
		super();
	}

	public Cliente(Long id, String nome, String email, String cpfCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipo = tipo.getCodigo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCodigo();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", cpfCnpj=" + cpfCnpj + ", tipo=" + tipo
				+ "-" + TipoCliente.toEnum(tipo).getDescricao() + ", enderecos=" + enderecos + ", telefones="
				+ telefones + "]";
	}
	
}
