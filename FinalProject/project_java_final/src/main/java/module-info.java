module edu.neu.mgen {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.neu.mgen to javafx.fxml;
    exports edu.neu.mgen;
}
