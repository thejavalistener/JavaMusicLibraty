package app.screen.thum;

import app.screen.thum.decorator.ThmControlsDecoratorImple;
import thejavalistener.fwk.awt.MyAwt;
import thejavalistener.fwk.awt.testui.MyTestUI;
import thejavalistener.fwk.util.string.MyString;

public class ThmControlsExample
{
	public static void main(String[] args)
	{
		MyAwt.setWindowsLookAndFeel();
		
		ThmControls tmpc = new ThmControls();
		tmpc.setDecorator(new ThmControlsDecoratorImple());
		tmpc.setListener(new EscuchaControls());
		MyTestUI.test(tmpc.c()).addButton("Add filter",e->tmpc.addFilter(MyString.generateRandom()))
							   .addButton("Add Label",e->tmpc.addLabel(MyString.generateRandom()))
							   .addButton("Remove Labels",e->tmpc.removeLabels())
		                       .run();
	}
	
	static class EscuchaControls implements ThmControlsListener
	{

		@Override
		public void filterSelected(String filter)
		{
			System.out.println("Filter: "+filter);
		}

		@Override
		public void labelSelected(String filter, String label)
		{
			System.out.println("Filter: "+filter+", Label: "+label);
		}
		
	}
}
