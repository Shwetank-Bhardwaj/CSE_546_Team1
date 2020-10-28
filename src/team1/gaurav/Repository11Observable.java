package team1.gaurav;

/**
 * gaurav.Repository11Observable is the observable class to attach, detach, and notify all observers
 *
 * @author  Gaurav Ainapur
 * @version 1.0
 * @since   10-25-2020
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Repository11Observable implements Observer {

	private List<Repository11Observer> observers = new ArrayList<Repository11Observer>();
	
	public void attach(Repository11Observer observer) {
		observers.add(observer);		
	}

	public void detach(Repository11Observer observer) {
		observers.remove(observer);
	}
	public void notifyAllObservers() {
		for (Repository11Observer observer : observers) {
			observer.update();
		}
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
