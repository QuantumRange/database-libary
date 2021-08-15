package de.quantumrange.databaseLibary.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Data<T, J> {

	private @Nullable T value;
	private final @NotNull T defaultValue;

	public Data(@NotNull T defaultValue) {
		this.defaultValue = defaultValue;
	}

	public abstract void save(J destination);
	public abstract void read(J source);

	public @Nullable T getValue() {
		return value;
	}

	public void setValue(@NotNull T value) {
		this.value = value;
	}

	public @NotNull T getDefaultValue() {
		return defaultValue;
	}

}
