package de.quantumrange.databaseLibary.data.impl.file;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class BinaryData<T> extends FileData<T> {

	public BinaryData(@NotNull T defaultValue) {
		super("dat", defaultValue);
	}

	@Override
	public void save(File destination) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(destination))) {
			out.writeObject(getValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(File source) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(source))) {

			setValue((T) in.readObject());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
