package de.quantumrange.databaseLibary.database.impl.file;

import de.quantumrange.databaseLibary.data.Data;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class BinaryDataBase extends FileDataBase {

	public BinaryDataBase(@NotNull File path) {
		super("dat", path);
	}

	@Override
	public <T> T read(long id, Data<T, File> template) {
		return null;
	}

	@Override
	public <T> boolean write(long id, Data<T, File> data) {
		return false;
	}
}
