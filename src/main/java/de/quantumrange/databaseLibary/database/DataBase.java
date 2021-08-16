package de.quantumrange.databaseLibary.database;

import de.quantumrange.databaseLibary.data.Data;

import java.util.Set;

/**
 * Store and Manage {@link Data}.
 *
 * @author QuantumRange
 * @version 1.0.3
 * @param <J> is the Data Type.
 */
public interface DataBase<J> {

	<T> T get(long id, Data<T, J> template);
	<T> void set(long id, Data<T, J> data);
	Set<Long> keys();
	void updateCache();

}
