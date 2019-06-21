import java.io.File;
import java.util.Scanner;

public class DirectoryList {
    public static void main(String[] args) {
        String directoryName;  // Directory name entered by the user.
        File directory;        // File object referring to the directory.
        Scanner scanner;       // For reading a line of input from the user.

        scanner = new Scanner(System.in);  // scanner reads from standard input.

        System.out.println("The current directory is: " + System.getProperty("user.dir"));
        System.out.print("Enter a directory name: ");
        directoryName = scanner.nextLine().trim();
        directory = new File(directoryName);
        recursiveDirList(directory);
    }

    /**
     * Prints directories and files
     * in a given directory and its subdirectories
     * @param f
     */
    public static void recursiveDirList(File f) {
        if (!f.isDirectory()) {
            if (f.exists()) {
                System.out.println(f);
            }
            else {
                System.out.println("There is no such directory!");
            }
        }
        else {
            String[] files = f.list();
            System.out.println("Files in directory \"" + f + "\":");
            for (int i = 0; i < files.length; i++) {
                formatting((new File(f, files[i])).toString());
                recursiveDirList(new File(f, files[i]));
            }
        }
    }

    /**
     * To make a list more readable,
     * formats a given string that contains a file
     * or a directory path depending on how many '\' or '/'
     * signs the string has
     * @param f
     */
    public static void formatting(String f) {
        int count = 0;
        for(int i = 0; i<f.length(); i++) {
            if (f.charAt(i) == '\\' || f.charAt(i) == '/') {
                count++;
            }
        }
        for(int j = 0; j<count; j++) {
            System.out.print("__");
        }
    }
}
