package eu.modewriter.semanticwordprocessor.editors;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class XMLContentOutlinePageContentProvider implements
		ITreeContentProvider {
	private static final Object[] EMPTY_ARRAY = new Object[0];

	// Called just for the first-level objects.
	// Here we provide a list of objects
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof List)
			return ((List<Object>) inputElement).toArray();
		else
			return EMPTY_ARRAY;
	}

	// Queried to know if the current node has children
	@Override
	public boolean hasChildren(Object element) {
		/*
		 * if (element instanceof Company || element instanceof Department) {
		 * return true; }
		 */
		return false;
	}

	// Queried to load the children of a given node
	@Override
	public Object[] getChildren(Object parentElement) {
		/*
		 * if (parentElement instanceof Company) { Company company = (Company)
		 * parentElement; return company.getListDepartment().toArray(); } else
		 * if (parentElement instanceof Department) { Department department =
		 * (Department) parentElement; return
		 * department.getListEmployee().toArray(); }
		 */
		return EMPTY_ARRAY;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}
}
