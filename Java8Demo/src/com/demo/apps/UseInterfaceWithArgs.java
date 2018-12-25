package com.demo.apps;

import com.demo.interfaces.InterfacesWithArgs;

public class UseInterfaceWithArgs {
	public static void main(String[] args) {
		InterfacesWithArgs myArgInterface = (v1, v2) -> {
			int result = v1 * v2;
			System.out.println("The result is "+result);
		};
		
		myArgInterface.multiplyThese(10, 10);
	}
}
