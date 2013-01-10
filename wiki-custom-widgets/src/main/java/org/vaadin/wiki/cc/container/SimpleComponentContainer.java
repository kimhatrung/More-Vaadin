package org.vaadin.wiki.cc.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;

public class SimpleComponentContainer extends AbstractComponentContainer {

	private List<Component> children = new ArrayList<Component>();

	@Override
	public void addComponent(Component c) {
		children.add(c);
		super.addComponent(c);
		markAsDirty();
	}

	@Override
	public void removeComponent(Component c) {
		children.remove(c);
		super.removeComponent(c);
		markAsDirty();
	}

	public void replaceComponent(Component oldComponent, Component newComponent) {
		int index = children.indexOf(oldComponent);
		if (index != -1) {
			children.remove(index);
			children.add(index, newComponent);
			fireComponentDetachEvent(oldComponent);
			fireComponentAttachEvent(newComponent);
			markAsDirty();
		}
	}

	public int getComponentCount() {
		return children.size();
	}

	public Iterator<Component> iterator() {
		return children.iterator();
	}
	
}
