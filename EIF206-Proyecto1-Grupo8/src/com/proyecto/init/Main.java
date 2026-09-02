package com.proyecto.init;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.proyecto.mvc.controllers.Controller;

public class Main {

	public static void main(String[] args) {
		FlatCarbonIJTheme.setup();
		new Controller().init();
	}

}
