package eu.modewriter.semanticwordprocessor.editors.tree.examples.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import eu.modewriter.semanticwordprocessor.editors.tree.TreeNode;
import eu.modewriter.semanticwordprocessor.editors.tree.examples.filesystem.FileNode;
import eu.modewriter.semanticwordprocessor.editors.tree.examples.filesystem.FolderNode;

public class XElementNode extends TreeNode {
	private File fFolder; /* actual data object */
	private IDocumentProvider documentProvider;

	private void LoadXMLFile(){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(documentProvider.getDocument(element)));

        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
             Node node = nodeList.item(i);
        }
	}

	public XElementNode(IDocumentProvider documentProvider) {
		this(null, documentProvider);
	}

	public XElementNode(XElementNode parent, IDocumentProvider documentProvider) {
		super(parent);
		this.documentProvider = documentProvider;
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
