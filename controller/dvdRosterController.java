package dvdroster.controller;

import java.util.List;

import dvdroster.dao.dvdRosterDao;
import dvdroster.dao.dvdRosterDaoException;
import dvdroster.ui.dvdRosterView;
import dvdroster.dto.dvd;

public class dvdRosterController {
    
    private dvdRosterView view;
    private dvdRosterDao dao;

    public dvdRosterController(dvdRosterDao dao, dvdRosterView view){
        this.dao = dao;
        this.view = view;
    }

    public void run() throws dvdRosterDaoException{
        dao.loadRoster();
        int menuSelection = 0;
        try {
            first:
            while(true){

                menuSelection = getMenuSelection();

                switch (menuSelection){
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        addDVD();
                        break;
                    case 3:
                        removeDVD();
                        break;
                    case 4:
                        editDVD();
                        break;
                    case 5:
                        viewDVD();
                        break;
                    case 6:
                        searchDVD();
                        break;
                    case 7:
                        break first;
                    default:
                        unknownCommand();

                }

            }
            dao.writeRoster();
            exitMessage();
        } catch (dvdRosterDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printAndGetSelectionMenu();
    }

    private void listDVDs() throws dvdRosterDaoException {
        view.displayDisplayAllBanner();
        List<dvd> DVDList = dao.getAllDVDs();
        view.displayDVDList(DVDList);
    }

    private void addDVD() throws dvdRosterDaoException {
        view.displayAddDVDBanner();
        dvd newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayAddSuccessBanner();
    }

    private void removeDVD() throws dvdRosterDaoException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitle();
        dvd removeDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removeDVD);
    }

    private void editDVD() throws dvdRosterDaoException {
        view.displayEditDVDBanner();
        String dvdTitle = view.getDVDTitle();
        dvd dvd = dao.getDVD(dvdTitle);
        view.displayDVD(dvd);
        dvd info = view.editInfo(dvdTitle, dvd);
        dao.editDVD(dvdTitle, info);
        view.displayEditSuccessBanner();
    }

    private void viewDVD() throws dvdRosterDaoException {
        view.displayDisplayDVDBanner();
        String dvdTitle = view.getDVDTitle();
        dvd dvd = dao.getDVD(dvdTitle);
        view.displayDVD(dvd);
    }

    private void searchDVD() throws dvdRosterDaoException {
        view.displaySearchDVDBanner();
        String dvdTitle = view.getDVDTitle(); 
        List<String> dvd = dao.searchDVD(dvdTitle, dao.getAllDVDs());
        view.displaySearch(dvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
