package database.paprica;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Database {

    public static Database db = new Database();
    private Connection connection;

    public static Database getDb() {
        return db;
    }

    public void connect() {
        try {
            //Подтягиваем драйвер, который мы добавили в самом начале урока
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Создаем подключение.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitlab_database?useUnicode=true&serverTimezone=UTC", "root", "");
            System.out.println("CONNECTED");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM users");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nickName = rs.getString("nick_name");
                String password = rs.getString("password");
                double salary = rs.getDouble("salary");

                users.add(new User(id, nickName, password, salary));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public void addUser(User user){
        try{
            //Готовим наш запрос. В полях VALUES(), оставляем ?, чтобы указать, что туда скоро будут добавлены данные.
            //Это нужно, чтобы мы могли удобно вставить данные объекта car в наш запрос
            PreparedStatement st = connection.prepareStatement("INSERT INTO users(nick_Name, password, salary) values(?,?,?)");

            //Вводим данные машины в эти вопросительные знаки. Сначала указываем номер знака и потом само значение
            st.setString(1,user.getNickName());
            st.setString(2,user.getPassword());
            st.setDouble(3,user.getSalary());

            //Запускаем запрос на добавление данных
            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateUser(User user){
        try{
            //Готовим наш запрос. В полях VALUES(), оставляем ?, чтобы указать, что туда скоро будут добавлены данные.
            //Это нужно, чтобы мы могли удобно вставить данные объекта user в наш запрос
            PreparedStatement st = connection.prepareStatement("UPDATE cars set nick_name = ?, password = ?, salary = ? where id = ?");

            //Вводим данные машины в эти вопросительные знаки. Сначала указываем номер знака и потом само значение
            st.setString(1, user.getNickName());
            st.setString(2, user.getPassword());
            st.setDouble(3, user.getSalary());
            st.setLong(4, user.getId());

            //Запускаем запрос на обновление данных
            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteUser(int id){
        try{
            //Готовим наш запрос. В полях VALUES(), оставляем ?, чтобы указать, что туда скоро будут добавлены данные.
            //Это нужно, чтобы мы могли удобно вставить данные объекта car в наш запрос
            PreparedStatement st = connection.prepareStatement("DELETE FROM users where id = ?");

            //Вводим данные машины в эти вопросительные знаки. Сначала указываем номер знака и потом само значение
            st.setInt(1, id);
            //Запускаем запрос на удаление данных
            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

