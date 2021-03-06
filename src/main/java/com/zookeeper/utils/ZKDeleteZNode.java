package com.zookeeper.utils;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException;

public class ZKDeleteZNode {
   private static ZooKeeper zk;
   private static ZKConnection conn;

   // Method to check existence of znode and its status, if znode is available.
   public static void delete(String path) throws KeeperException,InterruptedException {
      zk.delete(path,zk.exists(path,true).getVersion());
   }

   public static void main(String[] args) throws InterruptedException,KeeperException {
      String path = "/MyFirstZnode"; //Assign path to the znode
		
      try {
         conn = new ZKConnection();
         conn.setHost(Propiedades.leePropiedad("host"));
         zk = conn.connect();
         delete(path); //delete the node with the specified path
      } catch(Exception e) {
         System.out.println(e.getMessage()); // catches error messages
      }
   }
}
