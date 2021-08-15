package de.quantumrange.databaseLibary.database.impl.file;

import de.quantumrange.databaseLibary.database.DataBase;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public abstract class FileDataBase implements DataBase<File> {

	private final @NotNull String suffix;
	private final @NotNull File path;

	public FileDataBase(@NotNull String suffix, @NotNull File path) {
		this.suffix = suffix;
		this.path = path;
	}

	protected final File getPath(long id, String fileExtension) {
		return new File(path, String.valueOf(id).concat(".").concat(suffix));
	}

}
