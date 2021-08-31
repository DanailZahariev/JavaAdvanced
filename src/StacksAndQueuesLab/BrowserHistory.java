package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String command = scanner.nextLine();
        String currentUrl = "";
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (browserHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
                String prevUrl = browserHistory.pop();
                currentUrl = prevUrl;
            } else {
                if (!currentUrl.equals("")) {
                    browserHistory.push(currentUrl);
                }
                currentUrl = command;
            }
                System.out.println(currentUrl);
                command = scanner.nextLine();
            }
        }
    }
