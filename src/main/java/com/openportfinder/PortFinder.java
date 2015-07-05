package com.openportfinder;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created with IntelliJ IDEA.
 * User: artemz
 * Date: 7/5/15
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class PortFinder {
    private Integer startingPort = 1024;

    public PortFinder(Integer startingPort) {
        this.startingPort = startingPort;
    }

    public PortFinder() {
    }

    public int nextUnusedPort(){
        int portToVerify = startingPort;
        while(!verifyLocalPort(portToVerify)){
            portToVerify++;
        }
        return portToVerify;
    }
    public boolean verifyLocalPort(int port){
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port);
            ss.setReuseAddress(true);
        } catch (IOException e){
            return false;
        } finally {
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e){}
            }
        }
        return true;
    }
}
