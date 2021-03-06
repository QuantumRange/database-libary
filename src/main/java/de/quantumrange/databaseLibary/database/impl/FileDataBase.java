package de.quantumrange.databaseLibary.database.impl;

import de.quantumrange.databaseLibary.data.Data;
import de.quantumrange.databaseLibary.data.impl.file.FileData;
import de.quantumrange.databaseLibary.database.DataBase;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class FileDataBase implements DataBase<File> {

	private final @NotNull File path;
	private final @NotNull HashMap<Long, Data<?, File>> cache;
	private final @NotNull Set<Long> tempAccessed;

	public FileDataBase(@NotNull File path) {
		this.path = path;
		this.path.mkdirs();
		this.cache = new HashMap<>();
		this.tempAccessed = new TreeSet<>();
	}

	@Override
	public <T> T get(long id, Data<T, File> template) {
		tempAccessed.add(id);
		if (cache.containsKey(id)) return (T) cache.get(id).getOrDefault(template);

		File file = getFile(id, template);
		if (file.exists()) template.read(file);
		cache.put(id, template);

		return template.getValue() == null ? template.getDefaultValue() : template.getValue();
	}

	@Override
	public <T> void set(long id, Data<T, File> data) {
		tempAccessed.add(id);
		cache.put(id, data);
		data.write(getFile(id, data));
	}

	@Override
	public Set<Long> keys() {
		return Arrays.stream(Objects.requireNonNull(path.list()))
				.map(s -> s.substring(0, s.lastIndexOf('.')))
				.map(Long::parseLong)
				.collect(Collectors.toSet());
	}

	@Override
	public void updateCache() {
		for (Long key : cache.keySet()) {
			if (!tempAccessed.contains(key)) {
				cache.remove(key);
			}
		}

		tempAccessed.clear();
	}

	protected final <T> File getFile(long id, Data<T, File> template) {
		String prefix = ".err";

		if (template instanceof FileData data) {
			prefix = data.getFileExtension();
		}

		return new File(path, String.valueOf(id).concat(prefix));
	}

}
