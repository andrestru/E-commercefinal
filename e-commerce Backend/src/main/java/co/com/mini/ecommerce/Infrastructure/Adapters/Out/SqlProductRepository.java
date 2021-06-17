package co.com.mini.ecommerce.Infrastructure.Adapters.Out;


import co.com.mini.ecommerce.Common.Generator;
import co.com.mini.ecommerce.Common.NonEmptyDescription;
import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Application.Domain.*;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

@Repository
public class SqlProductRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Product> productRowMapper = (resultSet, i) -> ProductResult(resultSet);

    private Product ProductResult(ResultSet resultSet) throws SQLException {
        return new Product(
                new IdentificationNumber(resultSet.getInt("ProductId")),
                new NonEmptyName(resultSet.getString("Name")),
                new NonEmptyDescription(resultSet.getString("Description")),
                new CheckPrice(resultSet.getDouble("BasePrice")),
                new CheckTaxRate(resultSet.getDouble("TaxRate")),
                ProductStatus.valueOf(resultSet.getString("ProductStatus")),
                new CheckInventory(resultSet.getInt("InventoryQuantity"))
        );
    }

    public SqlProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Product> GetProductId(IdentificationNumber identificationNumber) {
        final String sql = "SELECT * FROM product WHERE ProductId=?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, identificationNumber.getIdentification());
        };
        ResultSetExtractor<Optional<Product>> resultSetExtractor = resultSet ->{
            if(resultSet.next()){
                final Product product = ProductResult(resultSet);
                return Optional.of(product);
            }else{
                return Optional.empty();
            }
        };
        return jdbcTemplate.query(sql, preparedStatementSetter, resultSetExtractor);
    }

    @Override
    public void SavaProduct(Product product) {
        jdbcTemplate.update(connection -> {
            final PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO product(Idp, ProductId, Name, Description, BasePrice, TaxRate, ProductStatus, InventoryQuantity)VALUES(?,?,?,?,?,?,?,?)"
            );
            preparedStatement.setInt(1, Generator.GeneratorId());
            preparedStatement.setInt(2, product.getIdentificationNumber().getIdentification());
            preparedStatement.setString(3, product.getName().getValue());
            preparedStatement.setString(4, product.getDescription().getValue());
            preparedStatement.setDouble(5, product.getBase_Price().getValue());
            preparedStatement.setDouble(6, product.getTax_Rate().getValue());
            preparedStatement.setString(7, product.getProductstatus().name());
            preparedStatement.setInt(8, product.getInventory().getValue());
            return preparedStatement;
        });
    }

    @Override
    public Collection<Product> ListProduct() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, productRowMapper);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from product where ProductId=?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, id);
        };
        jdbcTemplate.update(sql,preparedStatementSetter);
    }

    @Override
    public Collection<Product> GetId(IdentificationNumber identificationNumber) {
        String sql = "SELECT * FROM product where ProductId=?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, identificationNumber.getIdentification());
        };
        return jdbcTemplate.query(sql, preparedStatementSetter, productRowMapper);
    }

    @Override
    public void EditProduct(Product product) {
        jdbcTemplate.update(connection -> {
            final PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE product SET Name=?, Description=?, BasePrice=?, TaxRate=?, ProductStatus=?, InventoryQuantity=? WHERE ProductId=?"
            );
                preparedStatement.setString(1, product.getName().getValue());
                preparedStatement.setString(2, product.getDescription().getValue());
                preparedStatement.setDouble(3, product.getBase_Price().getValue());
                preparedStatement.setDouble(4, product.getTax_Rate().getValue());
                preparedStatement.setString(5, product.getProductstatus().name());
                preparedStatement.setInt(6, product.getInventory().getValue());
                preparedStatement.setInt(7, product.getIdentificationNumber().getIdentification());
                return preparedStatement;
        });
    }

    @Override
    public void EditInventory(int id) {
        String sql = "UPDATE product SET InventoryQuantity=InventoryQuantity-1 WHERE ProductId=?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, id);
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }
}
