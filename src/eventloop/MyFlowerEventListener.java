package eventloop;

import java.io.IOException;
import java.util.EventListener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFlowerEventListener implements EventListener {
	public void growDone(MyFlowGrowEvent myFlowGrowEvent)
			throws ServletException, IOException {
		NowFlower flower = (NowFlower) myFlowGrowEvent.getSource();
		
		

	}
}
