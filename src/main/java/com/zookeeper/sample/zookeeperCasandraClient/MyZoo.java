package com.zookeeper.sample.zookeeperCasandraClient;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import com.zookeeper.utils.Propiedades;
import com.zookeeper.utils.ZKConnection;

/**
 * Hello world!
 *
 */
public class MyZoo 
{
	private ZooKeeper zoo;
	private ZKConnection conn;
	private Stat stat;
	
    public void printChildren(String path) throws InterruptedException{
		List<String> nodos;
		try {
			stat = zoo.exists(path, true);
			if (stat!=null) {
				nodos = zoo.getChildren(path, true);
				for (int i=0; i<nodos.size();i++){
					System.out.println(nodos.get(i));
				}
			} else {
				System.out.println("No existen nodos disponibles");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    


	public void createNode(String path, String info) throws InterruptedException{
		try {
			stat = zoo.exists(path, true);
			if (stat==null) {
				zoo.create(path, info.getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
				System.out.println("Se ha creado el nodo" + path +", con la información: " + info);
			}else{
				System.out.println("No se puede crear el nodo, ya existe");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void deleteNode(String path) throws InterruptedException{
		try {
			zoo.delete(path,zoo.exists(path,true).getVersion());
			System.out.println("Se ha eliminado el nodo" + path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void existsNode(String path){
		try {
			 stat = zoo.exists(path, true); // Stat checks the path of the znode
	         if(stat != null) {
	            System.out.println("El nodo: "+ path + " existe, versión: " + stat.getVersion());
	         } else {
	            System.out.println("No se ha encontrado el nodo: " + path);
	         }
		}catch (Exception e){
			e.printStackTrace();
		}
	}
    
    public MyZoo() throws IOException, InterruptedException{
    	conn = new ZKConnection();
    	conn.setHost(Propiedades.leePropiedad("host"));
    	
    }
    
    public void conectar(){
    	try {
    		zoo = conn.connect();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void cerrarConexion(){
    
    	try {
			zoo.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
