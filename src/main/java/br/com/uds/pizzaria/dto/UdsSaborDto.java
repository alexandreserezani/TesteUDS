package br.com.uds.pizzaria.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.uds.pizzaria.domain.UdsSabor;

public class UdsSaborDto {

	private Long id;
	
	private String codigo;
	
	private String descricao;
	
	private Integer tempo;

	public UdsSaborDto(UdsSabor obj) {
		this.id = obj.getId();
		this.codigo = obj.getCodigo();
		this.descricao = obj.getDescricao();
		this.tempo = obj.getTempo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}
	
	public static List<UdsSaborDto> converter(List<UdsSabor> obj){
		return obj.stream().map(UdsSaborDto::new).collect(Collectors.toList());
	}
	
}
