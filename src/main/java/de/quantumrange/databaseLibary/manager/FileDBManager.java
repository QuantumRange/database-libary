package de.quantumrange.databaseLibary.manager;

import de.quantumrange.databaseLibary.database.DataBase;
import de.quantumrange.databaseLibary.database.impl.FileDataBase;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public record FileDBManager(@NotNull File path) implements DBManager<File> {

	@Override
	public DataBase<File> get(String key) {
		return new FileDataBase(new File(path, key));
	}

}
