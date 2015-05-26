package eu.modewriter.semanticwordprocessor.editors;

import java.io.File;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import eu.modewriter.semanticwordprocessor.editors.tree.TreeContentProvider;
import eu.modewriter.semanticwordprocessor.editors.tree.TreeLabelProvider;
import eu.modewriter.semanticwordprocessor.editors.tree.examples.FolderNode;

public class XMLContentOutlinePage extends ContentOutlinePage {

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		super.createControl(parent);

		getTreeViewer().setContentProvider(new TreeContentProvider());
		getTreeViewer().setLabelProvider(new TreeLabelProvider());
		getTreeViewer().setInput(new FolderNode(new File("C:/Alloy")));
		getTreeViewer().expandAll();
	}

}
