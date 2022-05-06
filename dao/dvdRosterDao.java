package dvdroster.dao;

import java.util.List;
import dvdroster.dto.dvd;

public interface dvdRosterDao {

    /**
     * 
     * @param title
     * @param dvd
     * @return
     * @throws dvdRosterDaoException
     */
    dvd addDVD(String title, dvd dvd)
     throws dvdRosterDaoException;

     /**
      * 
      * @return
      * @throws dvdRosterDaoException
      */
    List<dvd> getAllDVDs()
     throws dvdRosterDaoException;

     /**
      * 
      * @param title
      * @return
      * @throws dvdRosterDaoException
      */
    dvd getDVD(String title)
     throws dvdRosterDaoException;

     /**
      * 
      * @param title
      * @return
      * @throws dvdRosterDaoException
      */
    dvd removeDVD(String title)
    throws dvdRosterDaoException;

    /**
     * 
     * @param title
     * @return
     * @throws dvdRosterDaoException
     */
    dvd editDVD(String title, dvd dvd)
    throws dvdRosterDaoException;

     /**
      * 
      * @param title
      * @return
      * @throws dvdRosterDaoException
      */
    List<String> searchDVD(String title, List<dvd> list)
     throws dvdRosterDaoException;

    void loadRoster()
     throws dvdRosterDaoException;

    void writeRoster()
     throws dvdRosterDaoException;
    
}
