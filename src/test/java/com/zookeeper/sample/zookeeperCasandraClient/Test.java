package com.zookeeper.sample.zookeeperCasandraClient;

public class Test {

	public static void main(String[] args){
	
		try {
			String parentPath = "/Cassandra";
			String path = "/Cassandra/nodoPrueba";
			String info = "Este es el nodo de prueba";
			
			MyZoo z = new MyZoo();
			z.conectar();
			z.existsNode(path);
			z.createNode(path, info);
			z.existsNode(path);
			z.printChildren(parentPath);
			z.deleteNode(path);
			z.cerrarConexion();
			
		} catch (Exception e){
			
		}
	}
	
	
}
