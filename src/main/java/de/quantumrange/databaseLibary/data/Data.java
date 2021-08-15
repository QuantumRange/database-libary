package de.quantumrange.databaseLibary.data;

import de.quantumrange.databaseLibary.database.DataBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * {@link Data} represents data entries in a {@link DataBase}.
 *
 * @author QuantumRange
 * @version 1.0.3
 * @param <T> The Data Type.
 * @param <J> The Source/Destination of the data to be stored.
 */
public abstract class Data<T, J> {

	private @Nullable T value;
	private final @NotNull T defaultValue;

	public Data(@NotNull T defaultValue) {
		this.value = null;
		this.defaultValue = defaultValue;
	}

	public Data(@NotNull T value, @NotNull T defaultValue) {
		this.value = value;
		this.defaultValue = defaultValue;
	}

	/**
	 * Read the Data from the source.
	 *
	 * @param source from where the program tries to load the Data.
	 */
	public abstract void read(J source);

	/**
	 * Write the data to the Destination.
	 *
	 * @param destination where the data is written to.
	 */
	public abstract void write(J destination);

	public @Nullable T getValue() {
		return value;
	}

	public void setValue(@Nullable T value) {
		this.value = value;
	}

	public @NotNull T getDefaultValue() {
		return defaultValue;
	}

	public @NotNull T getOrDefault(Data<?, J> template) {
		return value == null ? (T) template.getDefaultValue() : value;
	}

}
