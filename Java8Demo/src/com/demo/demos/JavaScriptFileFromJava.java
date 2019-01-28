package com.demo.demos;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptFileFromJava {
	
	public static void main(String[] args) {
		
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine jsEngine = engineManager.getEngineByName("nashorn");
		
		
		try {
			FileReader fileReader = new FileReader("scripts/script.js");
			
			Object result = jsEngine.eval(fileReader);
			
			System.out.println(result);
		} catch (ScriptException se) {
			System.out.println("Script Exception:"+se);
		} catch (FileNotFoundException fe) {
			System.out.println("Script file is not found");
		}
	}
}
