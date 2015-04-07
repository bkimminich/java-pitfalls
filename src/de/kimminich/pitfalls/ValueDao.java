package de.kimminich.pitfalls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Matchers.anyString;

public class ValueDao {

    public String findByName(String name) throws SQLException {
        String sql = "SELECT value FROM data WHERE name = '" + name + "' AND access_level > 2";
        String result;
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt
                .executeQuery(sql)) {
            result = rs.getString(1);
        }
        return result;
    }

    @edu.umd.cs.findbugs.annotations.SuppressWarnings({ "OBL_UNSATISFIED_OBLIGATION" })
    private Connection getConnection() throws SQLException {
        Statement stmt = mock(Statement.class);
        given(stmt.executeQuery(anyString())).willReturn(mock(ResultSet.class));

        Connection conn = mock(Connection.class);
        given(conn.createStatement()).willReturn(stmt);

        return conn;
    }

}
