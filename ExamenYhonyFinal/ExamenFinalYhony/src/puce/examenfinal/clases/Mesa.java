package puce.examenfinal.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mesa {
	
	private String nombreMesa;
	private List <Estudiante> estudiantesDeMesa;
	

	
	 public Mesa() {
	        this.estudiantesDeMesa = new ArrayList<>();

	    }
	
	public String getnombreMesa() {
		return nombreMesa;
	}
	public void setnombreMesa(String nombreMesa) {
		this.nombreMesa = nombreMesa;
	}
	public List <Estudiante> getEstudiantesDeMesa() {
		return estudiantesDeMesa;
	}
	public void setEstudiantesDeMesa(List <Estudiante> estudiantesDeMesa) {
		this.estudiantesDeMesa = estudiantesDeMesa;
	}
	
	
	

}
