package eu.modewriter.semanticwordprocessor.editors;

import org.eclipse.jface.viewers.LabelProvider;

public class XMLContentOutlinePageLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		/*
		 * if (element instanceof Company) { return ((Company)
		 * element).getName(); } else if (element instanceof Department) {
		 * return ((Department) element).getDescription(); } else if (element
		 * instanceof Employee) { return ((Employee) element).getEmployeeName();
		 * }
		 */
		return "Node";
	}

}
