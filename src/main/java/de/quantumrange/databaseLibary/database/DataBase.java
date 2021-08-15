package de.quantumrange.databaseLibary.database;

import de.quantumrange.databaseLibary.data.Data;

/**
 * A {@link DataBase} can store and import {@link Data}.
 *
 * @author QuantumRange
 * @version 1.0.1
 */
public interface DataBase<J> {

	<T> T read(long id, Data<T, J> template);
	<T> boolean write(long id, Data<T, J> data);

}
