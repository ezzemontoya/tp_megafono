package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class VentanasTexto extends VerticalLayout implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "";

	public VentanasTexto(){
		setSizeFull();
		
		TextField text1 = new TextField("Texto 1");
		addComponent(text1);
		TextField text2 = new TextField("Texto 2");
		addComponent(text2);
		TextField text3= new TextField("Texto 3");
		addComponent(text3);
		
		HorizontalLayout botones = new HorizontalLayout();
		addComponent(botones);
		Button feLimite = new Button("Fecha Limite");
		botones.addComponent(feLimite);
		Button continuar = new Button("Continuar");
		continuar.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VentanaExito.NAME);
			}
		});
		botones.addComponent(continuar);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
