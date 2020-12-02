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

public class Server {
    private final int THREAD_LIMIT = 4;
    private ServerSocket serverSocket;
    private ArrayList<ClientHandler> clients;
    ExecutorService executorService;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clients = new ArrayList<>();
        executorService = Executors.newFixedThreadPool(THREAD_LIMIT);
        listen();
    }

    private void listen() throws IOException {
        while (true) {
            ClientHandler c = new ClientHandler(serverSocket.accept());
            clients.add(c);
            executorService.execute(c);
            System.out.println(clients.size());
        }
    }

    private void sendAllExcept(ClientHandler sender, String message) {
        if (message.equals(""))
            return;
        for (ClientHandler c : clients) {
            if (!c.equals(sender)) {
                c.sendMessage(sender.getName() + ": " + message);
            }
        }
    }
    private void sendPM(ClientHandler dest, String message) {
        dest.sendMessage(message);
    }


    public static void main(String[] args) throws IOException {
        Server s = new Server(25565);
    }


    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public ClientHandler(Socket clientSocket) throws SocketException {
            this.clientSocket = clientSocket;
            name = "unnamed";

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
            name = askName();
            while (true) {
                try {
                    receiveMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String askName() {
            sendMessage("Please Enter Your Name");
            String name = null;
            try {
                name = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (name.equals(""))
                askName();
            return name;
        }

        private void receiveMessage() throws IOException {
            if (in.ready()) {
                String message = in.readLine();
                if (message.startsWith(":")) {
                    processCommand(message.substring(1));
                } else {
                    sendAllExcept(this, message);
                }
            }
        }

        private void processCommand(String command) {
            switch (command.split(" ")[0]) {
                case "q":
                    quit();
                    break;
                case "pm":
                    int i = Integer.parseInt(command.split(" ")[1]);
                    String message = command.split(" ")[2];
                    ClientHandler dest = clients.get(i);
                    sendPM(dest, message); //todo
            }
        }

        private void quit() {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clients.remove(this);
        }

        private void sendMessage(String message) {
            out.print(message + "\n");
            out.flush();
        }

        public String getName() {
            return name;
        }
    }
}
