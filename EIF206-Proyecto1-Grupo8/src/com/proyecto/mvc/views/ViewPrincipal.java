package com.proyecto.mvc.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


public class ViewPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel pPrincipal;
	private JLabel lblTitulo;
	private JPanel pContenido;
	private JButton btnTareasPendientes;
	private JButton btnTareasCompletadas;
	private JButton btnCategorias;

	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1100, 600);
		pPrincipal = new JPanel();
		pPrincipal.setBorder(null);
		pPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(pPrincipal);
		
		JPanel pMenuLateral = new JPanel();
		pMenuLateral.setPreferredSize(new Dimension(170, 10));
		pMenuLateral.setBackground(Color.LIGHT_GRAY);
		pMenuLateral.setBorder(new EmptyBorder(10, 10, 10, 10));
		pPrincipal.add(pMenuLateral, BorderLayout.WEST);
		pMenuLateral.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnTareasPendientes = new JButton("  Tareas Pendientes  ");
		pMenuLateral.add(btnTareasPendientes);
		
		btnTareasCompletadas = new JButton("Tareas Completadas");
		pMenuLateral.add(btnTareasCompletadas);
		
		btnCategorias = new JButton("         Categorias         ");
		pMenuLateral.add(btnCategorias);
		
		JPanel pCentral = new JPanel();
		pPrincipal.add(pCentral, BorderLayout.CENTER);
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

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JPanel getpContenido() {
		return pContenido;
	}

	public void setpContenido(JPanel pContenido) {
		this.pContenido = pContenido;
	}

	public JButton getBtnTareasPendientes() {
		return btnTareasPendientes;
	}

	public void setBtnTareasPendientes(JButton btnTareasPendientes) {
		this.btnTareasPendientes = btnTareasPendientes;
	}

	public JButton getBtnTareasCompletadas() {
		return btnTareasCompletadas;
	}

	public void setBtnTareasCompletadas(JButton btnTareasCompletadas) {
		this.btnTareasCompletadas = btnTareasCompletadas;
	}

	public JButton getBtnCategorias() {
		return btnCategorias;
	}

	public void setBtnCategorias(JButton btnCategorias) {
		this.btnCategorias = btnCategorias;
	}
	
	
}
