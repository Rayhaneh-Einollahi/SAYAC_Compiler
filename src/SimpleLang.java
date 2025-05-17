import main.ast.nodes.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.symbolTable.SymbolTable;
import main.visitor.NameAnalyzer;
import main.visitor.TestVisitor;
import main.visitor.UnusedRemover;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimpleLang {

    public static String removeComments(String code) {
        StringBuilder result = new StringBuilder();
        boolean inBlockComment = false;
        StringBuilder lineBuffer = new StringBuilder();

        String[] lines = code.split("\\r?\\n");

        for (String line : lines) {
            if (!inBlockComment) lineBuffer.setLength(0);
            int i = 0;
            int n = line.length();

            while (i < n) {
                if (!inBlockComment && i + 1 < n && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    inBlockComment = true;
                    i += 2;
                } else if (inBlockComment && i + 1 < n && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    inBlockComment = false;
                    i += 2;
                } else if (!inBlockComment && i + 1 < n && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break; // Skip rest of the line
                } else if (!inBlockComment) {
                    lineBuffer.append(line.charAt(i));
                    i++;
                } else {
                    i++;
                }
            }

            if (!inBlockComment) {
                result.append(lineBuffer.toString());
            }
            result.append("\n"); // Preserve original line breaks
        }

        return result.toString();
    }
    public static String preprocess(String code) {
        String[] lines = code.split("\\R");
        StringBuilder result = new StringBuilder();

        Stack<Integer> indentStack = new Stack<>();
        indentStack.push(-1);

        for (String line : lines) {
            String trimmed = line.stripLeading();
            int indent = line.length() - trimmed.length();

            while (!trimmed.isEmpty() && indent <= indentStack.peek()) {
                result.append(" ".repeat(indentStack.pop())).append("}");
            }

            if (trimmed.equals("end")) {
                result.append(" ".repeat(indent)).append("\n");
            } else if (trimmed.endsWith(":")) {
                result.append(" ".repeat(indent)).append(trimmed, 0, trimmed.length() - 1).append(" {\n");
                indentStack.push(indent);
            } else if (!trimmed.isEmpty()) {
                result.append(" ".repeat(indent)).append(trimmed).append(";\n");
            }
            else{
                result.append(" ".repeat(indent)).append(trimmed).append("\n");
            }
        }

        while (indentStack.size() > 1) {
            result.append(" ".repeat(indentStack.pop())).append("}\n");
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        String code = Files.readString(Paths.get(args[0]));
        String transformedCode = preprocess(removeComments(code));
//        System.out.println(transformedCode);
        CharStream reader = CharStreams.fromString(transformedCode);

        SimpleLangLexer SimpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(SimpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.compilationUnit().programRet;
        System.out.println();


        NameAnalyzer my_name_analyzer = new NameAnalyzer();
        boolean ok = my_name_analyzer.visit(program);

        if (ok) {
            UnusedRemover my_unusedRemover = new UnusedRemover();
            my_unusedRemover.visit(program);
            TestVisitor my2_visitor = new TestVisitor();
            my2_visitor.visit(program);
        }

        SymbolTable.root.hashCode();
        System.out.println();
    }
}