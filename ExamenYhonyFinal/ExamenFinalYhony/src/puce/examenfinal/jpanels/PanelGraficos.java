package puce.examenfinal.jpanels;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import puce.examenfinal.clases.Candidate;

import java.awt.Color;

public class PanelGraficos extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    public PanelGraficos(List <Candidate> candidatos) {
    	setBackground(new Color(192, 192, 192));
    	getContentPane().setBackground(new Color(192, 192, 192));
    	setClosable(true);
        setTitle("Resultados en barras");
        setBounds(100, 100, 450, 300);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Candidate candidato : candidatos) {
            dataset.addValue(candidato.getVotos(), "Votos", candidato.getNombreCandidato());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Resultados de Votaciones", 
                "Candidatos", 
                "Votos",
                dataset 
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(128, 128, 192));
        getContentPane().add(chartPanel);
    }
}
