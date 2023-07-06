/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Food;

/**
 *
 * @author Hung
 */
public class FoodDAO {

  private Connection conn;
  private PreparedStatement ps;
  private ResultSet rs;

  public FoodDAO() {
    conn = DBConnection.DBConnection.getConnection();
  }

  public ResultSet getAll() {
    String sql = "select * from Food";
    try {
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      return rs;
    } catch (SQLException ex) {
      Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public Food getFood(short foodID) {
    Food food = null;
    try {
      ps = conn.prepareStatement("select * from Food where food_id = ?");
      ps.setShort(1, foodID);
      rs = ps.executeQuery();
      if (rs.next()) {
        food = new Food(rs.getShort("food_id"),
                rs.getString("food_name"),
                rs.getBigDecimal("food_price"),
                rs.getByte("discount_percent"),
                rs.getString("food_img_url"),
                rs.getByte("food_type_id"),
                this.getFoodType(rs.getByte("food_type_id")));
      }
    } catch (SQLException ex) {
      Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return food;
  }

  public int add(Food food) {
    String sql = "insert into Food (food_name, food_price, discount_percent, food_img_url, food_type_id) values (?, ?, ?, ?, ?)";
    int result = 0;
    try {
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, food.getFoodName());
      ps.setBigDecimal(2, food.getFoodPrice());
      ps.setByte(3, food.getDiscountPercent());
      ps.setString(4, food.getImageURL());
      ps.setByte(5, food.getFoodTypeID());
      result = ps.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
  }

  public int delete(short foodID) {
    int result = 0;
    String sql = "delete from Food where food_id = ?";
    try {
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setShort(1, foodID);
      result = ps.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
  }

  public int update(Food food) {
    String sql = "update Food set food_name = ?, food_price = ?, discount_percent = ?, food_img_url = ?, food_type_id = ? where food_id = ?";
    int result = 0;
    try {
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, food.getFoodName());
      ps.setBigDecimal(2, food.getFoodPrice());
      ps.setByte(3, food.getDiscountPercent());
      ps.setString(4, food.getImageURL());
      ps.setByte(5, food.getFoodTypeID());
      ps.setShort(6, food.getFoodID());
      result = ps.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
  }

  public String getFoodType(byte foodTypeID) {
    String foodType = null;
    try {
      ps = conn.prepareStatement("select * from FoodType where food_type_id = ?");
      ps.setByte(1, foodTypeID);
      rs = ps.executeQuery();
      if (rs.next()) {
        foodType = rs.getString("food_type");
      }
    } catch (SQLException ex) {
      Logger.getLogger(FoodTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return foodType;
  }
}