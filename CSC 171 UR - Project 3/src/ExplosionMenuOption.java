
public class ExplosionMenuOption {
	
	public ExplosionMenuOption(String key, String value) {
		 this.key = key;
	        this.value = value;
	}

    private String key;
    private String value;

    @Override
	public String toString()
	{
	    return key;
	}

	public String getKey()
	{
	    return key;
	}

	public String getValue()
	{
	    return value;
	}
	
}
