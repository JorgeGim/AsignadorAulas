package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import negocio.Materia;

public class MateriasJSON 
{
	private ArrayList<Materia> _materias;
	
	public MateriasJSON(ArrayList<Materia> materias)
	{
		_materias = materias;
	}
	
	public void addMateria(Materia materia)
	{
		_materias.add(materia);
	}
	
	public int getTamaño()
	{
		return _materias.size();
	}
	
	public Materia getMateria(int i)
	{
		return _materias.get(i);
	}
	
	public ArrayList<Materia> getMaterias(){
		
		return _materias;
	}
	
	public void generarGSON(String archivo)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		
		try{
			FileWriter writer = new FileWriter(archivo);
			writer.write(json);
			writer.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static MateriasJSON leerGSON(String archivo)
	{
		Gson gson = new Gson();
		MateriasJSON ret = null;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, MateriasJSON.class);
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}
}
