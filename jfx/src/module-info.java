module javafs_practise {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires java.sql;
	opens application to javafx.graphics, javafx.fxml;
}
