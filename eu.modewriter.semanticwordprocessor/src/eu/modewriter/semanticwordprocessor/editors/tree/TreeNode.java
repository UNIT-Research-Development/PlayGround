package eu.modewriter.semanticwordprocessor.editors.tree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

/* Default or adapter implementation for ITreeNode */
public abstract class TreeNode implements ITreeNode {
	protected TreeNode parent;
	protected List<TreeNode> fChildren;

	public TreeNode(TreeNode parent) {
		this.parent = parent;
	}

	public Image getImage() {
		return null; /* TODO */
	}

	public boolean hasChildren() {
		return true;
	}

	public ITreeNode getParent() {
		return parent;
	}

	public List<TreeNode> getChildren() {
		if (fChildren != null)
			return fChildren;

		fChildren = new ArrayList<TreeNode>();
		createChildren(fChildren);

		return fChildren;
	}

	/* subclasses should override this method and add the child nodes */
	protected abstract void createChildren(List<TreeNode> children);
}
