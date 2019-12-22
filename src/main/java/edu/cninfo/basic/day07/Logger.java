package edu.cninfo.basic.day07;

import java.time.Instant;
import java.util.function.Supplier;

public class Logger {
    private boolean debugEnabled=false;

    public boolean isDebugEnabled() {
        return debugEnabled;
    }

    public void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
    }

    public void debug(Supplier<String> message){
        if(isDebugEnabled()){
            debug(message.get());
        }
    }
    public void debug(String message){
        System.out.println("debug["+ Instant.now()+"] "+message);
    }
}
