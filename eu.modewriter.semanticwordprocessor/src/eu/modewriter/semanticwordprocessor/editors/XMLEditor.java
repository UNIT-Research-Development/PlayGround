package eu.modewriter.semanticwordprocessor.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;


public class XMLEditor extends TextEditor {

	private ColorManager colorManager;

	private IEditorInput input;

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


	protected IDocument getInputDocument() {
		IDocument document = getDocumentProvider().getDocument(input);
		return document;
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}
	
	protected void editorSaved() {
		super.editorSaved();

		if (xMLContentOutlinePage != null)
			xMLContentOutlinePage.update();

		// we validate and mark document here
	}

	protected void doSetInput(IEditorInput newInput) throws CoreException {
		super.doSetInput(newInput);
		this.input = newInput;

		if (xMLContentOutlinePage != null)
			xMLContentOutlinePage.setInput(input);

		// we validate and mark document here
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class required) {

		if (IContentOutlinePage.class.equals(required)) {
			if (xMLContentOutlinePage == null) {
				xMLContentOutlinePage = new XMLContentOutlinePage(this);
			}
			return xMLContentOutlinePage;
		}

		return super.getAdapter(required);

	}

}
