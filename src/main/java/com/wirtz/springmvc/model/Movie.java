package com.wirtz.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;   
	private String name;

    @Min(value = 0, message = "Puntuacion debe ser mayor a 0")
    @Max(value = 10, message = "Puntuacion debe ser menor a 10")
    @Digits(fraction = 2, integer = 2)
    @NotNull
    private BigDecimal puntuacion;
    /*Minutes*/
    @Positive
    @NotNull
    private int duracion; 
    
    
    public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPuntuacion() {
		return puntuacion;
	}
	
	public double getPuntuacionDouble() {
		return puntuacion.doubleValue();
	}
	
	public void setPuntuacion(BigDecimal puntuacion) {
		this.puntuacion = puntuacion;
	}
	public Movie(long id, String name, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.puntuacion = price;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
    
    
}
