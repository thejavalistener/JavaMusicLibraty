package app.screen.thum;

import thejavalistener.fwk.awt.testui.MyTestUI;
import thejavalistener.fwk.util.string.MyString;

public class ThmControlsTest
{
	public static void main(String[] args)
	{
		ThmControls tmpc = new ThmControls();
		String[] currFilter = new String[1];
		MyTestUI.test(tmpc.c()).addButton("Add filter",e->tmpc.addFilter(currFilter[0]=MyString.generateRandom()))
		                       .addButton("Add Label",e->tmpc.addLabel(currFilter[0],MyString.generateRandom()))
		                       .run();
	}
}
