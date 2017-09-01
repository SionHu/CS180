
import java.io.*;
import java.util.*;

public class FileParse {

    public static int countWords(String fileName, String searchWord) throws Exception {

        //TODO: Open file  with the path ‘fileName’
        //TODO: Read the file
        //TODO: Go through the file and tally up the number of matches
        //TODO: Print output
        int count = 0;
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            lines.add(line);
        }
        bufferedReader.close();
        String[] content = lines.toArray(new String[lines.size()]);
        for (int i = 0; i < content.length; i++){
            if (content[i].contains(searchWord)){
                count++;
            }
        }
        System.out.println("Total number of occurrences: " + count);
        return count;
    }

    public static boolean deleteLine(String fileName, int lineNum) throws Exception {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
//        String[] content = lines.toArray(new String[lines.size()]);
        try{
            lines.get(lineNum);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Line not found…");
            return false;
        }
        lines.remove(lines.get(lineNum));
        System.out.println("Line deleted!");
//        System.out.println(lines);
        return true;
    }

    public static int refactor(String fileName, String original, String replace) throws Exception {
        //TODO: Iterate through the file line by line and check if the line has the ‘original’ string
        int numFound = 0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String line = null;
        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            if (line.contains(original)){
                numFound += 1;
                line.replaceAll(original, replace);
            }
        }
        if (numFound > 0){
            System.out.println("Number of words replaced: " + numFound);
        }else{
            System.out.println("No words found");
        }
        return numFound;
    }

    public static void main(String[] args) throws Exception{
        FileParse fileParse = new FileParse();
        fileParse.countWords("text.txt", "1");
        fileParse.deleteLine("text.txt", 2);
        fileParse.refactor("text.txt", "1", "w");
    }
}

