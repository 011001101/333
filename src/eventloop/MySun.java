package eventloop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySun implements Runnable {
	private List<NowFlower> list;
	private MyFlowerEventListener listener;


	public MySun() {
		list = new ArrayList<>();
	}

	public void addFlower(NowFlower flower) {
		list.add(flower);
	}

	public void setFlowerEventListener(MyFlowerEventListener listener) {
		this.listener = listener;
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(1000);

				Iterator<NowFlower> iter = list.iterator();
				while (iter.hasNext()) {
					NowFlower f = iter.next();
					f.increase();
					System.out.println(f.getSet() + " 성장 : " + f.getTime());

					if (f.isDone()) {
						try {
							listener.growDone(new MyFlowGrowEvent(f));
						} catch (ServletException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						iter.remove();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
