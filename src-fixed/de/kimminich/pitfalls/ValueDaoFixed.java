package de.kimminich.pitfalls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Matchers.anyString;

public class ValueDaoFixed {

    public String findByName(String name) throws SQLException {
        String result;
        try (Connection conn = getConnection(); PreparedStatement stmt = prepareStatement(conn, name); ResultSet rs = stmt
                .executeQuery()) {
            result = rs.getString(1);
        }
        return result;
    }

    // Using String concatenation to create SQL queries introduces SQL Injection vulnerability. Always use PreparedStatement!
    @edu.umd.cs.findbugs.annotations.SuppressWarnings({ "OBL_UNSATISFIED_OBLIGATION" })
    private PreparedStatement prepareStatement(Connection conn, String name) throws SQLException {
        String sql = "SELECT value FROM data WHERE name = ? AND access_level > 2";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        return ps;
    }

    @edu.umd.cs.findbugs.annotations.SuppressWarnings({ "OBL_UNSATISFIED_OBLIGATION" })
    private Connection getConnection() throws SQLException {
        PreparedStatement stmt = mock(PreparedStatement.class);
        given(stmt.executeQuery()).willReturn(mock(ResultSet.class));

        Connection conn = mock(Connection.class);
        given(conn.prepareStatement(anyString())).willReturn(stmt);

        return conn;
    }

}
