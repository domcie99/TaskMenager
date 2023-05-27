import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) { //test asfsdgdfasghsdfhsfdghfg
            System.out.println("1. Dodaj zadanie");
            System.out.println("2. Usuń zadanie");
            System.out.println("3. Wyświetl wszystkie zadania");
            System.out.println("4. Zaktualizuj status zadania");
            System.out.println("5. Wyjdź");

            System.out.print("Wybierz opcję: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Podaj tytuł zadania: ");
                    String title = scanner.nextLine();
                    System.out.print("Podaj opis zadania: ");
                    String description = scanner.nextLine();
                    System.out.print("Podaj status zadania: ");
                    String status = scanner.nextLine();

                    Task newTask = new Task(title, description, status);
                    taskManager.addTask(newTask);
                    System.out.println("Dodano nowe zadanie.");
                    break;
                case 2:
                    System.out.print("Podaj indeks zadania do usunięcia: ");
                    int indexToRemove = scanner.nextInt();
                    scanner.nextLine();

                    if (indexToRemove >= 0 && indexToRemove < taskManager.getAllTasks().size()) {
                        Task taskToRemove = taskManager.getAllTasks().get(indexToRemove);
                        taskManager.removeTask(taskToRemove);
                        System.out.println("Usunięto zadanie.");
                    } else {
                        System.out.println("Nieprawidłowy indeks zadania.");
                    }
                    break;
                case 3:
                    System.out.println("Lista zadań:");
                    for (Task task : taskManager.getAllTasks()) {
                        System.out.println(task.getTitle() + " - " + task.getStatus());
                    }
                    break;
                case 4:
                    System.out.print("Podaj indeks zadania do aktualizacji: ");
                    int indexToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    if (indexToUpdate >= 0 && indexToUpdate < taskManager.getAllTasks().size()) {
                        Task taskToUpdate = taskManager.getAllTasks().get(indexToUpdate);
                        System.out.print("Podaj nowy status zadania: ");
                        String newStatus = scanner.nextLine();

                        taskManager.updateTaskStatus(taskToUpdate, newStatus);
                        System.out.println("Zaktualizowano status zadania.");
                    } else {
                        System.out.println("Nieprawidłowy indeks zadania.");
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja.");
                    break;
            }
        }

        System.out.println("Aplikacja zakończona.");
    }
}