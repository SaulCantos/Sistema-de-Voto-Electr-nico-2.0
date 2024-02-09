package puce.examenfinal.jpanels;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class SufragarP3 extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
    private SistemaDeVotacion sistemaDeVotacion;
    private JTextField txtSufragar;


	public SufragarP3() {
		getContentPane().setBackground(new Color(181, 181, 219));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		
		JButton btnSALIR = new JButton("Salir");
		btnSALIR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSALIR.setBounds(0, 241, 434, 29);
		btnSALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnSALIR);
		
		JLabel lblGracias = new JLabel("¡Gracias por votar!");
		lblGracias.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGracias.setBounds(131, 76, 249, 70);
		getContentPane().add(lblGracias);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
