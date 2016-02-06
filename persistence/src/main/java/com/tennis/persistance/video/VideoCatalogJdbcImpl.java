package com.tennis.persistance.video;

import com.tennis.domain.VideoCatalog;
import com.tennis.persistance.user.UserDAOjdbcImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Component
public class VideoCatalogJdbcImpl implements VideoCatalogDAO {
	private static final Logger logger = Logger
			.getLogger(UserDAOjdbcImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public List<VideoCatalog> getAll() {
		List<VideoCatalog> videos = new ArrayList<VideoCatalog>();
		String query = "select * from VideoCatalog";
		VideoCatalog video = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			try {
				while (resultSet.next()) {
					video.setDescription("description");
					video.setVideoID(resultSet.getInt("videoID"));
					video.setUrl(resultSet.getString("url"));
				}
				videos.add(video);
			} finally {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return videos;
	}

}
