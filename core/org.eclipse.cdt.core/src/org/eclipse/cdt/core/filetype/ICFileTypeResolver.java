/**********************************************************************
 * Copyright (c) 2004 TimeSys Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 * TimeSys Corporation - Initial API and implementation
***********************************************************************/
package org.eclipse.cdt.core.filetype;

/**
 * Class responsible for resolving a file name into the
 * associated file type.
 *
 * Accessed by ICFileTypeResolver and file type management UI.
 */
public interface ICFileTypeResolver {
	/**
	 * @return array containing all known file types.
	 */
	public ICFileTypeAssociation[] getFileTypeAssociations();  

	/**
	 * Determine which file type corresponds to the given
	 * file name.
	 * 
	 * @param fileName file name to check.
	 * 
	 * @return file type for the provided file name
	 */
	public ICFileType getFileType(String fileName);

	/**
	 * Add a new file type association to the resolver's list.
	 * @param assoc file name pattern to add.
	 * 
	 * @return true if the file type association was added.
	 */
	public boolean addAssociation(ICFileTypeAssociation assoc);

	/**
	 * Add multiple file type associations to the resolver's list.
	 * 
	 * @param assocs array of file type associations to add; may be null.
	 *
	 * @return true if at least one file type association was added.
	 */
	public boolean addAssociations(ICFileTypeAssociation[] assocs);
	
	/**
	 * Remove a file type association from the resolver's list.
	 * 
	 * @param assoc file type association to remove.
	 *
	 * @return true if the file type association was removed.
	 */
	public boolean removeAssociation(ICFileTypeAssociation assoc);

	/**
	 * Remove multiple file type associations from the resolver's list.
	 * 
	 * @param assoc array of file type association to remove; may be null
	 *
	 * @return true if at least one file type association was removed.
	 */
	public boolean removeAssociations(ICFileTypeAssociation[] assocs);

	/**
	 * Add and/or remove associations from the resolver in a
	 * batch operation.  Either (or both) of the parameters
	 * may be null.
	 *  
	 * @param add associations to add to the resolver; may be null
	 * @param rem associations to remove from the resolver; may be null
	 * 
	 * @return true if at least one file type association was added or removed
	 */
	public boolean adjustAssociations(ICFileTypeAssociation[] add, ICFileTypeAssociation[] remove);
	
	/**
	 * Create a working copy of this file type resolver.
	 * 
	 * The copy contains the current set of associations that
	 * make up the resolver. 
	 * 
	 * @return working copy of this file type resolver
	 */
	public ICFileTypeResolver createWorkingCopy();
}
