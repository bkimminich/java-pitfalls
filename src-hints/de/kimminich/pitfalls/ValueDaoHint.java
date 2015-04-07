package de.kimminich.pitfalls;

import org.junit.Test;

import java.sql.SQLException;

public class ValueDaoHint {

    ValueDao dao = new ValueDao();

    @Test
    public void workingSearch() throws SQLException {
        dao.findByName("Smith");
    }

    @Test
    public void brokenSearch() throws SQLException {
        dao.findByName("O'Reilly");
    }

    @Test
    public void maliciousSearch() throws SQLException {
        dao.findByName("' or 1=1--");
    }

}