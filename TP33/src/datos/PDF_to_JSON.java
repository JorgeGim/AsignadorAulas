package datos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import negocio.Materia;

public class PDF_to_JSON {
	
	public static void toGSON(String archivo){
		 
		try {
				
			FileInputStream fis = new FileInputStream(archivo+".pdf");
			
			PDDocument document = PDDocument.load(fis);
					
			PDFTextStripper s = new PDFTextStripper();
			String content = s.getText(document);
					
			ArrayList<Materia> _materias = new ArrayList<>();
			
			int i=0;
				
			Pattern pattern = Pattern.compile("([A-Z¡…Õ”⁄]+\\s+)+" 						//MATERIA
											+ "\\d\\s+"									//CARACTER INUTIL
											+ "[DJLMSV][a-zÈ]+\\s+"						//DIA
											+ "[012][0-9]:[0-5][0-9]:[0-5][0-9]\\s+"	//HORARIO INICIO
											+ "[012][0-9]:[0-5][0-9]:[0-5][0-9]");		//HORARIO FIN
			Matcher matcher = pattern.matcher(content);
			while( matcher.find() ) {
				
				Pattern diaPat = Pattern.compile("[DJLMSV][a-zÈ]+");
				Matcher diaMat = diaPat.matcher(matcher.group());
				diaMat.find();
					
				if(diaMat.group().equals("Lunes")){
						
					Pattern materiaPat = Pattern.compile("([A-Z¡…Õ”⁄]+\\s+)+");
					Matcher materiaMat = materiaPat.matcher(matcher.group());
					materiaMat.find();
						
					Pattern horarioPat = Pattern.compile("[012][0-9]:[0-5][0-9]:[0-5][0-9]");
							
					Matcher horarioMat = horarioPat.matcher(matcher.group());
					
					horarioMat.find();
					Integer hInicio = Integer.parseInt(horarioMat.group().substring(0, 2));
					
					horarioMat.find();
					Integer hFin = Integer.parseInt(horarioMat.group().substring(0, 2));
					
					
					Materia materia = new Materia(materiaMat.group(),hInicio,hFin,i);
					
					_materias.add(materia);					
				}
				
				i++;
			}
			MateriasJSON materiasJSON = new MateriasJSON(_materias);
			
			materiasJSON.generarGSON(archivo+".GSON");
		} 
		catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
