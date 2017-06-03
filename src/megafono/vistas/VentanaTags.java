package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

import megafono.domain.model.Tag;
import megafono.services.TagServices;

public class VentanaTags extends HorizontalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "";

	private TagServices tagService = TagServices.getTagService();

	public VentanaTags() {
		setSizeFull();

		final Tree arbol = new Tree("Tags");
		addComponents(arbol);
		tagService.procesarArbol(arbol);

		VerticalLayout textfiles = new VerticalLayout();
		addComponent(textfiles);
		final TextField tag = new TextField("Ingrese el nuevo tag");
		textfiles.addComponent(tag);
		final TextField sup = new TextField("Ingrese el tag superior");
		textfiles.addComponent(sup);

		HorizontalLayout botones = new HorizontalLayout();
		addComponent(botones);

		Button guardarTag = new Button("Guardar");
		guardarTag.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				tagService.actualizarArbol(arbol, tag.getValue(), sup.getValue());
			}
		});
		botones.addComponent(guardarTag);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
