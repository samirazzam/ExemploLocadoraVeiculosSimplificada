package br.senac.utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConversorData {
	
	//Método para converter String para Calendar (data)
	public static Calendar stringToCalendar(String dataString){
		
		try{
			DateFormat formatadorData;
			Date dataFormatada;
			formatadorData = new SimpleDateFormat("dd/MM/yyyy");
			dataFormatada = formatadorData.parse(dataString);
			Calendar dataJava = Calendar.getInstance();
			dataJava.setTime(dataFormatada);
			return dataJava;
		}catch(ParseException e){
			System.out.println("Erro ao converter a data");
			return null;
		}//fim try/catch
	}//fim método stringToCalendar
	
	//Método para converter Calendar para String
	public static String calendarToString(Calendar dataCalendar){
		try{
			DateFormat formatadorData;
			formatadorData = new SimpleDateFormat("dd/MM/yyyy");
			String dataString = formatadorData.format(dataCalendar.getTime());
			return dataString;
		}catch(Exception e){
			System.out.println("Erro ao converter a data");
			return null;
		}//fim try/catch
	}
	
}//fim da classe
