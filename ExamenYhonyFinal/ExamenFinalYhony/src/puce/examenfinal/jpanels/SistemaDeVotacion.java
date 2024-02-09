package puce.examenfinal.jpanels;

import java.awt.EventQueue;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import puce.examenfinal.clases.Candidate;
import puce.examenfinal.clases.Curso;
import puce.examenfinal.clases.Estudiante;
import puce.examenfinal.clases.Mesa;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SistemaDeVotacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List <Candidate> candidatos;
	private List <Curso> cursos;
	private List <Estudiante> estudiantes;
	private List<Estudiante> estudiantesMesa;
	private List <Mesa> mesas;
	
    private Map<Estudiante, Mesa> asignacionesDeMesa;
    private Estudiante estudiante;
    
    private Map<String, Candidate> votosPorEstudiante;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaDeVotacion frame = new SistemaDeVotacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SistemaDeVotacion() {
		setBackground(new Color(128, 128, 128));
		
		candidatos = new ArrayList<>(); 
		cursos = new ArrayList<>(); 
		estudiantes = new ArrayList<>();
		mesas = new ArrayList<>(); 
		estudiantesMesa = new ArrayList<>();
        asignacionesDeMesa = new HashMap<>();

        this.votosPorEstudiante = new HashMap<>();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 697);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 128, 192));
		menuBar.setForeground(new Color(192, 192, 192));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setBackground(new Color(128, 128, 128));
		mnArchivo.setForeground(new Color(0, 0, 0));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setBackground(new Color(128, 128, 128));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAdministracion = new JMenu("Administración");
		mnAdministracion.setForeground(new Color(0, 0, 0));
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmMesas = new JMenuItem("Mesas");
		mntmMesas.setBackground(new Color(128, 128, 128));
		mntmMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelEleccionMesas panelEleccionMesas = new PanelEleccionMesas(mesas, estudiantes);
		        contentPane.add(panelEleccionMesas);
		        panelEleccionMesas.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmMesas);
		
		JMenuItem mntmCursos = new JMenuItem("Cursos");
		mntmCursos.setBackground(new Color(128, 128, 128));
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PanelCurso panelCurso = new PanelCurso(cursos);
			        contentPane.add(panelCurso);
			        panelCurso.setVisible(true);
			}
		});
		mnAdministracion.add(mntmCursos);
		
		JMenuItem mntmEstudiantes = new JMenuItem("Estudiantes");
		mntmEstudiantes.setBackground(new Color(128, 128, 128));
		mntmEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  PanelEstudiantes panelEstudiantes = new PanelEstudiantes(cursos , estudiantes);
			        contentPane.add(panelEstudiantes);
			        panelEstudiantes.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmEstudiantes);
		
		JMenuItem mntmCandidatos = new JMenuItem("Candidatos");
		mntmCandidatos.setBackground(new Color(128, 128, 128));
		mntmCandidatos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        PanelCandidatos panelCandidatos = new PanelCandidatos(candidatos);
		        contentPane.add(panelCandidatos);
		        panelCandidatos.setVisible(true);
		    }
		});
		

		mnAdministracion.add(mntmCandidatos);
		
		
		mnAdministracion.add(mntmCandidatos);
		
		JMenu mnProceso = new JMenu("Proceso");
		mnProceso.setForeground(new Color(0, 0, 0));
		menuBar.add(mnProceso);
		
		JMenuItem mntmSufragar = new JMenuItem("Sufragar");
		mntmSufragar.setBackground(new Color(128, 128, 128));
		mntmSufragar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Sufragar sufragar = new Sufragar(SistemaDeVotacion.this);
		        contentPane.add(sufragar);
		        sufragar.setVisible(true);
				
			}
		});
		mnProceso.add(mntmSufragar);
		
				
		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setForeground(new Color(0, 0, 0));
		menuBar.add(mnReportes);
		
		JMenuItem mntmPadron = new JMenuItem("Padrón Electoral");
		mntmPadron.setBackground(new Color(128, 128, 128));
		mntmPadron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPadronElectoral panelPadronElectoral = new PanelPadronElectoral(
						mesas,
						estudiantes,
						estudiantesMesa);
				contentPane.add(panelPadronElectoral);
				panelPadronElectoral.setVisible(true);
			}
		});
		mnReportes.add(mntmPadron);
		
		JMenuItem mntmResultadosGenerales = new JMenuItem("Resultados Generales");
		mntmResultadosGenerales.setBackground(new Color(128, 128, 128));
		mntmResultadosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelResultadosGenerales resultadosGenerales = new PanelResultadosGenerales(candidatos);
		        contentPane.add(resultadosGenerales);
		        resultadosGenerales.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosGenerales);
		
		JMenuItem mntmResultadosPorMesas = new JMenuItem("Resultados por Mesas");
		mntmResultadosPorMesas.setBackground(new Color(128, 128, 128));
		mntmResultadosPorMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelResultadosPorMesa resultadosMesas = new PanelResultadosPorMesa(candidatos, mesas);
		        contentPane.add(resultadosMesas);
		        resultadosMesas.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosPorMesas);
		
		JMenuItem mntmResultadosEnGrfico = new JMenuItem("Resultados en Gráfico");
		mntmResultadosEnGrfico.setBackground(new Color(128, 128, 128));
		mntmResultadosEnGrfico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelGraficos panelGraficos = new PanelGraficos(candidatos);
		        contentPane.add(panelGraficos);
		        panelGraficos.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosEnGrfico);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 157, 206));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	}

	
	void abrirSufragar2(String cedulaEstudiante) {
	    SufragarP2 sufragarP2 = new SufragarP2(this, cedulaEstudiante);
	    sufragarP2.setLocation(100, 100);
	    contentPane.add(sufragarP2);
	    sufragarP2.setVisible(true);
	}


void abrirSufragar3() {
    
    SufragarP3 sufragarP3 = new SufragarP3();

    sufragarP3.setLocation(100, 100);

    contentPane.add(sufragarP3);
    sufragarP3.setVisible(true);
}

public List<Estudiante> getEstudiantes() {
    return estudiantes;
}

public Mesa getMesaDeEstudiante(Estudiante estudiante) {
    return asignacionesDeMesa.get(estudiante);
}

public Mesa getMesaPorNombre(String nombreMesa) {
    for (Mesa mesa : mesas) {
        if (mesa.getnombreMesa().equals(nombreMesa)) {
            return mesa;
        }
    }
    return null; 
}

public void asignarMesaAEstudiante(Estudiante estudiante, Mesa mesa) {
    asignacionesDeMesa.put(estudiante, mesa);
}


public List<Candidate> getCandidatos() {
    return candidatos;
}

public void registrarVoto(String cedulaEstudiante, Candidate candidato) {
    votosPorEstudiante.put(cedulaEstudiante, candidato);
}

public boolean estudianteYaVoto(String cedulaEstudiante) {
    return votosPorEstudiante.containsKey(cedulaEstudiante);
}

public Candidate getCandidatoVotadoPorEstudiante(String cedulaEstudiante) {
    return votosPorEstudiante.get(cedulaEstudiante);
}

}

