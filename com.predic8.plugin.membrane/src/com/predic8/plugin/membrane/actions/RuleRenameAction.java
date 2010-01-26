/* Copyright 2009 predic8 GmbH, www.predic8.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License. */

package com.predic8.plugin.membrane.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

import com.predic8.membrane.core.rules.Rule;
import com.predic8.plugin.membrane.celleditors.RuleTreeCellEditorModifier;

public class RuleRenameAction extends Action {

	private TreeViewer treeView;
	
	public RuleRenameAction(TreeViewer treeView) {
		super();
		this.treeView = treeView;
		setText("Rename");
		setId("Rule Rename Action");
	}
	
	public void run() {
		IStructuredSelection selection = (IStructuredSelection) treeView.getSelection();
		Object selectedItem = selection.getFirstElement();
		
		if (selectedItem instanceof Rule) {
			RuleTreeCellEditorModifier modifier = (RuleTreeCellEditorModifier) treeView.getCellModifier();
			modifier.allowModify(true);
			treeView.editElement(selection.getFirstElement(), 0);
			modifier.allowModify(false); 
		}
	}
	
}
