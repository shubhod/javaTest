package com.assingment.syslog;
import com.jcraft.jsch.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class connection {
    public static void main(String args[]){
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession("shubhodeep", "192.168.56.102", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("0000deep");
            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            InputStream stream = sftpChannel.get("/home/shubhodeep/testFile.txt");

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException io) {
                System.out.println("Exception occurred during reading file from SFTP server due to " + io.getMessage());
                io.getMessage();

            } catch (Exception e) {
                System.out.println("Exception occurred during reading file from SFTP server due to " + e.getMessage());
                e.getMessage();

            }
            sftpChannel.exit();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
