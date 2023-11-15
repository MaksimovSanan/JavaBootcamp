package ex05;


import java.util.Scanner;
import java.util.UUID;

public class Menu {
    private final TransactionsService menu = new TransactionsService(new UsersArrayList());

    public void executable(boolean mode) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu(mode);

            int input = 0;
            System.out.print("-> ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            }
            if (input < 1 | input > 7) {
                System.out.println("Error");
            }
            scanner.nextLine();
            String[] data;
            switch (input) {
                case 1:
                    System.out.println("Enter a user name and a balance");
                    System.out.print("-> ");
                    data = scanner.nextLine().split(" ");

                    try {
                        User tmp = new User(data[0], Integer.parseInt(data[1]), new TransactionsLinkedList());
                        menu.addUser(tmp);
                        System.out.println("User with id = " + tmp.getIdentifier() + " is added");
                        System.out.println("---------------------------------------------------------");
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Неверный ввод: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Enter a user ID");
                    System.out.print("-> ");
                    data = scanner.nextLine().split(" ");
                    try {
                        User tmp = menu.getUser(Integer.parseInt(data[0]));
                        System.out.println(tmp);
                        System.out.println("---------------------------------------------------------");
                    } catch (UserNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
                    System.out.print("-> ");
                    data = scanner.nextLine().split(" ");
                    try {
                        menu.addTransaction(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                        System.out.println("The transfer is completed");
                        System.out.println("---------------------------------------------------------");
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Неверный ввод: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Enter a user ID");
                    System.out.print("-> ");
                    data = scanner.nextLine().split(" ");
                    try {
                        for (Transaction transaction : menu.getTransactions(Integer.parseInt(data[0]))) {
                            System.out.println(transaction);
                        }
                        System.out.println("---------------------------------------------------------");
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Неверный ввод: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    if (mode) {
                        System.out.println("Enter a user ID and a transfer ID");
                        System.out.print("-> ");
                        data = scanner.nextLine().split(" ");
                        try {
                            boolean found = false;
                            UUID transactionUUID = UUID.fromString(data[1]);
                            int userId = Integer.parseInt(data[0]);
                            for (Transaction transaction : menu.getTransactions(userId)) {
                                if (transaction.getIdentifier().equals(transactionUUID)) {
                                    found = true;
                                    menu.removeTransaction(transactionUUID, userId);
                                    System.out.println("Transfer To " + transaction.getRecipient().getName() + "(id = " + transaction.getRecipient().getIdentifier() + ") " + transaction.getTransferAmount() + " removed");
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Transaction not found");
                            }

                            System.out.println();
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Permission denied");
                        System.out.println("---------------------------------------------------------");
                    }
                    break;

                case 6:
                    if (mode) {
                        System.out.println("Check results:");
                        try {
                            for (Transaction transaction : menu.getUnpairedTransaction()) {
                                System.out.println(transaction.getSender().getName() +
                                        "(id = " + transaction.getSender().getIdentifier()
                                        + ") has an unacknowledged transfer id = " + transaction.getIdentifier()
                                        + " from " + transaction.getRecipient().getName() + "(id = "
                                        + transaction.getRecipient().getIdentifier() + ") for "
                                        + transaction.getTransferAmount());
                            }
                            System.out.println("---------------------------------------------------------");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Permission denied");
                    }
                case 7:
                    return;
            }
        }
    }

    private void printMenu(boolean mode) {
        if (mode) {
            System.out.println("1. Add a user \n2. View user balances \n3. Perform a transfer \n4. View all transactions for a specific user \n5. DEV – remove a transfer by ID \n6. DEV – check transfer validity \n7. Finish execution");
        } else {
            System.out.println("1. Add a user \n2. View user balances \n3. Perform a transfer \n4. View all transactions for a specific user \n7. Finish execution");
        }
    }

}
