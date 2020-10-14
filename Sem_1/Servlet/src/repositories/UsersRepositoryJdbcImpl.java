package repositories;

import models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_SELECT = "select * from account";

    private DataSource dataSource;

    @Override
    public List<User> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
//            statement.setInt();
            resultSet = statement.executeQuery();

            List<User> users = new ArrayList<>();
            while (resultSet.next()){


            }

        }catch (SQLException e){
            throw new IllegalStateException(e);
        }finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException ignore ){}
            }
            if (statement != null){
                try {
                    statement.close();
                }catch (SQLException ignore){}
            }
             if (connection != null){
                try {
                    connection.close();
                }catch (SQLException ignore){}
            }
        }
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void safe(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(User entity) {

    }
}
