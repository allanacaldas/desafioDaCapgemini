package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Anuncio {
	private String nomeDoAnuncio;
	private Cliente cliente;
	private Date dataInicio;
	private Date dataTermino;
	private double investimentoPorDia;

	public Anuncio() {

	}

	public Anuncio(String nome, Cliente cliente, Date dataInicio, Date dataTermino, double investimentoPorDia) {
		this.nomeDoAnuncio = nome;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.investimentoPorDia = investimentoPorDia;
	}

	public String getNomeDoAnuncio() {
		return nomeDoAnuncio;
	}

	public void setNomeDoAnuncio(String nomeDoAnuncio) {
		this.nomeDoAnuncio = nomeDoAnuncio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public double getInvestimentoPorDia() {
		return investimentoPorDia;
	}

	public long duracaoEmDias() {
		long periodo = dataTermino.getTime() - dataInicio.getTime();
		return TimeUnit.DAYS.convert(periodo, TimeUnit.MILLISECONDS);
	}

	public double valorTotalInvestido() {
		return getInvestimentoPorDia() * duracaoEmDias();
	}

	public double getOriginalViews() {
		return valorTotalInvestido() * 30;
	}

	public double quantidadeMaximaDeCliques() {
		return getOriginalViews() * 0.12;
	}

	public double quantidadeMaximaDeCompartilhamentos() {
		double compartilhamentos = quantidadeMaximaDeCliques() * 0.15;
		BigDecimal bigDecimal = new BigDecimal(compartilhamentos).setScale(0, RoundingMode.HALF_EVEN);
		return bigDecimal.doubleValue();
	}

	public double quantidadeMaximaDeViews() {
		double novasViews = 0;

		for (int i = 0; i < quantidadeMaximaDeCompartilhamentos(); i++) {
			for (int j = 1; j < 4; j++) {
				novasViews += 40;
			}
		}
		return novasViews + this.getOriginalViews();
	}

	public String toString() {
		return "O anúncio '" + getNomeDoAnuncio() + "' teve um total de valor investido de R$ " + valorTotalInvestido()
				+ " e obteve um total de " + String.format("%.0f", quantidadeMaximaDeCliques()) + " cliques, de "
				+ String.format("%.0f", quantidadeMaximaDeCompartilhamentos()) + " compartilhamentos e um total de "
				+ String.format("%.0f", quantidadeMaximaDeViews()) + " views";

	}

}
