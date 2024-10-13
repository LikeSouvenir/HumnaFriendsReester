package org.example.ReesterCategories.Attributes;

import java.util.List;

public class Commands {
    List<String> commands;

    public Commands(List<String> commands) {
        this.commands = commands;
    }

    public void addCommand(String newCommnad) {
        commands.add(newCommnad);
    }

    public void rmCommand(String commandDel) {
        if (commands.contains(commandDel)) commands.remove(commandDel);
    }

    public void rmCommand(int commandDel) {
        if (commands.size() > commandDel) commands.remove(commandDel-1);
    }

    public List<String> getAllCommands() {
        return commands;
    }
    @Override
    public String toString() {
        return "команды=" + commands.toString();
    }
}
