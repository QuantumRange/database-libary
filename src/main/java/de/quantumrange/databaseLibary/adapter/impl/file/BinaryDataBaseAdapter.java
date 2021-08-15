package de.quantumrange.databaseLibary.adapter.impl.file;

import de.quantumrange.databaseLibary.database.impl.file.BinaryDataBase;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class BinaryDataBaseAdapter extends FileDataBaseAdapter<BinaryDataBase> {

	public BinaryDataBaseAdapter(@NotNull File path) {
		super(path);
	}

	@Override
	public BinaryDataBase read(String key) {
		return null;
	}

	@Override
	public boolean write(String key) {
		return false;
	}

}
