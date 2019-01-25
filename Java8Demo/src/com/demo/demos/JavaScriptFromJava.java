package com.demo.demos;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptFromJava {
	
	public static void main(String[] args) throws ScriptException {
		
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine jsEngine = engineManager.getEngineByName("nashorn");
		
		String script = "var welcome='Hello';"
				+ "welcome += ', Amit'; "
				+ "welcome;";
		
		Object result = jsEngine.eval(script);
		System.out.println(result);
	}
}
