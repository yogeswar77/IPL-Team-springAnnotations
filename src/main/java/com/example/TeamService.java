package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TeamService {
	//@Autowired
    private Team team;
    private Map<Integer, Team> teamDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Map<Integer, Team> getTeamDatabase() {
        return teamDatabase;
    }

    public void setTeamDatabase(Map<Integer, Team> teamDatabase) {
        this.teamDatabase = teamDatabase;
    }

    public void addTeam(Team team) {
        teamDatabase.put(team.getId(), team);
    }

    public void updateTeam(Team updatedTeam) {
        teamDatabase.put(updatedTeam.getId(), updatedTeam);
    }

    public void deleteTeam(int teamId) {
        teamDatabase.remove(teamId);
    }

    public Team getTeam(int teamId) {
        return teamDatabase.get(teamId);
    }

    public void displayAllTeams() {
        System.out.println("Team List:");
        for (Team emp : teamDatabase.values()) {
            System.out.println(emp);
        }
    }

    public void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Team");
            System.out.println("2. Update Team");
            System.out.println("3. Delete Team");
            System.out.println("4. Get Team by ID");
            System.out.println("5. Display All Team");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTeamFromInput();
                    break;
                case 2:
                    updateTeamFromInput();
                    break;
                case 3:
                    deleteTeamFromInput();
                    break;
                case 4:
                    getTeamById();
                    break;
                case 5:
                    displayAllTeams();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void addTeamFromInput() {
        System.out.print("Enter team ID: ");
        int teamId = scanner.nextInt();
        Team newTeam = new Team();
        newTeam.setId(teamId);

        System.out.println("Enter 11 names with their unique IDs:");
        for (int i = 0; i < 11; i++) {
            System.out.print("Enter name ID: ");
            int nameId = scanner.nextInt(); // Read the unique ID for the name
            scanner.nextLine(); // Consume the leftover newline
            System.out.print("Enter name: ");
            String name = scanner.nextLine(); // Read the name
            newTeam.addName(nameId, name);
        }

        addTeam(newTeam);
        System.out.println("Team added successfully.");
    }

    private void updateTeamFromInput() {
        System.out.print("Enter team ID to update: ");
        int id = scanner.nextInt();
        Team existingTeam = getTeam(id);
        if (existingTeam != null) {
            System.out.println("Enter new name ID and name to update (or -1 to stop updating):");
            while (true) {
                System.out.print("Enter name ID (-1 to stop updating): ");
                int nameId = scanner.nextInt();
                if (nameId == -1) {
                    break; // Exit the loop if -1 is entered
                }
                scanner.nextLine(); // Consume newline left-over
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                existingTeam.addName(nameId, newName); // Update the name
            }
            updateTeam(existingTeam); // Save the updated team
            System.out.println("Team updated successfully.");
        } else {
            System.out.println("Team not found with ID " + id);
        }
    }


    private void deleteTeamFromInput() {
        System.out.print("Enter team ID to delete: ");
        int id = scanner.nextInt();
        Team existingTeam = getTeam(id);
        if (existingTeam != null) {
            deleteTeam(id);
            System.out.println("Team deleted successfully.");
        } else {
            System.out.println("Team not found with ID " + id);
        }
    }

    private void getTeamById() {
        System.out.print("Enter team ID to retrieve: ");
        int id = scanner.nextInt();
        Team existingTeam = getTeam(id);
        if (existingTeam != null) {
            System.out.println("Team details:");
            System.out.println(existingTeam);
        } else {
            System.out.println("Team not found with ID " + id);
        }
    }
}