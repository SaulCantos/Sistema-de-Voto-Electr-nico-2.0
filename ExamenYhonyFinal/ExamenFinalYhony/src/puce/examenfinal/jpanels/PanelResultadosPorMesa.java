package puce.examenfinal.jpanels;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import puce.examenfinal.clases.Candidate;
import puce.examenfinal.clases.Estudiante;
import puce.examenfinal.clases.Mesa;

import java.awt.*;
import java.util.List;

public class PanelResultadosPorMesa extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    public PanelResultadosPorMesa(List<Candidate> candidatos, List<Mesa> mesas) {
    	getContentPane().setBackground(new Color(128, 128, 128));
        setClosable(true);
        setTitle("Resultados por Mesa");
        setBounds(100, 100, 800, 600);

        getContentPane().setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        model.addColumn("Candidato");

        for (Mesa mesa : mesas) {
            model.addColumn(mesa.getnombreMesa());
        }

        for (Candidate candidato : candidatos) {
            Object[] row = new Object[mesas.size() + 1]; 
            row[0] = candidato.getNombreCandidato();

          
            for (int i = 0; i < mesas.size(); i++) {
                int votosEnMesa = obtenerVotosEnMesa(candidato, mesas.get(i));
                row[i + 1] = votosEnMesa; 
            }

            model.addRow(row);
        }
    }

    private int obtenerVotosEnMesa(Candidate candidato, Mesa mesa) {
        int votosEnMesa = 0;
        for (Estudiante estudiante : mesa.getEstudiantesDeMesa()) {
            if (estudiante.getCandidatoVotado() != null && estudiante.getCandidatoVotado().equals(candidato)) {
                votosEnMesa++;
            }
        }
        return votosEnMesa;
    }
}

