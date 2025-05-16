import main.ast.nodes.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.symbolTable.SymbolTable;
import main.visitor.NameAnalyzer;
import main.visitor.TestVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class SimpleLang {
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
        String transformedCode = preprocess(code);
//        System.out.println(transformedCode);
        CharStream reader = CharStreams.fromString(transformedCode);

        SimpleLangLexer SimpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(SimpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.compilationUnit().programRet;
        System.out.println();

//        TestVisitor my_visitor = new TestVisitor();
//        my_visitor.visit(program);

        NameAnalyzer my_name_analyzer = new NameAnalyzer();
        my_name_analyzer.visit(program);

        SymbolTable.root.hashCode();
        System.out.println();
    }
}