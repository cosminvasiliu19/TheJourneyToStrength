package pachet1.tjts;

import pachet2.entity.tjts.Entity;

import java.sql.*;

import static pachet1.tjts.Game.handler;

public class DataBase {
    Connection con = null;

    public DataBase()
    {
        try{
            con = DriverManager.getConnection("jdbc:sqlite:TjtsDB.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save()
    {
        PreparedStatement st = null;
        try{
            String sql = "UPDATE Saves SET PlayerX=?, PlayerY=?, Lives=?, Stars=?";
            st = con.prepareStatement(sql);
            st.setInt(1, Game.playerX);
            st.setInt(2, Game.playerY);
            st.setInt(3,Game.lives);
            st.setInt(4,Game.stars);
            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void load()
    {
        Statement st = null;
        try{
            String sql = "SELECT * FROM SAVES";
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            for(Entity e:handler.entity){
                if(e.getId()==Id.player){
                    e.x = res.getInt("PlayerX");
                    e.y = res.getInt("PlayerY");
                    break;
                }
            }
            Game.lives = res.getInt("Lives");
            Game.stars = res.getInt("Stars");

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
