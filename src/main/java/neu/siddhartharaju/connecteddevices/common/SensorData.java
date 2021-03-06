package neu.siddhartharaju.connecteddevices.common;

import org.joda.time.DateTime;

public class  SensorData {
	
	private String name;
	private int reading_number;
	private String timestamp;
	private float current;
	private float min_value;
	private float max_value;
	private float total_value;
	
	public SensorData() 
	{
		super();
		this.name = "";
		this.reading_number = 0;
		this.current = 0f;
		this.timestamp =  new DateTime().toString();
		this.min_value = 0f;
		this.max_value = 0f;
		this.total_value = 0f;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReading_number() {
		return reading_number;
	}
	public void setReading_number(int reading_number) {
		this.reading_number = reading_number;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public float getMin_value() {
		return min_value;
	}
	public void setMin_value(float min_value) {
		this.min_value = min_value;
	}
	public float getMax_Value() {
		return max_value;
	}
	public void setMax_Value(float max_Value) {
		this.max_value = max_Value;
	}
	public float getTotal_value() {
		return total_value;
	}
	public void setTotal_value(float total_value) {
		this.total_value = total_value;
	}
	
	public float getAvg()
	{
		return(this.getTotal_value()/this.getReading_number());
	}

	public float getCurrent() {
		return current;
	}

	public void setCurrent(float current) {
		this.current = current;
	}

	public void addValue(float current)
	{
		this.setCurrent(current);
		this.setTimestamp(new DateTime().toString());
		this.setReading_number(this.getReading_number()+1);
		if(this.getTotal_value()!=0)
		{
			this.setTotal_value(this.getTotal_value()+current);
			if(this.getMax_Value()<current)
			{
				this.setMax_Value(current);
			}
			if(this.getMin_value()>current)
				this.setMin_value(current);
		}
		else
		{
			this.setMin_value(current);
			this.setMax_Value(current);
			this.setTotal_value(current);
		}
		this.setReading_number(this.getReading_number()+1);
	}

	@Override
	public String toString() {
		return "SensorData [name=" + name + ", reading_number=" + reading_number + ", timestamp=" + timestamp
				+ ", current=" + current + ", min_value=" + min_value + ", max_Value=" + max_value + ", total_value="
				+ total_value + "]";
	}
	
	

	
	
	

}
