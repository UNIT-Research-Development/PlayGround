package eu.modewriter.semanticwordprocessor.editors.tree.examples.filesystem;

import java.io.File;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import eu.modewriter.semanticwordprocessor.editors.tree.TreeNode;

/* FILE NODE */
public class FileNode extends TreeNode {
	private File fFile; /* actual data object */

	public FileNode(FolderNode parent, File file) {
		super(parent);
		fFile = file;
	}

	public String getName() {
		return "FILE: " + fFile.getName();
	}

	public Image getImage() {
		return null; /* TODO: Return File image */
	}

	protected void createChildren(List<TreeNode> children) {
	}

	public boolean hasChildren() {
		return false;
	}
}