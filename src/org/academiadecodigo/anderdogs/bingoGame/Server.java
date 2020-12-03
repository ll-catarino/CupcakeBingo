package org.academiadecodigo.anderdogs.bingoGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable{
    private final int THREAD_LIMIT = 4;
    private ServerSocket serverSocket;
    private ArrayList<ClientHandler> clients;
    ExecutorService executorService;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clients = new ArrayList<>();
        executorService = Executors.newFixedThreadPool(THREAD_LIMIT);
    }

    private void listen() throws IOException {
        while (true) {
            ClientHandler c = new ClientHandler(serverSocket.accept());
            clients.add(c);
            executorService.execute(c);
            System.out.println("joined users: "+clients.size());
        }
    }

    public void sendAll(String output) {
            for (ClientHandler c : clients) {
            c.send(output);
        }
    }

    @Override
    public void run() {
        try {
            listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;

            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error");
            }
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                System.out.println("Error");
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    receive();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        private void receive() throws IOException {
            if (in.ready()) {
                String input = in.readLine();
            }
        }


        private void send(String message) {
            out.print(message + "\n");
            out.flush();
        }
    }
}
