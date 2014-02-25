package enviroControl;

public class RunClock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try	{
			/*Clock clock = new Clock();
			Clock clock2 = new Clock();
			
			System.out.println("Clock3");
			Clock clock3 = new Clock("Sun 06:49PM");
			clock3.displayTime();
			String time3 = clock3.getCurrentTime();
			boolean testTime = clock.compTime(time3);
			System.out.println("Test is: " + testTime + ". And the time is: " + time3);
			
			System.out.println("Clock");
			clock.displayTime();
			
			System.out.println("Clock2");
			String nextTime = "Mon 05:45PM";//clock2.getNewTime();
			boolean newTest = clock2.compTime(nextTime);
			System.out.println("Current time is before my time? " + newTest);
			if(newTest)	{
				System.out.println("That means my setting is now the current setting");
			} else {
				System.out.println("The current setting has not changed.");
			}
			
			System.out.println("Clock");
			clock.setPreset(nextTime);
			System.out.println("My preset time is: " + clock.getCurrentTime());*/
			
			System.out.println("This is a test of my presets");
			Clock preset1 = new Clock("Sun 07:06PM");
			Clock preset2 = new Clock("Mon 06:45PM");
			Clock current = new Clock();
			System.out.println("Timer1 changes setting? " + current.compTime(preset1.getCurrentTime()));
			System.out.println("Timer2 changes setting? " + current.compTime(preset2.getCurrentTime()));
			System.out.println("Clock setting: " + current.getCurrentTime());
			System.out.print("As displayed by current time displayTime: ");
			current.displayTime();
			System.out.print("This is my preset's displayTime: ");
			preset1.displayTime();
		} catch (Exception presetParse)	{
			System.out.println("Unable to set preset");
		}
		
	}

}
