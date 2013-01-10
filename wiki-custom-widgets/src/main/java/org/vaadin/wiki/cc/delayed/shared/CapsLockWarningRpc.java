package org.vaadin.wiki.cc.delayed.shared;

import com.vaadin.shared.annotations.Delayed;
import com.vaadin.shared.communication.ServerRpc;

public interface CapsLockWarningRpc extends ServerRpc {

	@Delayed(lastOnly = true)
    void isCapsLockEnabled(boolean isCapsLockEnabled);
	
}
