package puce.examenfinal.clases;

public class Candidate {
	
	private String nombreCandidato;
	private String partido;
	private int votos; 

	public String getNombreCandidato() {
		return nombreCandidato;
	}

	public void setNombreCandidato(String nombreCandidato) {
		this.nombreCandidato = nombreCandidato;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getVotos() {
		
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	
    public void aumentarVotos() {
        votos++;
    }
}
