package org.vaadin.wiki.cc.delayed;

import org.vaadin.wiki.cc.delayed.shared.CapsLockWarningRpc;

import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;

public class CapsLockWarningWithRpc extends AbstractExtension {

	public CapsLockWarningWithRpc() {
		registerRpc(new CapsLockWarningRpc() {

			@Override
			public void isCapsLockEnabled(boolean isCapsLockEnabled) {
				Notification.show("Caps Lock was "
						+ (isCapsLockEnabled ? "enabled" : "disabled"));
			}
		});
	}

	public void extend(PasswordField field) {
		super.extend(field);
	}
}
