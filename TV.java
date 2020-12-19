package javaExperiments.chapter03;

public class TV {
	public int channel=1;
	public int volume=10;
	public boolean on=false;
  
    public TV() {  	
    }
    
    public void turnOn() {	
    	on=true; 	
    }
  
    public void turnOff() {
    	on=false;
    }
    public void channelUp() {
    	if(on && channel<100)
    		channel++; 	
    }
    
    public void channelDown() {
    	if(on && channel>1)
    		channel--;  	
    }

    public void volumeUp() {
    	if(on && volume<100)
    		volume++;
    }
    
    public void volumeDown() {
    	if(on && volume>1)
    		volume--;
    }
	public int getVolume() {
		return volume;
	}
   
	public int getChannel() {
		return channel;
	}
}
