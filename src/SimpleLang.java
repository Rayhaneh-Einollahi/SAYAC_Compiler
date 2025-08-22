
import main.ast.nodes.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;


import main.codeGenerator.CodeGenerator;
import main.codeGenerator.LocalOffsetAssigner;
import main.codeGenerator.MemoryManager;
import main.visitor.NameAnalyzer;


import java.nio.charset.StandardCharsets;

import java.nio.file.Path;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage: SimpleLang <input> [-o <output.s>]");
            System.exit(1);
        }

        // ---- Parse CLI args ----
        String inputPath = args[0];
        String outPath = null;
        if (args.length >= 3 && "-o".equals(args[1])) {
            outPath = args[2];
        }

        // ---- Read source file ----
        String code = Files.readString(Path.of(inputPath), StandardCharsets.UTF_8);
        CharStream reader = CharStreams.fromString(code, inputPath);

        // ---- ANTLR pipeline ----
        SimpleLangLexer lexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleLangParser parser = new SimpleLangParser(tokens);
        Program program = parser.compilationUnit().programRet;

        // ---- Semantic analysis ----
        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);

        MemoryManager memoryManager = new MemoryManager();
        LocalOffsetAssigner localOffsetAssigner = new LocalOffsetAssigner(memoryManager);
        localOffsetAssigner.visit(program);

        // ---- Code generation ----
        CodeGenerator codeGenerator = new CodeGenerator(memoryManager);
        String asm = codeGenerator.visit(program).toString();

        // ---- Output ----
        if (outPath == null) {
            System.out.print(asm);   // print to stdout
        } else {
            Files.createDirectories(Path.of(outPath).toAbsolutePath().getParent());
            Files.writeString(Path.of(outPath), asm, StandardCharsets.UTF_8);
        }
    }
}
