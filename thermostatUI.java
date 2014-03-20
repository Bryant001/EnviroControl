package thermostatUI;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;

public class thermostatUI extends QWidget 
{
	
    private final int WIDTH = 850;
    private final int HEIGHT = 480;
    private final int POLL_INTERVAL = 1000;
    
    private int tempsetting;
    private int test;
    
    private QBasicTimer timer;
    
    private QPushButton setClock;
    private QPushButton setSched;
    private QPushButton ahead;
    private QPushButton back;
    private QPushButton warmer;
    private QPushButton cooler;
    private QPushButton run;
    private QPushButton hold;
    
    private QLabel timeButtonLabel;
    private QLabel tempButtonLabel;
    private QLabel currentTempLabel;
    private QLabel tempSetLabel;
    private QLabel temperatureSettingDisplay;
    private QLabel currentTemperatureDisplay; 
    private QLabel timeDisplay; 
    private QLabel dateDisplay; 

    public thermostatUI() 
    {
        QDesktopWidget qdw = new QDesktopWidget();

        int screenWidth = qdw.width();
        int screenHeight = qdw.height();

        int x = (screenWidth - WIDTH) / 2;
        int y = (screenHeight - HEIGHT) / 2;

        resize(WIDTH, HEIGHT);
        move(x, y);
        setWindowTitle("Thermostat");
        
        initUI();
        
        show();
   }
    

    private void initUI() 
    {

    	tempsetting = 72;
    	test = 0;
    	
        setStyleSheet("QWidget { background-color: White }");
        
        timer = new QBasicTimer();
        setClock = new QPushButton("Set Clock/Day",this);
        setSched = new QPushButton("Set Schedule",this);
        ahead = new QPushButton("Ahead",this);
        back = new QPushButton("Back",this);
        warmer = new QPushButton("Warmer",this);
        cooler = new QPushButton("Cooler",this);
        run = new QPushButton("Run Program",this);
        hold = new QPushButton("Hold Temp",this);
        timeButtonLabel = new QLabel("Time", this);
        tempButtonLabel = new QLabel("Temp", this);
        currentTempLabel = new QLabel("Current Temperature", this);
        tempSetLabel = new QLabel("Temperature Setting", this);
        temperatureSettingDisplay = new QLabel("72 deg F", this);
        currentTemperatureDisplay = new QLabel("-- deg F", this);
        timeDisplay = new QLabel("07:30 AM", this); 
        dateDisplay = new QLabel("Thursday, January 1, 1970", this);
        
        
        setClock.resize(140, 70);
        setSched.resize(140, 70);
        ahead.resize(140, 70);
        back.resize(140, 70);
        warmer.resize(140, 70);
        cooler.resize(140, 70);
        run.resize(140, 70);
        hold.resize(140, 70);
        timeButtonLabel.resize(40, 15);
        tempButtonLabel.resize(40, 15);
        currentTempLabel.resize(160, 20);
        tempSetLabel.resize(160, 20);
        temperatureSettingDisplay.resize(50, 60);
        currentTemperatureDisplay.resize(50, 60);
        timeDisplay.resize(150, 60);
        dateDisplay.resize(150, 15);
        
        setClock.move(110, 270);
        setSched.move(110, 360);
        ahead.move(270, 270);
        back.move(270, 360);
        warmer.move(430, 270);
        cooler.move(430, 360);
        run.move(590, 270);
        hold.move(590, 360);
        timeButtonLabel.move(320, 240);
        tempButtonLabel.move(480, 240);
        currentTempLabel.move(330, 30);
        tempSetLabel.move(550, 30);
        temperatureSettingDisplay.move(570, 60);
        currentTemperatureDisplay.move(350, 60);
        timeDisplay.move(80, 60);
        dateDisplay.move(80, 120);
        
        warmer.clicked.connect(this, "increaseTempSetting()");
        cooler.clicked.connect(this, "decreaseTempSetting()");
        
        timer.start(POLL_INTERVAL, this);
    }
    
    private void increaseTempSetting()
    {
    	tempsetting++;
    	temperatureSettingDisplay.setText(Integer.toString(tempsetting) + " deg F");
    }
    
    private void decreaseTempSetting()
    {
    	tempsetting--;
    	temperatureSettingDisplay.setText(Integer.toString(tempsetting) + " deg F");
    }
    
    @Override
    protected void timerEvent(QTimerEvent event)
    {
    	test++;
    	test = test%4;
    	
    	if(test == 0)
    		currentTemperatureDisplay.setText("This");
    	else if(test == 1)
    		currentTemperatureDisplay.setText("is");
    	else if(test == 2)
    		currentTemperatureDisplay.setText("a");
    	else
    		currentTemperatureDisplay.setText("Test");
    }


    public static void main(String[] args) 
    {
        QApplication.initialize(args);
        new thermostatUI();
        QApplication.exec();
    }
}
