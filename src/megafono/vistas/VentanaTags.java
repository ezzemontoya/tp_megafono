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

import megafono.domain.model.Tag;
import megafono.services.TagServices;

public class VentanaTags extends HorizontalLayout implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "";
		
	private TagServices tagService = TagServices.getTagService();
	
	public VentanaTags(){
		setSizeFull();
		
		final Auxiliar auxi = new Auxiliar(); 
		
		final Tree arbol = new Tree("Tags");
		addComponents(arbol);
		
		final TextField tag = new TextField("Ingrese el nuevo tag");
		addComponent(tag);
		
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
				String tagAux = tag.getValue();
				System.out.println(tag.getValue());
				Tag aux = new Tag(tag.getValue());
				//TODO - arreglar esto!!!!!
//				tagService.guardar(aux);
				auxi.misTags.add(aux);
				arbol.addItem(tagAux);
				Notification.show("Tag "+ tagAux + " guardado", Type.TRAY_NOTIFICATION);
				
			}
		});
		botones.addComponent(guardarTag);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
