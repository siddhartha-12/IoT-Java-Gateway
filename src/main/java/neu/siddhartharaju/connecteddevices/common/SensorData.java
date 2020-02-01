package neu.siddhartharaju.connecteddevices.common;

import java.util.Random;

import org.joda.time.DateTime;

public class SensorData {
	
	private String timeStamp;
	private String name;
	private float curValue;
	private float avgValue;
	private float minValue;
	private float maxValue;
	private float totValue;
	private int sampleCount;
	
	
	
	public SensorData() {
		super();
		// TODO Auto-generated constructor stub
		 this.timeStamp = DateTime.now().toString();
		 this.name = "Not Set";
		 this.curValue = 0.0f;
		 this.avgValue = 0.0f;
		 this.minValue = 0.0f;
		 this.maxValue = 0.0f;
		 this.totValue = 0.0f;
		 this.sampleCount = 0;
	}

	public void addValue(float current)
	{
		if(this.sampleCount !=0)
		{
			this.timeStamp = DateTime.now().toString();
			this.sampleCount += 1;
			if(this.minValue>current)
			{
				this.minValue=current;
			}
			if(this.maxValue<current)
			{
				this.maxValue=current;
			}
			this.totValue += current;
		}
		else if(this.sampleCount == 0)
		{
			this.sampleCount = 1;
			this.minValue = current;
			this.maxValue = current;
			this.totValue = current;
		}
	}
          
	public float  getAverageValue()
	{
		return (this.totValue / (float)this.sampleCount);
	}
	
	public int  getCount()
	{
		return (this.sampleCount);
	}
	
	public float getCurrentValue()
	{
		Random rand = new Random();
		float temp = (float)rand.nextInt(30) +  rand.nextFloat();
		addValue(temp);
		this.curValue= temp;
		return temp;
	}
        
	public float getMaxValue()
	{
		return (this.maxValue); 
	}
	
	public float getMinValue()
	{
		return (this.minValue);
	}
        
	public String   getName() 
	{
		return(this.name);	
	}
    
	public void  setName(String sname)
	{
		this.name = sname;
	}
	
	public String getTimeStamp()
	{
		return (this.timeStamp);
	}
	
	

}