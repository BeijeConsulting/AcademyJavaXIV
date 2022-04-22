package it.beije.turing.db;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import it.beije.turing.rubrica.Contatto;
@Converter
public class ListStringConverter implements AttributeConverter<List<String>,String>{

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
		if (attribute==null)
		{
			return "";
		}
//		StringBuilder builder = new StringBuilder();
//		for(int i=0;i<attribute.size();i++)
//		{
//			String s = attribute.get(i);
//			builder.append(s);
//			if(i!=attribute.size()-1)
//			{
//				builder.append(";");
//			}
//		}
//		return builder.toString();
		return String.join(";", attribute);
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		 if(dbData==null)
		 {
			 return new ArrayList<String>();
		 }
		 List<String> list = new ArrayList<String>();
		 for(String s:dbData.split(";"))
		 {
			 list.add(s);
		 }
		return list;
	}

}
