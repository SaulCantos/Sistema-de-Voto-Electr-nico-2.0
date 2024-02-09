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
import puce.examenfinal.clases.Mesa;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//aqui se agrega 
/*
public class PanelCrearMesas extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreMesa;
	private JTable table;
	private DefaultTableModel model;
	
	private Mesa mesa;
	private List <Mesa> mesas;



	public PanelCrearMesas( List<Mesa> mesas) {
		
		this.mesas = mesas;
		
		setTitle("AÑADE MESAS");
		setBounds(100, 100, 564, 392);
		getContentPane().setLayout(null);
		
		JLabel lblNombreMesa = new JLabel("Nombre de la mesa:");
		lblNombreMesa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreMesa.setBounds(19, 23, 120, 16);
		getContentPane().add(lblNombreMesa);
		
		txtNombreMesa = new JTextField();
		txtNombreMesa.setBounds(149, 22, 378, 20);
		getContentPane().add(txtNombreMesa);
		txtNombreMesa.setColumns(10);
		
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mesas" }));
		scrollPane.setViewportView(table);
		
		JButton btnAnadirCandidato = new JButton("Añadir");
		btnAnadirCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarMesa();
			}
		});
		btnAnadirCandidato.setBounds(214, 74, 120, 23);
		getContentPane().add(btnAnadirCandidato);
		
		JButton btnLimpiarCandidato = new JButton("Limpiar");
		btnLimpiarCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiarCandidato.setBounds(67, 74, 120, 23);
		getContentPane().add(btnLimpiarCandidato);
		
		JButton btnSalirCandidato = new JButton("Salir");
		btnSalirCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		btnSalirCandidato.setBounds(363, 74, 120, 23);
		getContentPane().add(btnSalirCandidato);
		
		model = (DefaultTableModel) table.getModel();
		agregarFila();
	}
	
	
	
	private void agregarMesa() {
		mesa = new Mesa();
		mesa.setnombreMesa(txtNombreMesa.getText());

		
		mesas.add(mesa);
		agregarFila();
		txtNombreMesa.setText("");
	}
	
	private void limpiarCampos() {
		txtNombreMesa.setText("");
	}

	
	private void agregarFila() {
		model.setRowCount(0);
		for (Mesa mesa : mesas) {
			Object[] fila = new Object[2];
			fila[0] = mesa.getnombreMesa();
			model.addRow(fila);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}*/
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;

public class PanelCrearMesas extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombreMesa;
    private JTable table;
    private DefaultTableModel model;
    private List<Mesa> mesas;

    public PanelCrearMesas(List<Mesa> mesas) {
    	getContentPane().setBackground(new Color(128, 128, 192));
    	setClosable(true);
        this.mesas = mesas;
        initComponents();
    }

    private void initComponents() {
        setTitle("Crear Mesas");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JLabel lblNombreMesa = new JLabel("Nombre de la Mesa:");
        lblNombreMesa.setBounds(29, 36, 150, 20);
        getContentPane().add(lblNombreMesa);

        txtNombreMesa = new JTextField();
        txtNombreMesa.setBounds(147, 36, 150, 20);
        getContentPane().add(txtNombreMesa);
        txtNombreMesa.setColumns(10);

        JButton btnAgregarMesa = new JButton("Agregar Mesa");
        btnAgregarMesa.setBounds(307, 35, 150, 23);
        btnAgregarMesa.addActionListener(this);
        getContentPane().add(btnAgregarMesa);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 83, 500, 267);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"Mesa"});
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("Limpiar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				limpiarCampos();

        	}
        });
        btnNewButton.setBounds(474, 35, 89, 23);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Crear mesas");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(239, 11, 97, 14);
        getContentPane().add(lblNewLabel);

        // Mostrar las mesas ya guardadas en la tabla al inicializar el panel
        mostrarMesas();
    }

    private void mostrarMesas() {
        for (Mesa mesa : mesas) {
            Object[] row = {mesa.getnombreMesa()};
            model.addRow(row);
        }
    }

    private void limpiarCampos() {
		txtNombreMesa.setText("");
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar Mesa")) {
            String nombreMesa = txtNombreMesa.getText();
            Mesa nuevaMesa = new Mesa();
            nuevaMesa.setnombreMesa(nombreMesa);
            mesas.add(nuevaMesa);
            Object[] row = {nombreMesa};
            model.addRow(row);
            txtNombreMesa.setText("");
        }
    }
}


