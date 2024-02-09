package puce.examenfinal.clases;

import java.util.List;


public class Curso {
	
	private String nombreCurso;
	private List <Estudiante> estudiantesCurso;
	
	

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public List <Estudiante> getEstudiantesCurso() {
		return estudiantesCurso;
	}

	public void setEstudiantesCurso(List <Estudiante> estudiantesCurso) {
		this.estudiantesCurso = estudiantesCurso;
	}

}
