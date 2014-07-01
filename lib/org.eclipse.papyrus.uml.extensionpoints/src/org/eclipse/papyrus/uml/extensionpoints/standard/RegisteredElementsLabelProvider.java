package org.eclipse.papyrus.uml.extensionpoints.standard;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * Label provider for elements registered in the platform by Papyrus uml2 extension points
 */
public class RegisteredElementsLabelProvider extends LabelProvider {

	/**
	 * Creates a new instance of the class
	 */
	public RegisteredElementsLabelProvider() {
		super();
	}

	/**
	 * @{inheritedDoc
	 */
	@Override
	public Image getImage(Object element) {
		if(!(element instanceof RegisteredElementExtensionPoint)) {
			return super.getImage(element);
		}
		RegisteredElementExtensionPoint abstractExtensionPoint = (RegisteredElementExtensionPoint)element;
		return abstractExtensionPoint.getImage();
	}

	/**
	 * @{inheritedDoc
	 */
	@Override
	public String getText(Object element) {
		if(!(element instanceof RegisteredElementExtensionPoint)) {
			return super.getText(element);
		}
		RegisteredElementExtensionPoint abstractExtensionPoint = (RegisteredElementExtensionPoint)element;
		return abstractExtensionPoint.getName();
	}
}
