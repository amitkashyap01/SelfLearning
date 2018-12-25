package com.javacore.javasevenpathdemo;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

public class MyWatchEventDemo {
	public static void main(String[] args) {

		try (WatchService service = FileSystems.getDefault().newWatchService()){
			Map<WatchKey, Path> keyMap = new HashMap<>();

			Path path = Paths.get("Files");
			
			keyMap.put(path.register(service, 
					StandardWatchEventKinds.ENTRY_CREATE, 
					StandardWatchEventKinds.ENTRY_MODIFY, 
					StandardWatchEventKinds.ENTRY_DELETE), 
					path);

			WatchKey watchKey = null;
			
			do {
				watchKey = service.take();
				Path eventDir = keyMap.get(watchKey);
				
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					
					Path eventPath = (Path) event.context();
					System.out.println(eventDir+ ":"+ kind+ ":"+ eventPath);
				}
			} while (watchKey.reset());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
}
