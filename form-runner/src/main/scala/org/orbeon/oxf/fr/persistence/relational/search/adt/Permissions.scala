/**
 * Copyright (C) 2016 Orbeon, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * The full text of the license is available at http://www.gnu.org/copyleft/lesser.html
 */
package org.orbeon.oxf.fr.persistence.relational.search.adt

import org.orbeon.oxf.fr.persistence.relational.crud.Organization
import org.orbeon.saxon.om.NodeInfo

case class Permissions(
    formPermissionsElOpt          : Option[NodeInfo],
    authorizedBasedOnRole         : Boolean,
    authorizedIfOrganizationMatch : Option[Organization],
    authorizedIfUsername          : Option[String],
    authorizedIfGroup             : Option[String]
  )
