package eu.modewriter.semanticwordprocessor.editors.tree;

import java.util.List;

import org.eclipse.swt.graphics.Image;

public interface ITreeNode {
	public String getName();

	public Image getImage();

	public List getChildren();

	public boolean hasChildren();

	public ITreeNode getParent();
}
