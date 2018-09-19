package generator.eventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import generator.GUI.GUI;

public class StrBtnHandler implements ActionListener {

	private GUI g;
	
	public StrBtnHandler(GUI _g) {
		g = _g;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("StrBtnHandler");
	}

}
