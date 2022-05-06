package dvdroster;

import dvdroster.controller.dvdRosterController;
import dvdroster.dao.dvdRosterDao;
import dvdroster.dao.dvdRosterDaoException;
import dvdroster.dao.dvdRosterDaoFileImpl;
import dvdroster.ui.dvdRosterView;
import dvdroster.ui.userIO;
import dvdroster.ui.userIOConsoleImpl;

public class App 
{
    public static void main( String[] args ) throws dvdRosterDaoException{
        userIO myIo = new userIOConsoleImpl();
        dvdRosterView myView = new dvdRosterView(myIo);
        dvdRosterDao myDao = new dvdRosterDaoFileImpl();
        dvdRosterController controller = new dvdRosterController(myDao, myView);
        controller.run();
    }
}
