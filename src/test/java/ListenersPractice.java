import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(genericUtilities.ListenersImplementation.class)
public class ListenersPractice {
	
	@Test
	public void  demo() {
		Assert.fail();
		System.out.println("Helloo");
	}
}
