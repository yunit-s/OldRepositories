package lecture.jdbc.di.step5;

import java.sql.Connection;

public interface ConnectionMaker {

	Connection getConnection();
}
