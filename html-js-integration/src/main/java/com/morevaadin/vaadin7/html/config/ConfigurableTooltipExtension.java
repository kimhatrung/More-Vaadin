/*
 * Copyright 2012 Nicolas Frankel
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.morevaadin.vaadin7.html.config;

import com.morevaadin.vaadin7.html.config.client.TooltipState;
import com.vaadin.server.AbstractExtension;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.Link;

@SuppressWarnings("serial")
public class ConfigurableTooltipExtension extends AbstractExtension {

    public void extend(Link link) {

	Resource resource = link.getResource();
	
	String display = resource instanceof ExternalResource ? ((ExternalResource) resource).getURL().toString() : "???";
	
	getState().setDisplay(display);

	super.extend(link);
    }

    @Override
    public TooltipState getState() {

	return (TooltipState) super.getState();
    }
}
