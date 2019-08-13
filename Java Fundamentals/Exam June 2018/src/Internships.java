import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int problemsCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        ArrayDeque<String> problems = new ArrayDeque<>();
        ArrayDeque<String> candidates = new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++){
            problems.addFirst(reader.readLine());
        }

        Pattern validName = Pattern.compile("[A-Z]{1}[a-z]+ [A-Z]{1}[a-z]+");

        for (int i = 0; i < candidatesCount; i++){
            String name = reader.readLine();
            Matcher matcher = validName.matcher(name);

            if (matcher.find()) {
                candidates.addLast(name);
            }
        }

        while (problems.size() != 0 && candidates.size() > 1){
            String problem = problems.getFirst();
            problems.removeFirst();
            String candidate = candidates.getFirst();
            candidates.removeFirst();

            if (problemIsSolved(problem,candidate)){
                candidates.addLast(candidate);
                System.out.println(candidate + " solved " + problem + ".");
            } else {
                problems.addLast(problem);
                System.out.println(candidate + " failed " + problem + ".");
            }
        }

        if (candidates.size() == 1){
            System.out.println(candidates.getFirst() + " gets the job!");
        } else if (problems.size() == 0 && candidates.size() != 0){
            StringBuilder sb = new StringBuilder();
            for (String candidate : candidates) {
                sb.append(candidate).append(", ");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 2));
        }
    }

    private static boolean problemIsSolved (String problemName, String candidateName){
        int problemLetters = 0;
        int candidateLetters = 0;

        for (int i = 0; i < problemName.length(); i++){
             problemLetters += (int)problemName.charAt(i);
        }

        for (int i = 0; i < candidateName.length(); i++){
            candidateLetters += (int)candidateName.charAt(i);
        }

        return candidateLetters > problemLetters;
    }
}
