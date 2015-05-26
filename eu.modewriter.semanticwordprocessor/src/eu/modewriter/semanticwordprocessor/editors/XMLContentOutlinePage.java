package eu.modewriter.semanticwordprocessor.editors;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import eu.modewriter.semanticwordprocessor.editors.tree.TreeContentProvider;
import eu.modewriter.semanticwordprocessor.editors.tree.TreeLabelProvider;
import eu.modewriter.semanticwordprocessor.editors.tree.examples.xml.XElementNode;

public class XMLContentOutlinePage extends ContentOutlinePage {

	private ITextEditor editor;
	private IEditorInput input;

	public XMLContentOutlinePage(ITextEditor editor) {
		super();
		this.editor = editor;
	}

	public void setEditor(ITextEditor editor) {
		this.editor = editor;
	}

	/**
	 * Sets the input of the outline page
	 */
	public void setInput(Object input) {
		this.input = (IEditorInput) input;
		update();
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		getTreeViewer().setContentProvider(new TreeContentProvider());
		getTreeViewer().setLabelProvider(new TreeLabelProvider());
		getTreeViewer()
				.setInput(new XElementNode(editor.getDocumentProvider()));
		//getTreeViewer().setInput(new FolderNode(new File("C:/Alloy")));
		getTreeViewer().addSelectionChangedListener(this);
		// getTreeViewer().expandAll();

		// control is created after input is set
		if (input != null)
			viewer.setInput(input);
	}

	/*
	 * Change in selection
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		super.selectionChanged(event);
		// find out which item in tree viewer we have selected, and set
		// highlight range accordingly
		// TODO
		ISelection selection = event.getSelection();
		if (selection.isEmpty())
			editor.resetHighlightRange();
		else {
			XMLElement element = (XMLElement) ((IStructuredSelection) selection)
					.getFirstElement();

			int start = element.getPosition().getOffset();
			int length = element.getPosition().getLength();
			try {
				editor.setHighlightRange(start, length, true);
			} catch (IllegalArgumentException x) {
				editor.resetHighlightRange();
			}
		}
	}

	/**
	 * The editor is saved, so we should refresh representation
	 * 
	 * @param tableNamePositions
	 */
	public void update() {
		// set the input so that the outlines parse can be called
		// update the tree viewer state
		TreeViewer viewer = getTreeViewer();

		if (viewer != null) {
			Control control = viewer.getControl();
			if (control != null && !control.isDisposed()) {
				control.setRedraw(false);
				viewer.setInput(input);
				viewer.expandAll();
				control.setRedraw(true);
			}
		}
	}


}
