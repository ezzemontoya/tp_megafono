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
				if (sup.getValue() == "") {
					String tagAux = tag.getValue();
					Tag aux = new Tag(tag.getValue());
					tagService.guardar(aux);
					arbol.addItem(tagAux);
					Notification.show("Tag " + tagAux + " " + "guardado", Type.TRAY_NOTIFICATION);
					tag.setValue("");
				} else if (sup.getValue() != "" && tag.getValue() != "") {
					Tag aux = new Tag(tag.getValue(), new Tag(sup.getValue()));
					tagService.guardar(aux);
					arbol.addItem(tag.getValue());
					arbol.addItem(sup.getValue());
					arbol.setParent(tag.getValue(),sup.getValue());
					Notification.show("Tag " + tag.getValue() + " " + "guardado", Type.TRAY_NOTIFICATION);
					tag.setValue("");
					tag.setValue("");
				} else {
					Notification.show("Debe ingresar un tag para poder guardar", Type.TRAY_NOTIFICATION);
				}

			}
		});
		botones.addComponent(guardarTag);

		// Button guardarSuperiorTag = new Button("Superior");
		// guardarSuperiorTag.addClickListener(new Button.ClickListener() {
		// /**
		// *
		// */
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void buttonClick(ClickEvent event) {
		// String tagAux = tag.getValue();
		// Tag aux = new Tag(tag.getValue());
		// tagService.guardar(aux);
		// arbol.addItem(tagAux);
		// Notification.show("Tag "+ tagAux +" " +"guardado",
		// Type.TRAY_NOTIFICATION);
		// tag.setValue("");
		// tag.setValue("");
		// }
		// });
		// botones.addComponent(guardarSuperiorTag);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
