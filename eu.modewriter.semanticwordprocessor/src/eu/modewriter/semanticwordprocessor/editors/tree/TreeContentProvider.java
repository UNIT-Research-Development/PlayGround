package eu.modewriter.semanticwordprocessor.editors.tree;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeContentProvider implements ITreeContentProvider {
	public Object[] getChildren(Object parentElement) {
		return ((ITreeNode) parentElement).getChildren().toArray();
	}

	public Object getParent(Object element) {
		return ((ITreeNode) element).getParent();
	}

	public boolean hasChildren(Object element) {
		return ((ITreeNode) element).hasChildren();
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}
