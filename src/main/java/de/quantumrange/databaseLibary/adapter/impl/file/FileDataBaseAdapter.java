package de.quantumrange.databaseLibary.adapter.impl.file;

import de.quantumrange.databaseLibary.adapter.DataBaseAdapter;
import de.quantumrange.databaseLibary.database.DataBase;
import de.quantumrange.databaseLibary.database.impl.file.FileDataBase;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.*;

public abstract class FileDataBaseAdapter<T extends FileDataBase> implements DataBaseAdapter<T> {

	private final @NotNull File path;
	private final @NotNull List<String> keys;

	public FileDataBaseAdapter(@NotNull File path) {
		this.path = path;
		this.keys = new ArrayList<>();
	}

	public @NotNull File getPath() {
		return path;
	}

	@Override
	public boolean connect() {
		if (!path.exists() && !path.mkdirs()) return false;

		keys.addAll(Arrays.stream(Objects.requireNonNull(path.listFiles()))
				.filter(File::isDirectory)
				.map(File::getName)
				.toList());
		return true;
	}

	@Override
	public boolean exist(String key) {
		return keys.contains(key);
	}

	@Override
	public Set<String> getKeys() {
		return Set.copyOf(keys);
	}
}
