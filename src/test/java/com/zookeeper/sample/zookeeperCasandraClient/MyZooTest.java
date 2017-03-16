package com.zookeeper.sample.zookeeperCasandraClient;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MyZooTest
    extends TestCase
{
	MyZoo zoo;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MyZooTest( String testName )
    {
        super( testName );
        try {
			zoo = new MyZoo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MyZooTest.class );
    }

    public void testExistsNode()
    {
    	String path = "/Cassandra/nodoNoExiste";
    	zoo.conectar();
		assertFalse(zoo.existsNode(path));
		zoo.cerrarConexion();
    	
    }
    
    public void testCreateNode()
    {
    	String path = "/Cassandra/javatest";
    	String info = "Nodo de prueba desde java";
    	zoo.conectar();
    	try{
    		zoo.conectar();
        	assertEquals(zoo.createNode(path, info),0);
    		zoo.cerrarConexion();
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zoo.cerrarConexion();
    	
    }
    
    public void testDeleteNode()
    {
    	String path = "/Cassandra/javatest";
    	zoo.conectar();
    	try{
    		zoo.conectar();
        	assertEquals(zoo.deleteNode(path),0);
    		zoo.cerrarConexion();
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zoo.cerrarConexion();
    	
    }
    
    public void testPrintChildren()
    {
    	String parentPath="/Cassandra";
    	zoo.conectar();
    	try{
    		zoo.conectar();
        	assertEquals(zoo.printChildren(parentPath),0);
    		zoo.cerrarConexion();
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zoo.cerrarConexion();
    	
    }
       
    public void testAll()
    {
    	String parentPath="/Cassandra";
    	String path = "/Cassandra/javatest";
    	String info = "Nodo de prueba desde java";
    	try{
    		zoo.conectar();
        	assertFalse(zoo.existsNode(path));
        	assertEquals(zoo.createNode(path, info),0);
        	assertTrue(zoo.existsNode(path));
        	assertEquals(zoo.printChildren(parentPath),0);
        	assertEquals(zoo.deleteNode(path),0);
    		zoo.cerrarConexion();
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
