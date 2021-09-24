package de.quantumrange.databaseLibary.main;

import de.quantumrange.databaseLibary.data.impl.file.BinaryData;
import de.quantumrange.databaseLibary.database.DataBase;
import de.quantumrange.databaseLibary.database.impl.FileDataBase;
import de.quantumrange.databaseLibary.manager.DBManager;
import de.quantumrange.databaseLibary.manager.FileDBManager;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		DBManager<File> DB = new FileDBManager(new File("./reeeeeeeeeeeee/"));

		DataBase<File> reeeeeeeeee = DB.get("reeeeeeeeee");
		System.out.println(reeeeeeeeee.get(0L, BinaryData.ofTemplate("WAS ZUM, REEEEEEEEEEEEEEE")));
	}

}
