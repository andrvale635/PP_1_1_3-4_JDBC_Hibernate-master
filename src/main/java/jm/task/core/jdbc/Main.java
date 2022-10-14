package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl usi = new UserServiceImpl();
        /////////////////////  OK  ///////////////////
        System.out.println("Создание таблицы");
        usi.createUsersTable();
        System.out.println();

////////////////////////  OK  //////////////////////
        /*System.out.println("Получение всех данных из таблицы");
        usi.getAllUsers();
        System.out.println();*/

////////////////////////  OK  //////////////////////
        /*System.out.println("Удаление таблицы");
        usi.dropUsersTable();
        System.out.println();*/

////////////////////////  OK  //////////////////////
        for (int i = 0; i<4; i++){
            usi.saveUser("New", "Test", (byte) 20);
        }

        usi.getAllUsers();
        System.out.println();


////////////////////////  OK  //////////////////////
        /*System.out.println("удаление user с id = n");
        usi.removeUserById(4);
        usi.getAllUsers();
        System.out.println();*/

////////////////////////  OK  //////////////////////
       /* System.out.println("Отчистка таблицы");
        usi.cleanUsersTable();
        usi.getAllUsers();*/
    }
}