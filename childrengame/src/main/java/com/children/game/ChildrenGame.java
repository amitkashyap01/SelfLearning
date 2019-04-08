package com.children.game;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ChildrenGame {
	static int counter = 0;
	static int startingChild = 2;
	
	public static void main(String args[]) {
		ChildrenGame childrenGame = new ChildrenGame();
		childrenGame.childrenGame(20, 127);
	}
	
	public void childrenGame(int numberOfChildren, int gameShout) {
		Map<String, String> children = initilizeChildren(numberOfChildren);

		playGame(children, gameShout);
	}
	
	public Map<String, String> playGame(Map<String, String> children, int shout){

		if(children.size() == 1) {
			System.out.println("Winner: "+children);
			return children;
		}

		Set<String> keySet = children.keySet();
		
		keySet.forEach(child -> {
			counter++;
			if(counter!=shout && !children.get(child).equals("shout")) {
				children.put(child, "shout");
			}else if(counter==shout && !children.get(child).equals("remove")) {
				children.put(child, "remove");
				counter=0;
			}
		});
				
		return playGame(removeAndReturn(children), shout);
	}

	public Map<String, String> removeAndReturn(Map<String, String> children){
		
		System.out.println("Size of children before removing "+children.size());
		children.forEach((k, v) -> System.out.println(k+" : "+v));
		
		Map<String, String> newChildren= new LinkedHashMap<>();
		
		Set<String> keySet = children.keySet();
		
		keySet.forEach(child -> {
			if(!children.get(child).equals("remove"))
				newChildren.put(child, children.get(child));
		});
		
		return newChildren;
	}
		
		
	public static Map<String, String> initilizeChildren(int numberOfChildren) {
		Map<String, String> children = new LinkedHashMap<>();

		for(int i=1; i<=numberOfChildren; i++)
			children.put("Child"+i, "NotShout");
		
		return children;
	}
}
