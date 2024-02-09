package puce.examenfinal.jpanels;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import puce.examenfinal.clases.Curso;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PanelCurso extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreCurso;
	private JTable table;
	private DefaultTableModel model;
	
	private Curso curso;
	private List <Curso> cursos;

	public PanelCurso( List<Curso> cursos) {
		getContentPane().setBackground(new Color(128, 128, 192));
		
		this.cursos = cursos;
		
		setTitle("Añade Cursos");
		setBounds(100, 100, 564, 392);
		getContentPane().setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombre del curso:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombres.setBounds(30, 23, 120, 16);
		getContentPane().add(lblNombres);
		
		txtNombreCurso = new JTextField();
		txtNombreCurso.setBounds(141, 22, 378, 20);
		getContentPane().add(txtNombreCurso);
		txtNombreCurso.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 127, 416, 224);
		getContentPane().add(scrollPane);

		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cursos" }));
		scrollPane.setViewportView(table);
		
		JButton btnAnadirCandidato = new JButton("Añadir");
		btnAnadirCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCurso();
			}
		});
		btnAnadirCandidato.setBounds(214, 81, 120, 23);
		getContentPane().add(btnAnadirCandidato);
		
		JButton btnLimpiarCandidato = new JButton("Limpiar");
		btnLimpiarCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiarCandidato.setBounds(67, 81, 120, 23);
		getContentPane().add(btnLimpiarCandidato);
		
		JButton btnSalirCandidato = new JButton("Salir");
		btnSalirCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		btnSalirCandidato.setBounds(363, 81, 120, 23);
		getContentPane().add(btnSalirCandidato);
		
		model = (DefaultTableModel) table.getModel();
		agregarFila();
	}
	
	
	
	private void agregarCurso() {
		curso = new Curso();
		curso.setNombreCurso(txtNombreCurso.getText());

		
		cursos.add(curso);
		agregarFila();
		txtNombreCurso.setText("");
	}
	
	private void limpiarCampos() {
		txtNombreCurso.setText("");
	}

	
	private void agregarFila() {
		model.setRowCount(0);
		for (Curso curso : cursos) {
			Object[] fila = new Object[2];
			fila[0] = curso.getNombreCurso();
			model.addRow(fila);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

