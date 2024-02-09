package puce.examenfinal.jpanels;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import puce.examenfinal.clases.Curso;
import puce.examenfinal.clases.Estudiante;
import puce.examenfinal.clases.Mesa;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PanelAñadirEstMesa extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private DefaultTableModel model;
	private JComboBox<Mesa> comboBox;
	private JComboBox<Estudiante> comboBox2;

	private Mesa mesa;

	private List<Mesa> mesas;
	private List <Estudiante> estudiantes;
	private List <Estudiante> estudiantesDeMesa;



	public PanelAñadirEstMesa(List<Mesa> mesas, List<Estudiante>estudiantes, List <Estudiante> estudiantesDeMesa) {
		getContentPane().setBackground(new Color(128, 128, 192));

		this.mesas = mesas;
		this.estudiantes = estudiantes;
		this.estudiantesDeMesa = estudiantesDeMesa;
		
		setTitle("Añadir Estudiantes a mesa");
		setBounds(10, 11, 647, 398);
		getContentPane().setLayout(null);
		
		JLabel lblNombreMesa = new JLabel("Mesa:");
		lblNombreMesa.setBounds(25, 24, 46, 14);
		getContentPane().add(lblNombreMesa);
		
		comboBox = new JComboBox<>();

		DefaultComboBoxModel<Mesa> comboBoxModel = new DefaultComboBoxModel<>(
		mesas.toArray(new Mesa[0]));
		comboBox.setModel(comboBoxModel);
		
				comboBox.setRenderer(new DefaultListCellRenderer() {
					@Override
					public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
							boolean cellHasFocus) {
						if (value instanceof Mesa) {
							Mesa mesa = (Mesa) value;
							value = mesa.getnombreMesa();
						}
						return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					}
				});

				comboBox.setBounds(63, 19, 132, 24);
				getContentPane().add(comboBox);
		
		
		
		JLabel lblEstudiante = new JLabel("Estudiante");
		lblEstudiante.setBounds(242, 24, 100, 14);
		getContentPane().add(lblEstudiante);
		
				comboBox2 = new JComboBox<>();

				DefaultComboBoxModel <Estudiante> comboBoxModel1 = new DefaultComboBoxModel<>(
				estudiantes.toArray(new Estudiante[0]));
				comboBox2.setModel(comboBoxModel1);
								
		
						comboBox2.setRenderer(new DefaultListCellRenderer() {
							@Override
							public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
									boolean cellHasFocus) {
								if (value instanceof Estudiante) {
									Estudiante estudiante = (Estudiante) value;
									value = estudiante.getNombreEstudiante();
								}
								return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
							}
						});

						comboBox2.setBounds(312, 19, 132, 24);
						getContentPane().add(comboBox2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 77, 546, 246);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Estudiante", "Mesa"}));
		scrollPane.setViewportView(table);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(278, 334, 89, 23);
		getContentPane().add(btnSalir);
		model = (DefaultTableModel) table.getModel();

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEstudianteAMesa();
			}
		});
		btnAgregar.setBounds(479, 20, 89, 23);
		getContentPane().add(btnAgregar);

	}
	
	private void agregarEstudianteAMesa() {
	    Mesa mesaSeleccionada = (Mesa) comboBox.getSelectedItem();
	    
	    Object estudianteSeleccionadoObj = comboBox2.getSelectedItem();
	    
	    if (mesaSeleccionada != null && estudianteSeleccionadoObj != null) {
	        Estudiante estudianteSeleccionado = (Estudiante) estudianteSeleccionadoObj;
	     
	        if (estudianteSeleccionado.getMesaDelEstudiante() == null) {
	            mesaSeleccionada.getEstudiantesDeMesa().add(estudianteSeleccionado);
	            estudianteSeleccionado.setMesaDelEstudiante(mesaSeleccionada);
	           
	            agregarFila(mesaSeleccionada.getnombreMesa(), estudianteSeleccionado.getNombreEstudiante());
	        } else {
	            System.out.println("El estudiante ya está asignado a una mesa.");
	        }
	    } else {
	        System.out.println("Mesa o estudiante seleccionado es nulo");
	    }
	}


	private void agregarFila(String nombreMesa, String nombreEstudiante) {
	    model.addRow(new Object[]{nombreEstudiante, nombreMesa});
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
