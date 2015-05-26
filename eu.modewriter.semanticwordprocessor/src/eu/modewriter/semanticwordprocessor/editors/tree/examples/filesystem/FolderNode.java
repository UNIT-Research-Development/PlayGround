package eu.modewriter.semanticwordprocessor.editors.tree.examples.filesystem;

import java.io.File;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import eu.modewriter.semanticwordprocessor.editors.tree.TreeNode;

/* FOLDER NODE */
public class FolderNode extends TreeNode {
	private File fFolder; /* actual data object */

	public FolderNode(File folder) {
		this(null, folder);
	}

	public FolderNode(FolderNode parent, File folder) {
		super(parent);
		fFolder = folder;
	}

	public String getName() {
		return "FOLDER: " + fFolder.getName();
	}

	public Image getImage() {
		return null; /* TODO: Return Folder image */
	}

	protected void createChildren(List<TreeNode> children) {
		File[] childFiles = fFolder.listFiles();
		for (int i = 0; i < childFiles.length; i++) {
			File childFile = childFiles[i];
			if (childFile.isDirectory())
				children.add(new FolderNode(this, childFile));
			else
				children.add(new FileNode(this, childFile));
		}
	}
}
