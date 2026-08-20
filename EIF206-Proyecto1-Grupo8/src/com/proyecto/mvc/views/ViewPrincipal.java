package com.proyecto.mvc.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;

public class ViewPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JPanel pContenido;
	private JButton btnTareasPendientes;
	private JButton btnTareasCompletadas;
	private JButton btnCategorias;

	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pMenuLateral = new JPanel();
		pMenuLateral.setPreferredSize(new Dimension(170, 10));
		pMenuLateral.setBackground(Color.LIGHT_GRAY);
		pMenuLateral.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(pMenuLateral, BorderLayout.WEST);
		pMenuLateral.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnTareasPendientes = new JButton("  Tareas Pendientes  ");
		pMenuLateral.add(btnTareasPendientes);
		
		btnTareasCompletadas = new JButton("Tareas Completadas");
		pMenuLateral.add(btnTareasCompletadas);
		
		btnCategorias = new JButton("         Categorias         ");
		pMenuLateral.add(btnCategorias);
		
		JPanel pCentral = new JPanel();
		contentPane.add(pCentral, BorderLayout.CENTER);
		pCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel pSuperior = new JPanel();
		pSuperior.setBackground(Color.GRAY);
		pSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
		pCentral.add(pSuperior, BorderLayout.NORTH);
		pSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pSuperior.add(lblTitulo);
		
		pContenido = new JPanel();
		pCentral.add(pContenido, BorderLayout.CENTER);
		pContenido.setLayout(new BorderLayout(0, 0));
	}
	
	public void init() {
		setTitle("Gestor de Tareas");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void setContenido(JComponent c,String titulo) {
		lblTitulo.setText(titulo);
		
		pContenido.removeAll();
		pContenido.add(c, BorderLayout.CENTER);
		
		pContenido.repaint();
		pContenido.revalidate();
	}
}
