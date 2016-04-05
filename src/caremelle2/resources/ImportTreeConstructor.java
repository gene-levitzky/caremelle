package caremelle2.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import antlr2.AntlrManager;
import antlr2.AremelleLexer;
import antlr2.AremelleParser.ImportStatementContext;
import antlr2.AremelleParser.ProgramContext;

public class ImportTreeConstructor {
	
	public static class ImportTreeNode {
		private final Map<String, ImportTreeNode> children;
		private final ImportTreeNode parent;
		private final String name;
		
		public ImportTreeNode(String name, ImportTreeNode parent) {
			children = new HashMap<String, ImportTreeNode>();
			this.parent = parent;
			this.name = name;
		}
		
		public ImportTreeNode(String name) {
			this(name, null);
		}
		
		public void addChild(ImportTreeNode child) {
			children.put(child.getName(), child);
		}
		
		public void removeChild(ImportTreeNode child) {
			children.remove(child.getName());
		}
		
		public String getName() {
			return name;
		}
		
		public ImportTreeNode getParent() {
			return parent;
		}
		
		public Map<String, ImportTreeNode> getChildren() {
			return children;
		}
		
		public boolean hasAncestor(ImportTreeNode node) {
			return hasAncestor(node.getName());
		}
		
		public boolean hasAncestor(String name) {
			ImportTreeNode current = this;
			while (current != null) {
				if (current.getName().equals(name)) {
					return true;
				}
				current = current.getParent();
			}
			return false;
		}
	}
	
	private ImportTreeConstructor() {}
	
	public static ImportTreeNode getImportTreeNode(ProgramContext pc) throws Exception {
		
		ImportTreeNode root = new ImportTreeNode("");
				
		Stack<ImportTreeNode> stackNode = new Stack<ImportTreeNode>();
		Stack<ProgramContext> stackContext = new Stack<ProgramContext>();
		stackNode.push(root);
		stackContext.push(pc);
		
		while (!stackNode.isEmpty()) {
			ImportTreeNode node = stackNode.pop();
			ProgramContext cont = stackContext.pop();
			
			for (int i = 0; i < cont.importStatement().size(); i++) {
				ImportStatementContext isc = cont.importStatement(i);
				String filename = isc.String().getText();
				filename = filename.substring(1, filename.length() - 1);
				
				if (node.hasAncestor(filename)) {
					throw new Exception("Import loop detected for '" + filename + "'.");
				}
				
				ImportTreeNode child = new ImportTreeNode(filename, node);
				node.addChild(child);
				
				stackNode.add(child);
				
				File file = new File(filename);
				if (!file.exists()) {
					// TODO
					throw new Exception("Cannot find file '" + filename + "'.");
				}
				else if (file.getName().endsWith(".rml")) {
					stackContext.push(AntlrManager.getProgramContextFromFilename(filename));
				}
				else if (file.isDirectory()) {
					
					// remove this child from the stack since it's not a true function per se
					stackNode.pop();
					node.removeChild(child);
					
					File[] files = file.listFiles();
					for (File f : files) {
						filename = f.getName();
						if (node.hasAncestor(filename)) {
							throw new Exception("Import loop detected for '" + filename + "'.");
						}
						stackNode.push(new ImportTreeNode(filename, node));
						stackContext.push(AntlrManager.getProgramContextFromFilename(filename));
					}
				}
				else {
					// TODO
					throw new Exception("Invalid file type: '" + filename + "'.");	
				}				
			}
		}
		
		return root;
	}
}
