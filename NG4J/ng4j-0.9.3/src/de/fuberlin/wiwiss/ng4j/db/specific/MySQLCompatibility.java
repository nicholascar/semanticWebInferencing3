// $Header: /cvsroot/ng4j/ng4j/src/de/fuberlin/wiwiss/ng4j/db/specific/MySQLCompatibility.java,v 1.5 2010/02/25 14:28:21 hartig Exp $
package de.fuberlin.wiwiss.ng4j.db.specific;

import java.sql.Connection;
import java.sql.SQLException;

import com.hp.hpl.jena.shared.JenaException;

/** Provides compatibility methods for MySQL databases.
 *
 * @author Jennifer Cormier, Architecture Technology Corporation
 */
public class MySQLCompatibility extends DbCompatibility {

	protected static final String VARCHAR_NAME = "varchar";

	public MySQLCompatibility(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see de.fuberlin.wiwiss.ng4j.db.specific.DbCompatibility#createTables()
	 */
	@Override
	public void createTables() {
		execute("CREATE TABLE " + graphNamesTableName + " (" +
				"name " + URI_DATATYPE + " NOT NULL default '', " +
				"PRIMARY KEY  (`name`)) TYPE=MyISAM");
		try {
			executeNoErrorHandling(
					"CREATE TABLE " + quadsTableName + " (" +
					"graph " + URI_DATATYPE + " NOT NULL default ''," +
					"subject " + URI_DATATYPE + " NOT NULL default ''," +
					"predicate " + URI_DATATYPE + " NOT NULL default ''," +
					"object " + URI_DATATYPE + " default NULL," +
					"literal text," +
					"lang " + LANGUAGE_DATATYPE + " default NULL," +
					"datatype " + DATATYPE_DATATYPE + " default NULL," +
					"KEY graph (`graph`)," +
					"KEY subject (`subject`)," +
					"KEY predicate (`predicate`)," +
					"KEY object (`object`)" +
					") TYPE=MyISAM;");
		} catch (SQLException ex) {
			execute("DROP TABLE " + graphNamesTableName);
			throw new JenaException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see de.fuberlin.wiwiss.ng4j.db.specific.DbCompatibility#getVarcharName()
	 */
	@Override
	public String getVarcharName() {
		return VARCHAR_NAME;
	}

	/*
	 *  (c)   Copyright 2008 - 2010 Christian Bizer (chris@bizer.de)
	 *   All rights reserved.
	 *
	 * Redistribution and use in source and binary forms, with or without
	 * modification, are permitted provided that the following conditions
	 * are met:
	 * 1. Redistributions of source code must retain the above copyright
	 *    notice, this list of conditions and the following disclaimer.
	 * 2. Redistributions in binary form must reproduce the above copyright
	 *    notice, this list of conditions and the following disclaimer in the
	 *    documentation and/or other materials provided with the distribution.
	 * 3. The name of the author may not be used to endorse or promote products
	 *    derived from this software without specific prior written permission.
	 *
	 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
	 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
	 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
	 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
	 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
	 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
	 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
	 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
	 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
	 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
	 *
	 */
}
