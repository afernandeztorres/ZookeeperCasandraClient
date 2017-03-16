package com.zookeeper.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class Propiedades {

	public static String leePropiedad(String clave){
		String valor ="";
		try {
			Properties p = new Properties();
			FileInputStream fs = new FileInputStream("D:\\Trabajo\\Zookeeper\\workspace\\zookeeperCasandraClient\\src\\main\\java\\properties\\config.properties");
			p.load(fs);
			valor = p.getProperty(clave);
		}catch(Exception e){
			e.printStackTrace();
		}
		return valor;
	}
}
