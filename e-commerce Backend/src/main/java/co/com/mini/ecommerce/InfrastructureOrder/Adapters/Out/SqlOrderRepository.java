package co.com.mini.ecommerce.InfrastructureOrder.Adapters.Out;

import co.com.mini.ecommerce.Application.Domain.CheckPrice;
import co.com.mini.ecommerce.ApplicationOrder.Domain.CCNumber;
import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Common.NonEmptyString;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;


@Repository
public class SqlOrderRepository implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Order> orderRowMapper = (resultSet, i) -> Result(resultSet);

    public SqlOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Order Result(ResultSet resultSet) throws SQLException {
        return new Order(
                new NonEmptyString(resultSet.getString("Number_order")),
                new NonEmptyName(resultSet.getString("Name")),
                new NonEmptyString(resultSet.getString("Address")),
                new CCNumber(resultSet.getInt("Identification")),
                new NonEmptyString(resultSet.getString("OrderStatus")),
                new NonEmptyString(resultSet.getString("Description")),
                new CheckPrice(resultSet.getDouble("total"))
        );
    }

    @Override
    public void SaveOrder(Order order) {
        jdbcTemplate.update(connection -> {
            final PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO orders(Number_order, Name, Address, Identification, OrderStatus, Description, total)VALUES(?,?,?,?,?,?,?)"
            );
            preparedStatement.setString(1, order.getNumber_order().getValue());
            preparedStatement.setString(2, order.getName().getValue());
            preparedStatement.setString(3, order.getAddress().getValue());
            preparedStatement.setInt(4, order.getIdentification().getIdentification());
            preparedStatement.setString(5, order.getOrderstatus().getValue());
            preparedStatement.setString(6, order.getDescription().getValue());
            preparedStatement.setDouble(7, order.getTotal().getValue());
            return preparedStatement;
        });
    }

    @Override
    public Collection<Order> ListOrder() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, orderRowMapper);
    }

    @Override
    public void DeleteOrder(NonEmptyString numOrder) {
        String sql = "DELETE FROM orders WHERE Number_order=?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setString(1, numOrder.getValue());
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }

    @Override
    public Collection<Order> ListNumOrder(NonEmptyString numOrder) {
        String sql = "SELECT * FROM orders WHERE Number_order=?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setString(1, numOrder.getValue());
        };
        return jdbcTemplate.query(sql, preparedStatementSetter, orderRowMapper);
    }

    @Override
    public void EditOrder(Order order) {
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE orders SET Name=?, Address=?, Identification=?, Description=?, total=? WHERE Number_order=?"
            );
            preparedStatement.setString(1, order.getName().getValue());
            preparedStatement.setString(2, order.getAddress().getValue());
            preparedStatement.setInt(3, order.getIdentification().getIdentification());
            preparedStatement.setString(4, order.getDescription().getValue());
            preparedStatement.setDouble(5, order.getTotal().getValue());
            preparedStatement.setString(6, order.getNumber_order().getValue());
            return preparedStatement;
        });
    }

    @Override
    public void EditStatus(NonEmptyString numOrder) {
        String sql = "UPDATE orders SET OrderStatus=? WHERE Number_order=?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setString(1, "Approved");
            preparedStatement.setString(2, numOrder.getValue());
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }

    @Override
    public Collection<Order> GetById(CCNumber id) {
        String sql = "SELECT * FROM orders WHERE Identification=?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, id.getIdentification());
        };
        return jdbcTemplate.query(sql, preparedStatementSetter, orderRowMapper);
    }

}
