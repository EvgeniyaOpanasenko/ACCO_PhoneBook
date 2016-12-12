import ua.artcode.config.ApplicationContext;
import ua.artcode.view.AddContactFrameTest;
import ua.artcode.view.JTableContacts;

/**
 * Created by Lisa on 12/12/2016.
 */
public class Run {
    public static void main(String[] args) {
        //JTableContacts frame = new JTableContacts();

        ApplicationContext context = new ApplicationContext();
        context.getController().run();
    }
}
