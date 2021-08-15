package de.quantumrange.databaseLibary.manager;

import de.quantumrange.databaseLibary.database.DataBase;

import java.util.Set;

/**
 *
 *
 * @author QuantumRange
 * @version 1.0.3
 */
public interface DBManager<J> {

	DataBase<J> get(String key);

}
