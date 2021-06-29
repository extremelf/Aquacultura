module Projeto.javafx {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;
    requires jdk.jfr;
    requires java.persistence;
    exports com.aquacultura;
    exports com.aquacultura.controllers;
    requires net.bytebuddy;
    requires org.slf4j;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;


    opens com.aquacultura to javafx.graphics;
}
