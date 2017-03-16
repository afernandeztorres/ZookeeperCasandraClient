package com.zookeeper.utils;

//import java classes
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

//import zookeeper classes
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZKConnection {

	// declare zookeeper instance to access ZooKeeper ensemble
	private ZooKeeper zoo;
	private String host;
	
	
	// Method to connect zookeeper ensemble.
	public ZooKeeper connect() throws IOException,InterruptedException {
		
	   zoo = new ZooKeeper(this.host,5000,new Watcher() {
			
	      public void process(WatchedEvent we) {
	
	         if (we.getState() == KeeperState.SyncConnected) {
	         }
	      }
	   });
	   
	   return zoo;
	}
	
	// Method to disconnect from zookeeper server
	public void close() throws InterruptedException {
	   zoo.close();
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
}

