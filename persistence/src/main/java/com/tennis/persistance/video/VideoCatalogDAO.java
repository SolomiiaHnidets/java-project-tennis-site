package com.tennis.persistance.video;

import java.util.List;
import com.tennis.domain.VideoCatalog;

public interface VideoCatalogDAO {

	List<VideoCatalog> getAll();
}
