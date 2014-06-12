package interpreter.bytecodes.debuggerByteCodes;

import interpreter.VirtualMachine;
import interpreter.bytecodes.ByteCode;
import interpreter.debugger.DebugVM;
import java.util.ArrayList;

public class LineCode extends ByteCode {
    int lineNo;

    @Override
    public void init(ArrayList<String> lineCodeArgs) {
        lineNo = Integer.parseInt(lineCodeArgs.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        DebugVM dvm = (DebugVM) vm;

        dvm.setCurrentLine(lineNo);

        if(lineNo > 0) {
            if(dvm.isBreakPointSet(lineNo)) {
                dvm.setIsRunning(false);
            }
        }
    }

    @Override
    public String getArg() {
        return Integer.toString(lineNo);
    }

    @Override
    public String toString() {
        return "LINE " + lineNo;
    }
}
