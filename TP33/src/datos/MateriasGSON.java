package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import negocio.Materia;

public class MateriasGSON 
{
	private ArrayList<Materia> _materias;
	
	public MateriasGSON(ArrayList<Materia> materias)
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
	
	public static MateriasGSON leerGSON(String archivo)
	{
		Gson gson = new Gson();
		MateriasGSON ret = null;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, MateriasGSON.class);
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}
}
