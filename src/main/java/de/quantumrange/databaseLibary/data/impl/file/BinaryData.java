package de.quantumrange.databaseLibary.data.impl.file;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class BinaryData<T> extends FileData<T> {

	public BinaryData(@NotNull T defaultValue) {
		super(defaultValue, "bin");
	}

	public BinaryData(@NotNull T value, @NotNull T defaultValue) {
		super(value, defaultValue, "bin");
	}

	@Override
	public void read(File source) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(source))) {
			setValue((T) in.readObject());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void write(File destination) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(destination))) {

			out.writeObject(getValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T> BinaryData<T> ofData(T data) {
		return new BinaryData<>(data, data);
	}

	public static <T> BinaryData<T> ofTemplate(T data) {
		return new BinaryData<>(data);
	}

}
