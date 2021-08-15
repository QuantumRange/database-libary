package de.quantumrange.databaseLibary.data.impl.file;

import de.quantumrange.databaseLibary.data.Data;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public abstract class FileData<T> extends Data<T, File> {

	private final @NotNull String fileExtension;

	public FileData(@NotNull T defaultValue, @NotNull String fileExtension) {
		super(defaultValue);
		this.fileExtension = "." + fileExtension;
	}

	public FileData(@NotNull T value, @NotNull T defaultValue, @NotNull String fileExtension) {
		super(value, defaultValue);
		this.fileExtension = "." + fileExtension;
	}

	public @NotNull String getFileExtension() {
		return fileExtension;
	}

}
