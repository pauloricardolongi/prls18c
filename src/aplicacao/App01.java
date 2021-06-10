package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Funcionario;

public class App01 {

	public static void main(String[] args) {
		
		List<Funcionario> list = new ArrayList<>();
		String path = "C:\\temp\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String funcionarioCav = br.readLine();
			while (funcionarioCav != null) {
				String[]fields = funcionarioCav.split(",");
				
				list.add(new Funcionario(fields[0],Double.parseDouble(fields[1])));
				
				funcionarioCav = br.readLine();
			}
			Collections.sort(list);
			for (Funcionario emp : list) {
				System.out.println(emp.getNome()+ "," + emp.getSalario());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
