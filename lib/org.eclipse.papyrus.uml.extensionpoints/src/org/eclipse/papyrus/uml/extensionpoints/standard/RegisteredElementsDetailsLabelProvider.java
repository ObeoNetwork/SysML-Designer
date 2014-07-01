package org.eclipse.papyrus.uml.extensionpoints.standard;

/**
 * Label provider for Registered elements, for details section in dialogs
 */
public class RegisteredElementsDetailsLabelProvider extends RegisteredElementsLabelProvider {

	/**
	 * @{inheritedDoc
	 */
	@Override
	public String getText(Object element) {
		if(!(element instanceof RegisteredElementExtensionPoint)) {
			return super.getText(element);
		}

		RegisteredElementExtensionPoint point = (RegisteredElementExtensionPoint)element;
		String text = "";
		text += point.getDescription();
		text += " - ";
		text += point.getProvider();
		return text;
	}
}
