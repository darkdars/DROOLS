package com.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvFile {
	
	public ReadCsvFile() {
		
	}
	
	public List<Items> readItemsFile(String fileName){
		List<Items> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        records.add(new Items(values[0], values[1], Float.parseFloat(values[2]), values[3], values[4], values[5]));
		    }
		}catch(Exception ignore) {
			
		}
		return records;
	}

}
