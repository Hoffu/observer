package Test;

import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import model.ComponentShape;
import model.ComponentText;
import model.TimeServer;
import org.junit.Assert;
import org.junit.Test;

public class TestTimeServer {
    private TimeServer timeServer = new TimeServer();


    @Test
    public void testTimeServerNotNull() {
        Assert.assertNotNull(timeServer);
    }

    @Test
    public void testObservers() {
        timeServer.attach(new ComponentText(timeServer, new Text(), true));
        timeServer.attach(new ComponentShape(timeServer, new Arc()));
        Assert.assertEquals(2, timeServer.getObservers().size());
    }
}
