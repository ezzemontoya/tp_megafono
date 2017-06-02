package megafono.vistas;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
@Theme("valo")
public class Ejercicio1 extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Ejercicio1.class)
	public static class Servlet extends VaadinServlet {
	}


	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		Navigator navigator;
		navigator = new Navigator(this, this);
		// Y creamos y registramos las views (pantallas)
		navigator.addView(VentanasTexto.NAME, new VentanasTexto());
		navigator.addView(VentanaExito.NAME, new VentanaExito());
		

	}
	

}