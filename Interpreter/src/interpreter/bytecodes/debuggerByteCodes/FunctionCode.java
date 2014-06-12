package interpreter.bytecodes.debuggerByteCodes;

import interpreter.VirtualMachine;
import interpreter.bytecodes.ByteCode;
import interpreter.debugger.DebugVM;
import interpreter.debugger.ui.DebugUI;
import java.util.ArrayList;

public class FunctionCode extends ByteCode {
    String funcName;
    int start;
    int end;

    @Override
    public void init(ArrayList<String> functionCodeArgs) {
        funcName = functionCodeArgs.get(0);
        start = Integer.parseInt(functionCodeArgs.get(1));
        end = Integer.parseInt(functionCodeArgs.get(2));
    }

    @Override
    public void execute(VirtualMachine vm) {
        DebugVM dvm = (DebugVM) vm;

        dvm.setFunction(funcName, start, end);

        if(dvm.getNextByteCodeName().equals("FORMAL")) {
            dvm.setIsRunning(false);
        }

        if(dvm.getTraceStatus()) {
            DebugUI.trace(false);
        }
    }

    @Override
    public String getArg() {
        return funcName;
    }

    @Override
    public String toString() {
        return "FUNCTION " + funcName + " " + start + " " + end;
    }
}
