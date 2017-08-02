package main;

import ui.ResizeFrame;

/*
 * Author: ShantnuS
 * Version: 1.0
 * Date: 02/08/2017
 * 
 * ABOUT: Android Icon Sizer automatically creates the multiple resolutions needed for icons
 * on android and puts them in the correct folders. It automates the previously annoying procedure
 * of having to do it manually. 
 */

public class Main {
	
	public static void main(String[] args){
		ResizeFrame resizer = new ResizeFrame();
		resizer.init();
	}
	
}
