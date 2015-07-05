package com.openportfinder;

import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created with IntelliJ IDEA.
 * User: artemz
 * Date: 7/5/15
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestPortFinder {
    @Test
    public void testPortTaken() throws IOException{
        ServerSocket ss = new ServerSocket(1025);
        ss.setReuseAddress(true);

        PortFinder finder = new PortFinder(1025);

        Integer nextUnusedPort = finder.nextUnusedPort();

        System.out.println("Next unused port: " + nextUnusedPort);

        assert nextUnusedPort != 1025;

        if (ss != null){
            ss.close();
        }
    }
}
