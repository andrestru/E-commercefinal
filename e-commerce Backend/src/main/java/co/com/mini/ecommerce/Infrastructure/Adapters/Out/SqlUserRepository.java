package co.com.mini.ecommerce.Infrastructure.Adapters.Out;

import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Application.Domain.User;
import co.com.mini.ecommerce.Application.Ports.Out.UserRepository;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository
public class SqlUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<User> userRowMapper = (resultSet, i) -> Result(resultSet);

    private User Result(ResultSet resultSet) throws SQLException {
        return new User(
                new NonEmptyName(resultSet.getString("email")),
                new NonEmptyName(resultSet.getString("password"))
        );
    }

    public SqlUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Collection<User> ListUser(User user) {
        String sql = "SELECT * FROM user where email=? and password=?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setString(1, user.getEmail().getValue());
            preparedStatement.setString(2, user.getPassword().getValue());
        };
        return jdbcTemplate.query(sql, preparedStatementSetter, userRowMapper);
    }
}
