package eu.modewriter.semanticwordprocessor.editors;

import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;


public class XMLEditor extends TextEditor {

	private ColorManager colorManager;

	/**
	 * This is the content outline page's viewer.
	 */
	protected XMLContentOutlinePage xMLContentOutlinePage;

	public XMLEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}
	
	public Object getAdapter(Class required) {

		if (IContentOutlinePage.class.equals(required)) {
			if (xMLContentOutlinePage == null) {
				xMLContentOutlinePage = new XMLContentOutlinePage();
			}
			return xMLContentOutlinePage;
		}

		return super.getAdapter(required);

	}

}
