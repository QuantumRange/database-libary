package de.quantumrange.databaseLibary.adapter;

import de.quantumrange.databaseLibary.database.DataBase;

import java.util.List;
import java.util.Set;

/**
 * Manages the connection between the server/files and the {@link DataBase}.
 *
 * @author QuantumRange
 * @version 1.0.1
 * @param <T> is the DataBase Implementation.
 */
public interface DataBaseAdapter<T extends DataBase> {

	/**
	 * Connect to a DataBase or Scan the folder.
	 *
	 * @return false if an error accrued.
	 */
	boolean connect();

	/**
	 * It reads the DataBase from the files/server and return the result.
	 *
	 * @param key is the database name.
	 * @return null if the database not exists, otherwise the loaded database.
	 */
	T read(String key);

	/**
	 * It writes the DataBase into the files/server.
	 *
	 * @param key is the database name.
	 * @return false if an error accrued.
	 */
	boolean write(String key);

	/**
	 * Check if the database exists.
	 *
	 * @param key is the database name.
	 * @return true if the database exists.
	 */
	boolean exist(String key);

	/**
	 * Get all keys in the DataBase.
	 *
	 * @return all keys in the database.
	 */
	Set<String> getKeys();

}
