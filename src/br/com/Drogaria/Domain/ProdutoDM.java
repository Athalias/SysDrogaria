package br.com.Drogaria.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoDM {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	private String descricao;
	private int quantidade;
	private Double preco;
	@OneToOne
	@JoinColumn(name = "codigo_fabricante")
	private FabricanteDM codigoFabricante;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public FabricanteDM getCodigoFabricante() {
		return codigoFabricante;
	}

	public void setCodigoFabricante(FabricanteDM codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}
}
