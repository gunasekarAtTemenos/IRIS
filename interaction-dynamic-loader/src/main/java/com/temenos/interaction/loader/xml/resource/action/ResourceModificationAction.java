package com.temenos.interaction.loader.xml.resource.action;

/*
 * #%L
 * interaction-springdsl
 * %%
 * Copyright (C) 2012 - 2014 Temenos Holdings N.V.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */


import org.springframework.core.io.Resource;

import com.temenos.interaction.core.loader.Action;
import com.temenos.interaction.core.loader.FileEvent;
import com.temenos.interaction.loader.resource.action.AbstractResourceModificationAction;

public class ResourceModificationAction extends AbstractResourceModificationAction {
	private Action<FileEvent<Resource>> changedAction;
		
	public void setChangedAction(Action<FileEvent<Resource>> changedAction) {
		this.changedAction = changedAction;
	}
	
	public void notify(FileEvent<Resource> event ) {
		if(matches(event)) {
			changedAction.execute(event);
		}
	}
}
