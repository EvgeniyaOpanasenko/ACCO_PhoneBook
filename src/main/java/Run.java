import ua.artcode.config.ApplicationContext;
import ua.artcode.view.StartFrameJTableContacts;

/**
 * Created by Lisa on 12/12/2016.
 */
public class Run {
    public static void main(String[] args) {
        //StartFrameJTableContacts frame = new StartFrameJTableContacts();
       // frame.setVisible(true);

        ApplicationContext context = new ApplicationContext();
        context.getController().run();
    }
}
