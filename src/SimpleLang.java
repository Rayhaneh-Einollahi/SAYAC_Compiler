import main.ast.nodes.Program;
import main.codeGenerator.*;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SimpleLang {
    public static void main(String[] args) throws IOException {
        String code = Files.readString(Paths.get(args[0]));
        CharStream reader = CharStreams.fromString(code);

        SimpleLangLexer SimpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(SimpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.compilationUnit().programRet;


        NameAnalyzer name_analyzer = new NameAnalyzer();
        name_analyzer.visit(program);

//        UnusedRemover unusedRemover = new UnusedRemover();
//        unusedRemover.visit(program);
//
//        DeadStmtRemover deadRemover = new DeadStmtRemover();
//        deadRemover.visit(program);
//
//        DefRemover defRemover = new DefRemover();
//        defRemover.visit(program);
//
//        AccessAnalyzer accessAnalyzer = new AccessAnalyzer();
//        accessAnalyzer.visit(program);
//
//        TestVisitor testVisitor = new TestVisitor();
//        testVisitor.visit(program);

        RegisterManager registerManager = new RegisterManager();
        MemoryManager memoryManager = new MemoryManager();
        InstructionEmitter instructionEmitter = new InstructionEmitter();
        CodeGenContext context = new CodeGenContext(registerManager, memoryManager, instructionEmitter);
        CodeGenerator codeGenerator = new CodeGenerator(context);
        codeGenerator.visit(program);
//        codeGenerator.printAssembly();

    }
}