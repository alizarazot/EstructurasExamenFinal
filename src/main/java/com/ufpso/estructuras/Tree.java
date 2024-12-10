package com.ufpso.estructuras;

import java.util.ArrayList;

public class Tree {

    Client client;
    Tree left;
    Tree right;

    public Tree(Client client) {
        this.client = client;
    }

    public void addClient(Client client) {
        if (client.getAge() < this.client.getAge()) {
            if (this.left == null) {
                this.left = new Tree(client);
            } else {
                this.left.addClient(client);
            }
        } else {
            if (this.right == null) {
                this.right = new Tree(client);
            } else {
                this.right.addClient(client);
            }
        }
    }

    public static void sortArray(ArrayList<Client> clients) {
        if (clients.size() <= 1) {
            return;
        }

        Tree tree = new Tree(clients.get(0));
        for (int i = 1; i < clients.size(); i++) {
            tree.addClient(clients.get(i));
        }

        tree.replaceInList(clients, 0);
    }

    public int replaceInList(ArrayList<Client> clients, int index) {
        if (this.left != null) {
            index = this.left.replaceInList(clients, index);
        }

        clients.set(index, this.client);
        index++;

        if (this.right != null) {
            index = this.right.replaceInList(clients, index);
        }

        return index;
    }
}
