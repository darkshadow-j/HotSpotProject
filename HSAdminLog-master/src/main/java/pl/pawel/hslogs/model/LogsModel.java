package pl.pawel.hslogs.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.Date;

@Entity(name = "log")
public class LogsModel {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String time;
    private String message;
    private String program;
    @Transient
    String ip;
    @Transient
    String username;
    @Transient
    LogsModel logsModel;
    @Transient
    String telephone;

    public String getIp(boolean get) {
        this.setIp();
        return ip;
    }
    public String getIp() {
        return ip;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LogsModel getLogsModel() {
        return logsModel;
    }

    public void setLogsModel(LogsModel logsModel) {
        this.logsModel = logsModel;
    }

    public void setIp() {
        if(this.message!=null) {
            String r = this.message;
            r = r.substring(0, r.lastIndexOf(">"));
            r = r.substring(0, r.lastIndexOf(":"));
            r = r.substring(r.lastIndexOf(",") + 1).trim();
            this.ip = r;
        }
    }


    public void setUsername() {
        String name = this.message;
        if (name.contains("logged in")) {
            name = name.substring(0, name.lastIndexOf("(")-1).trim();
            this.username = name;
        }
    }

    public String getUsername() {
        this.setUsername();
        return username;
    }


    public LogsModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "LogsModel{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", message='" + message + '\'' +
                ", program='" + program + '\'' +
                ", ip='" + ip + '\'' +
                ", username='" + username + '\'' +
                ", logsModel=" + logsModel +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}

